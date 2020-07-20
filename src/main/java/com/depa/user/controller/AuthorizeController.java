package com.depa.user.controller;

import com.depa.user.service.internal.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizeController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/user")
    public Object user(Authentication authentication){
        return userService.getUser(authentication);
    }
}


