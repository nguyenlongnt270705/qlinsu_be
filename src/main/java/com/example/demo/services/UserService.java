package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> fetchAllUser() {
        return userRepository.findAll();
    }

    public User handleCreate(User user) {
        return this.userRepository.save(user);
    }
}
