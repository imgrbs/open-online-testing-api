package com.depa.user.model.user.impl;

import com.depa.user.model.user.User;
import com.depa.user.security.config.AuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;

import java.util.Collection;

@Document("users")
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class UserImpl implements User {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private String imageUrl;
    private String displayName;
    private AuthProvider provider;
    private String providerId;

    private UserImpl(String email) {
        this.id = new ObjectId();
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
