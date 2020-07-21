package com.depa.user.controller;

import com.depa.user.dto.OAuthParams;
import com.depa.user.dto.TokenDTO;
import com.depa.user.dto.impl.UserDTOImpl;
import com.depa.user.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/oauth2/code/depa")
    public ModelAndView login(@RequestParam Map<String, String> params, HttpServletRequest request) {
        // TODO: Implement login username & password
        OAuthParams authParams = new OAuthParams(params);
        UserDTOImpl user = new UserDTOImpl("depa", "secret");
        TokenDTO token = tokenService.createToken(user);
        request.setAttribute("access_token", token.getAccessToken());
        request.setAttribute("refresh_token", token.getRefreshToken());
        return new ModelAndView();
    }
}
