package com.example.fintech.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fintech.model.Account;
import com.example.fintech.service.TransactionService;

@RestController
@RequestMapping("/api/accounts")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(
            @RequestParam String accountId,
            @RequestParam String owner) {
        Account account = transactionService.createAccount(accountId, owner);
        return ResponseEntity.status(201).body(account);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<?> getBalance(@PathVariable String accountId) {
        Account account = transactionService.getAccount(accountId);
        if (account == null) {
            return ResponseEntity.status(404).body("Conta não encontrada");
        }
        return ResponseEntity.ok(account);
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<?> deposit(
            @PathVariable String accountId,
            @RequestParam double amount) {
        if (transactionService.deposit(accountId, amount)) {
            Account account = transactionService.getAccount(accountId);
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.status(400).body("Depósito inválido ou conta não encontrada");
    }

    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<?> withdraw(
            @PathVariable String accountId,
            @RequestParam double amount) {
        if (transactionService.withdraw(accountId, amount)) {
            Account account = transactionService.getAccount(accountId);
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.status(400).body("Saque inválido ou saldo insuficiente");
    }
}