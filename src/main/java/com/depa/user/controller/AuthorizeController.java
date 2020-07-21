package com.depa.user.controller;

import com.depa.user.dto.OAuthParams;
import com.depa.user.dto.TokenDTO;
import com.depa.user.dto.impl.UserDTOImpl;
import com.depa.user.security.service.TokenService;
import com.depa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/oauth2")
public class AuthorizeController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @GetMapping(value = "/user")
    public Object user(Authentication authentication) {
        return userService.getUser(authentication);
    }

    @GetMapping(value = "/auth")
    public ModelAndView auth(@RequestParam Map<String, String> params, HttpServletRequest request) {
        OAuthParams authParams = new OAuthParams(params);
        UserDTOImpl user = new UserDTOImpl("depa", "secret");
        TokenDTO token = tokenService.createToken(user);
        request.setAttribute("access_token", token.getAccessToken());
        request.setAttribute("refresh_token", token.getRefreshToken());
        return new ModelAndView(authParams.getRedirectUri());
    }

    @GetMapping(value = "/token")
    public ResponseEntity getToken(OAuth2AuthenticationToken authentication) {
        if (!authentication.isAuthenticated()) {
            return loginFailed();
        }
        return new ResponseEntity<>(tokenService.getToken(), HttpStatus.OK);
    }

    @GetMapping(value = "/failed")
    public ResponseEntity loginFailed() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}


