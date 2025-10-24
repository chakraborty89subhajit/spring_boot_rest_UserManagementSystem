package com.example.UserManagementSystem.repo;

import com.example.UserManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
