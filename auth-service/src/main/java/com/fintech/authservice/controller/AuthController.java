package com.fintech.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.authservice.model.UserCredentials;
import com.fintech.authservice.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials) {
        // Usa o UserService para validar as credenciais
        if (userService.validateCredentials(credentials)) {
            return ResponseEntity.ok("Login bem-sucedido! Bem-vindo, " + credentials.getUsername() + "!");
        } else {
            return ResponseEntity.status(401).body("Erro: Usuário ou senha incorretos.");
        }
    }
}