package com.example.bankingapp.response;

import com.example.bankingapp.model.Account;

public class AccountCreationResponse {
    private Account account;
    private String message;

    public AccountCreationResponse(Account account, String message) {
        this.account = account;
        this.message = message;
    }
}