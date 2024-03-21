package com.example.bankingapp.service;

import com.example.bankingapp.model.User;

public interface UserService {
    User createUser(User user);
    User login(String username, String password);


}
