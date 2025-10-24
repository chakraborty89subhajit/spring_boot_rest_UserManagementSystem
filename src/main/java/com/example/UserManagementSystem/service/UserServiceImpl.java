package com.example.UserManagementSystem.service;

import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        User saveUser= userRepository.save(user);
        return saveUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers= userRepository.findAll();
        return allUsers;
    }

    @Override
    public User updateUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {

        Optional<User>  findUserById = userRepository.findById(userId);
        if(findUserById.isPresent()){
            User user = findUserById.get();
            userRepository.delete(user);
        }
    }

    @Override
    public User getUserById(int userId) {

        Optional<User> findByUserId = userRepository.findById(userId);
        if(findByUserId.isPresent()){
            return findByUserId.get();

        }
        return null;
    }
}
