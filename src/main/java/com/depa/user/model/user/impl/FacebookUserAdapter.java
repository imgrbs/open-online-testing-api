package com.depa.user.model.user.impl;

import com.depa.user.model.user.User;
import com.depa.user.security.config.AuthProvider;

public class FacebookUserAdapter implements User {
    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getProvider() {
        return null;
    }

    @Override
    public void setProvider(AuthProvider provider) {

    }

    @Override
    public void setProviderId(String providerId) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public void setImageUrl(String imageUrl) {

    }
}
