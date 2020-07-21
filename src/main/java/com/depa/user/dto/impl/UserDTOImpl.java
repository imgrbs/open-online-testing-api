package com.depa.user.dto.impl;

import com.depa.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTOImpl implements UserDTO {
    private String username;
    private String password;
}
