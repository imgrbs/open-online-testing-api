package com.depa.form.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@RequiredArgsConstructor
@Setter
@Getter
public class User {
    private String email;
    private String display;

    public User(String email, String display) {
        this.email = email;
        this.display = display;
    }
}
