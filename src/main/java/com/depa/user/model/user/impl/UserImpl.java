package com.depa.user.model.user.impl;

import com.depa.user.model.user.User;
import com.depa.user.security.config.AuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public String getAuthProvider() {
        return provider.toString();
    }

    public String getProvider() {
        return provider.toString();
    }
}
