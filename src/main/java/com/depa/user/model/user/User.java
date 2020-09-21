package com.depa.user.model.user;

import org.bson.types.ObjectId;

public interface User {

    String getEmail();

    String getDisplayName();

    String getAuthProvider();

    ObjectId getId();

    String getPassword();

    void setPassword(String password);

    String getProvider();

    String getUsername();

    void setProviderId(String providerId);

    void setName(String name);

    void setUsername(String username);

    void setEmail(String email);

    void setImageUrl(String imageUrl);
}
