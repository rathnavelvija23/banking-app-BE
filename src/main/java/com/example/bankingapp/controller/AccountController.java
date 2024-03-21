package com.example.bankingapp.controller;

import com.example.bankingapp.response.AccountCreationResponse;
import com.example.bankingapp.model.Account;
import com.example.bankingapp.service.AccountService;
import com.example.bankingapp.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountCreationResponse> createAccount(@RequestBody Account account) {
        Account createdAccount = accountServiceImpl.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AccountCreationResponse(createdAccount,"Account created successfully"));
       // return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
    }

    @PutMapping("/{accountId}/deposit")
    public void deposit(@PathVariable String accountId, @RequestParam Double amount) {
        accountServiceImpl.deposit(accountId, amount);
    }

    @PutMapping("/{accountId}/withdraw")
    public void withdraw(@PathVariable String accountId, @RequestParam Double amount) throws Exception {
        accountServiceImpl.withdraw(accountId, amount);
    }
}