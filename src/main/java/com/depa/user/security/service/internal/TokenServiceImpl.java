package com.depa.user.security.service.internal;

import com.depa.user.dto.TokenDTO;
import com.depa.user.dto.UserDTO;
import com.depa.user.dto.impl.TokenDTOImpl;
import com.depa.user.security.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public TokenDTO createToken(UserDTO userRequest) {
        return new TokenDTOImpl();
    }

    @Override
    public TokenDTO getToken() {
        return new TokenDTOImpl();
    }
}
