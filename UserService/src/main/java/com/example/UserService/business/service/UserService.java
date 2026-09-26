package com.example.UserService.business.service;



import com.example.UserService.business.dto.UserRequestDTO;
import com.example.UserService.business.dto.UserRequestDTOa;
import com.example.UserService.integration.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    String createUser(UserRequestDTOa user);

    List<UserRequestDTOa> getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}