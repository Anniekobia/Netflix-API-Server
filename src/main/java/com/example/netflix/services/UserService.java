package com.example.netflix.services;

import com.example.netflix.model.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User create(User user);

    User findByIdentification(Long identification);
}
