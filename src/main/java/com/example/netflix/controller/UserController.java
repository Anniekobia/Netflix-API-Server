package com.example.netflix.controller;

import com.example.netflix.model.User;
import com.example.netflix.services.MovieService;
import com.example.netflix.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "register")
    public User registerUser(User user){
        return userService.create(user);
    }
}
