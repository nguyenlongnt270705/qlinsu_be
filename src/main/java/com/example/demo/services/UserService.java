package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<User> fetchAllUser() {
        return userRepository.findAll();
    }

    // Create a new user
    public User handleCreate(User user) {
        return this.userRepository.save(user);
    }

    // Get user by ID
    public User fetchUserById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    // Update an existing user
    public User updateUser(User reqUser) {
        User currentUser = this.fetchUserById(reqUser.getId());
        if (currentUser != null) {
            currentUser.setName(reqUser.getName());
            currentUser.setEmail(reqUser.getEmail());
            currentUser = this.userRepository.save(currentUser);
        }
        return currentUser;
    }

    // Delete a user
    public void handleDelete(Long id) {
        this.userRepository.deleteById(id);
    }
}
