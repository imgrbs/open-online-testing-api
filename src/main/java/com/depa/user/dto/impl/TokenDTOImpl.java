package com.depa.user.dto.impl;

import com.depa.user.dto.TokenDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTOImpl implements TokenDTO {
    private String accessToken;
    private String refreshToken;
}
