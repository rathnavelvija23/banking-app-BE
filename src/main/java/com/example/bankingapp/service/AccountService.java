package com.example.bankingapp.service;

import com.example.bankingapp.model.Account;

public interface AccountService {
        void deposit(String accountId, Double amount);
        void withdraw(String accountId, Double amount);

        Account createAccount(Account account);
    }
