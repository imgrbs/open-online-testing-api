package com.depa.user.model.user.impl;

import com.depa.user.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class UserImpl implements User {
    private String email;
    private String displayName;
}
