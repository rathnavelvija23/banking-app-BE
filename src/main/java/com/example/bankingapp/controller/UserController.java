package com.example.bankingapp.controller;

import com.example.bankingapp.model.User;
import com.example.bankingapp.request.LoginRequest;
import com.example.bankingapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userServiceImpl.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body( "The User ::" + user.getUsername() + "::Created Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        User user = userServiceImpl.login(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(user);
    }
}
