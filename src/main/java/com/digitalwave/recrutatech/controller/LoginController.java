package com.digitalwave.recrutatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.security.Login;
import com.digitalwave.recrutatech.security.Token;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public Login authenticate(@RequestBody Login login) throws JsonProcessingException {
      Authentication auth = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
      auth = authenticationManager.authenticate(auth);
      login.setToken(Token.generateToken(auth));
      login.setAuth(auth.getAuthorities().iterator().next().getAuthority());
      return login;
    }

    @GetMapping
    public String message() {
        return "Login page. Use POST.";
    }
}