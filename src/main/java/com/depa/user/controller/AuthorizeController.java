package com.depa.user.controller;

import com.depa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/oauth2")
public class AuthorizeController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/user")
    public Object user(Authentication authentication) {
        return userService.getUser(authentication);
    }

    @GetMapping(value = "/auth")
    public Object auth(@RequestParam Map<String, String> params, HttpServletRequest request) {
        return new Object();
    }

    @GetMapping(value = "/token")
    public ResponseEntity getToken(OAuth2AuthenticationToken authentication) {
        if (!authentication.isAuthenticated()) {
            return loginFailed();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "/token")
    public ResponseEntity principal(Principal principal) {
        return new ResponseEntity<>(principal, HttpStatus.OK);
    }

    @GetMapping(value = "/failed")
    public ResponseEntity loginFailed() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}


