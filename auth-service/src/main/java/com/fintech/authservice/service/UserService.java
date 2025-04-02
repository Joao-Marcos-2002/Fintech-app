package com.fintech.authservice.service;

import org.springframework.stereotype.Service;

import com.fintech.authservice.model.UserCredentials;

@Service
public class UserService {

    // Credenciais fixas para testar (elas devem vir do BD)
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    public boolean validateCredentials(UserCredentials credentials) {
        // Verifica se as credenciais estão corretas
        return VALID_USERNAME.equals(credentials.getUsername()) && 
               VALID_PASSWORD.equals(credentials.getPassword());
    }
}