package org.ubt.product.common.security.jwt;

import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

public class JwtAuthenticator extends AbstractAuthenticationToken {
    private final Object principal;
    private final JWTClaimsSet claims;

    public JwtAuthenticator(Collection<? extends GrantedAuthority> authorities, Object principal, JWTClaimsSet claims) {
        super(authorities);
        this.principal = principal;
        this.claims = claims;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public Map<String, Object> getClaims() {
        return this.claims.getClaims();
    }
}
