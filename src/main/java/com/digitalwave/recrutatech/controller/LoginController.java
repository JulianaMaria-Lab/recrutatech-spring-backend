package com.digitalwave.recrutatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.entity.Usuario;
import com.digitalwave.recrutatech.security.Login;
import com.digitalwave.recrutatech.security.Token;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  Token token;

  @PostMapping
  public ResponseEntity<String> authenticate(@RequestBody Login login) {
    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        // Se a autenticação for bem-sucedida, você pode retornar uma mensagem de sucesso ou qualquer outra resposta desejada.
        String successMessage = "Autenticação bem-sucedida";
        return ResponseEntity.ok(successMessage);

    } catch (AuthenticationException e) {
        // Se a autenticação falhar, você pode retornar uma resposta de erro apropriada.
        String errorMessage = "Credenciais inválidas";
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }
  }
  
}