package com.demoproj.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproj.app.model.User;
import com.demoproj.app.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Optional<User> singleUser(String id) {
        return userRepository.findById(id);
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public List<User> usersFromCountry(String country) {
        return userRepository.findByAddressCountry(country);
    }

    public User createUser(User newUser) {
        userRepository.save(newUser);
        return newUser;
    }

    public Optional<User> removeUser(String id) {
        Optional<User> deletedUser = userRepository.findById(id);
        userRepository.deleteById(id);
        return deletedUser;
    }
 }
