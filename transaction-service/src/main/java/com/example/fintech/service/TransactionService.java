package com.example.fintech.service;

import com.example.fintech.model.Account;
import com.example.fintech.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(String accountId, String owner) {
        Account account = new Account(accountId, owner);
        return accountRepository.save(account);
    }

    public Account getAccount(String accountId) {
        return accountRepository.findById(accountId);
    }

    public boolean deposit(String accountId, double amount) {
        Account account = accountRepository.findById(accountId);
        if (account != null) {
            return account.deposit(amount);
        }
        return false;
    }

    public boolean withdraw(String accountId, double amount) {
        Account account = accountRepository.findById(accountId);
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }
}