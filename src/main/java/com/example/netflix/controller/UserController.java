package com.example.netflix.controller;

import com.example.netflix.NotFoundException;
import com.example.netflix.model.User;
import com.example.netflix.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "register")
    public User registerUser(@Valid @RequestBody User user){
        return userService.create(user);
    }
}
