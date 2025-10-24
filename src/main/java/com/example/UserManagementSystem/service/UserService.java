package com.example.UserManagementSystem.service;

import com.example.UserManagementSystem.model.User;

import java.util.List;

public interface UserService {
    public  User saveUser(User user);
    public List<User> getAllUser();
    public User updateUser(User user);
    public void deleteUser(int userId);
    public User getUserById(int userId);
}
