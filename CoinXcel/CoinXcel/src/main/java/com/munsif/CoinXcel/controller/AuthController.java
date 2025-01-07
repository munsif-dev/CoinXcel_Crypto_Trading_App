package com.munsif.CoinXcel.controller;

import com.munsif.CoinXcel.Model.User;
import com.munsif.CoinXcel.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    public ResponseEntity<User> register(User user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setFullname(user.getFullname());

        User savedUser = userRepository.save(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
