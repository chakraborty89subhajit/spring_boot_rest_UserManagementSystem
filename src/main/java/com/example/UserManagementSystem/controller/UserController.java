package com.example.UserManagementSystem.controller;

import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){
         System.out.println(user);
        User savedUser = userService.saveUser(user);

       if(ObjectUtils.isEmpty(savedUser)){
           return new ResponseEntity<>("user not saved",HttpStatus.INTERNAL_SERVER_ERROR);
       }
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("/getusers")
    public ResponseEntity<?> getAllUsers(){
        List<User> allUsers = userService.getAllUser();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User saveUser = userService.saveUser(user);
        if(ObjectUtils.isEmpty(saveUser)){
            return new ResponseEntity<>
                    ("user not updated",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(saveUser,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("delete successfully",HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        User userById= userService.getUserById(id);
        if(ObjectUtils.isEmpty(userById)){
            return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);


        }
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }

}
