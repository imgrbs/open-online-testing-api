package com.depa.user.service;

import org.springframework.security.core.Authentication;

public interface UserService {
    String getDisplayName();
    String getEmail();
    Object getUser(Authentication authentication);
}
