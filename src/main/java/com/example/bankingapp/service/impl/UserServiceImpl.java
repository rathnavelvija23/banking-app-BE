package com.example.bankingapp.service.impl;

import com.example.bankingapp.model.User;
import com.example.bankingapp.repo.UserRepository;
import com.example.bankingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        // Check if username is already taken
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        // Find user by username
        User user = userRepository.findByUsername(username);

        // Check if user exists and password matches
        if (user != null ) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

}
