package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {

    List<User> fetchAllUser();

    User handleCreate(User user);

    User fetchUserById(Long id);

    User updateUser(User reqUser);

    void handleDelete(Long id);
}
