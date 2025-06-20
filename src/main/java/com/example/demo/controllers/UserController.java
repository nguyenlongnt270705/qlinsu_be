package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.implement.UserServiceImpl;
import com.example.demo.utils.errors.IdInvalidException;

@RestController
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userServiceImpl.fetchAllUser());
    }

    // Get user by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = this.userServiceImpl.fetchUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // Create a new user
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = this.userServiceImpl.handleCreate(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // Update an existing user
    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = this.userServiceImpl.fetchUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }

    // Delete a user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws IdInvalidException {
        if (id >= 100) {
            throw new IdInvalidException("Id should be less than 100");
        }
        this.userServiceImpl.handleDelete(id);
        return ResponseEntity.ok("deleted successfully");
    }
}
