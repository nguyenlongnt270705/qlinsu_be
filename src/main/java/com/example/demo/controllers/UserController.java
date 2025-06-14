package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.fetchAllUser());
    }

    // Get user by ID
    public String getUserById() {
        return "User by ID";
    }

    // Create a new user
    public String createUser() {
        return "User created";
    }

    // Update an existing user
    public String updateUser() {
        return "User updated";
    }

    // Delete a user
    public String deleteUser() {
        return "User deleted";
    }
}
