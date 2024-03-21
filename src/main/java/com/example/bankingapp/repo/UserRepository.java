package com.example.bankingapp.repo;

import com.example.bankingapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String userName);
}
