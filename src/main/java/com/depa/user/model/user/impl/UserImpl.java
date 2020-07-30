package com.depa.user.model.user.impl;

import com.depa.user.model.user.User;
import com.depa.user.security.config.AuthProvider;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class UserImpl implements User {
    @Id
    private Long id;
    private String email;
    private String displayName;

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
    public void setImageUrl(String imageUrl) {

    }
}
