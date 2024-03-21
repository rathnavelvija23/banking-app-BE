package com.example.bankingapp.controller;

import com.example.bankingapp.model.User;
import com.example.bankingapp.request.LoginRequest;
import com.example.bankingapp.security.AuthRequest;
import com.example.bankingapp.service.impl.UserServiceImpl;
import com.example.bankingapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

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

    @PostMapping("/authenticate")
    @CrossOrigin(origins = "http://localhost:3000")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            if(authentication.isAuthenticated()){
                return jwtUtil.generateToken(authRequest.getUsername());
            }

        }catch (Exception e){
            throw new Exception("invalid username and password");
        }


        return "Invalid Creds";
    }
}
