package com.example.bankingapp.repo;

import com.example.bankingapp.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface AccountRepository extends MongoRepository<Account, String> {



}
