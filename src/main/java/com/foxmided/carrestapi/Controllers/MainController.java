package com.foxmided.carrestapi.Controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping(value = "/")
    @ResponseBody
    public String home(final Authentication authentication) {
        TestingAuthenticationToken token = (TestingAuthenticationToken) authentication;
        DecodedJWT jwt = JWT.decode(token.getCredentials().toString());
        String email = jwt.getClaims().get("email").asString();
        return "Welcome, " + email + "!";
    }

}
