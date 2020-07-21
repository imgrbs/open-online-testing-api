package com.depa.user.security.service;

import com.depa.user.dto.TokenDTO;
import com.depa.user.dto.UserDTO;

public interface TokenService {
    TokenDTO createToken(UserDTO userRequest);

    TokenDTO getToken();
}
