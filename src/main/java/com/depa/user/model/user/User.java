package com.depa.user.model.user;

import com.depa.user.security.config.AuthProvider;
import org.bson.types.ObjectId;

public interface User {

    String getEmail();

    String getDisplayName();

    String getAuthProvider();

    ObjectId getId();

    String getPassword();

    void setPassword(String password);

    String getProvider();

    void setProvider(AuthProvider provider);

    void setProviderId(String providerId);

    void setName(String name);

    void setEmail(String email);

    void setImageUrl(String imageUrl);
}
