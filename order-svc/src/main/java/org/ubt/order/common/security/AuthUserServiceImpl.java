package org.ubt.order.common.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.ubt.order.common.security.jwt.JwtAuthenticator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
@Lazy
public class AuthUserServiceImpl implements AuthUserService{


    private Optional<JwtAuthenticator> getTokenOptional() {
        try {
            JwtAuthenticator details = ((JwtAuthenticator) (SecurityContextHolder.getContext().getAuthentication()));
            return Optional.of(details);
        } catch (Exception exception) {
            log.error("Failed to retrieve token from context : ", exception);
            return Optional.empty();
        }
    }

    @Override
    public String getUserId() {
        return getTokenOptional().isPresent() ? getTokenOptional().get().getClaims().get("client_id").toString() : null;
    }

    @Override
    public String getUsername() {
        return getTokenOptional().isPresent() ? getTokenOptional().get().getClaims().get("username").toString() : null;

    }

    @Override
    public String getEmail() {
        return getTokenOptional().isPresent() ? getTokenOptional().get().getClaims().get("username").toString() : null;
    }

    @Override
    public List<String> getRoles() {
        if (getTokenOptional().isPresent()) {
            String listOfClaims = getTokenOptional().get().getClaims().get("cognito:groups").toString();

            if(listOfClaims ==null || listOfClaims.isEmpty()){
                return  null;
            }

            listOfClaims.replace("[","");
            listOfClaims.replace("]","");

            List<String> roles= Arrays.stream(listOfClaims.split(",")).collect(Collectors.toList());

            return roles.stream().map(roless->{
                roless.replace("[","");
                roless.replace("]","");
                return roless;
            }).collect(Collectors.toList());
        }

        return new ArrayList<String>();
    }
}
