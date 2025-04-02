package com.example.fintech.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.fintech.model.Account;

@Repository
public class AccountRepository {
    private final Map<String, Account> accounts = new HashMap<>();  //hash map da conta

    public Account save(Account account) {
        accounts.put(account.getAccountId(), account);
        return account;
    }

    public Account findById(String accountId) {
        return accounts.get(accountId);
    }
}