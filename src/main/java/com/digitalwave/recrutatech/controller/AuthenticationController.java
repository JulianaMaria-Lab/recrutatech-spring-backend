package com.digitalwave.recrutatech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.dto.AuthenticationDTO;
import com.digitalwave.recrutatech.entity.User;
import com.digitalwave.recrutatech.service.TokenService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody AuthenticationDTO authenticationDTO) {

        var userNamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());
        var authentication =  this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) authentication.getPrincipal());
        
        return token;
    }

}