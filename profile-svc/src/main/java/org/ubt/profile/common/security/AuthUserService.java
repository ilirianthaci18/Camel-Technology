package org.ubt.profile.common.security;

import java.util.List;

public interface AuthUserService {
    String getUserId();
    String getUsername();
    String getEmail();
    List<String> getRoles();
}
