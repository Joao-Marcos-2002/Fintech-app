package com.example.fintech.model;

public class Account {
    private String accountId;
    private String owner;
    private double balance;

    public Account(String accountId, String owner) {
        this.accountId = accountId;
        this.owner = owner;
        this.balance = 0.0;
    }

    public String getAccountId() { return accountId; }
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
}