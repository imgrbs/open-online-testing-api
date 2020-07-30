package com.depa.user.model.user;

import com.depa.user.security.config.AuthProvider;

public interface User {

    String getEmail();

    String getDisplayName();

    Long getId();

    String getPassword();

    String getProvider();

    void setProvider(AuthProvider provider);

    void setProviderId(String providerId);

    void setName(String name);

    void setEmail(String email);

    void setImageUrl(String imageUrl);
}
