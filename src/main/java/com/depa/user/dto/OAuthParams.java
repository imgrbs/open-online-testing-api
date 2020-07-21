package com.depa.user.dto;

import lombok.Data;

import java.util.Map;

@Data
public class OAuthParams {
    private String responseType;
    private String clientId;
    private String state;
    private String redirectUri;
    private String codeChallengeMethod;
    private String codeChallenge;

    public OAuthParams(Map<String, String> params) {
        this.responseType = params.get("response_type");
        this.clientId = params.get("client_id");
        this.state = params.get("state");
        this.redirectUri = params.get("redirect_uri");
        this.codeChallengeMethod = params.get("code_challenge_method");
        this.codeChallenge = params.get("code_challenge");
    }
}
