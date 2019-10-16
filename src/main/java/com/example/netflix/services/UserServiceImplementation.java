package com.example.netflix.services;

import com.example.netflix.EntityExistsException;
import com.example.netflix.model.User;
import com.example.netflix.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        User existingUserId = userRepository.findByIdentificationNumber(user.getIdentificationNumber());
        if(existingUserId==null){
            return userRepository.save(user);
        }else {
            throw new EntityExistsException("A user with this identification number exists");
        }
    }

    @Override
    public User findByIdentification(Long identification) {
        return userRepository.findByIdentificationNumber(identification);
    }


}
