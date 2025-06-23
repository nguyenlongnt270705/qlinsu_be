package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        // Xác thực user, sinh JWT và trả về
        return "jwt-token";
    }
}

class LoginRequest {
    public String email;
    public String password;
}