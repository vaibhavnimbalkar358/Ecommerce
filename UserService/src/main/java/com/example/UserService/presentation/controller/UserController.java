package com.example.UserService.presentation.controller;

import com.example.UserService.business.dto.UserRequestDTO;
import com.example.UserService.business.dto.UserRequestDTOa;
import com.example.UserService.business.service.UserService;
import com.example.UserService.integration.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private  UserService userService;


    // Create User
    @PostMapping("/user")
    public String createUser(@RequestBody UserRequestDTOa user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public List<UserRequestDTOa> getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    // Update User
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully  from vaibhav ";
    }
}