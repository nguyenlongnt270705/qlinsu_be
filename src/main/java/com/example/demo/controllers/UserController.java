package com.example.demo.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // Get all users
    public String getAllUser() {
        return "All users";
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
