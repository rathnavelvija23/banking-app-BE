package com.example.bankingapp.service.impl;

import com.example.bankingapp.model.Account;
import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.model.TransactionType;
import com.example.bankingapp.repo.AccountRepository;
import com.example.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public void deposit(String accountId, Double amount) {
        List<Transaction> transactionList = new ArrayList<>();
        Account account = findAccountbyId(accountId);
        Double currentBalance = account.getBalance();
        account.setBalance(currentBalance + amount);
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(LocalDate.now());
        transaction.setType(TransactionType.DEPOSIT);
        transactionList.add(transaction);
        if(account.getTransaction() != null){
            transactionList.addAll(account.getTransaction());
        }
        account.setTransaction(transactionList);
        accountRepository.save(account);
    }


    @Override
    @Transactional
    public void withdraw(String accountId, Double amount) {
        List<Transaction> transactionList = new ArrayList<>();
        Account account = findAccountbyId(accountId);
        Double currentBalance = account.getBalance();
        account.setBalance(currentBalance - amount);
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(LocalDate.now());
        transaction.setType(TransactionType.DEPOSIT);
        transactionList.add(transaction);
        if(account.getTransaction() != null){
            transactionList.addAll(account.getTransaction());
        }
        account.setTransaction(transactionList);
        accountRepository.save(account);
    }

    @Override
    public Account createAccount(Account account) {
       return accountRepository.save(account);
    }

    private Account findAccountbyId(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }

}
