package com.depa.user.model.user.impl;

import java.nio.file.attribute.UserPrincipal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.depa.user.model.user.User;
import com.depa.user.security.config.AuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document("users")
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class UserImpl implements User, UserPrincipal {
    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String imageUrl;
    private String displayName;
    private AuthProvider provider;
    private String providerId;

    private UserImpl(String email) {
        this.id = new ObjectId().toHexString();
        this.email = email;
    }

    public String getAuthProvider() {
        return provider.toString();
    }

    public String getProvider() {
        return provider.toString();
    }

    public static UserImpl create(String email) {
        return new UserImpl(email);
    };
}
