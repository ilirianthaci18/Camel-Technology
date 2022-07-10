package org.ubt.calculator.common.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
//@Slf4j
//public class JwtFilter extends OncePerRequestFilter{
//    JwtProvider jwtProvider;
//
//    public JwtFilter(JwtProvider jwtProvider) {
//        this.jwtProvider = jwtProvider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws ServletException, IOException {
//           Authentication authentication;
//        try {
//            authentication = jwtProvider.authenticate(request);
//
//            if (authentication != null) {
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        } catch (Exception e) {
//            log.info("Fail in filter", e);
//        }
//        filterChain.doFilter(request, response);
//    }
//    }
//}
