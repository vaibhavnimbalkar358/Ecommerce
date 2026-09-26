package com.example.UserService.business.serviceimpl;

import com.example.UserService.business.dto.UserRequestDTO;
import com.example.UserService.business.dto.UserRequestDTOa;
import com.example.UserService.business.service.UserService;
import com.example.UserService.integration.domain.User;
import com.example.UserService.integration.repository.read.UserReadRepository;
import com.example.UserService.integration.repository.write.UserRepositorywriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositorywriteRepository userWriteRepository;

    @Autowired
    private  UserReadRepository userReadRepository;


    @Override
    public String createUser(UserRequestDTOa user) {
        User newUser = new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
        newUser.setCity(user.getCity());
        newUser.setState(user.getState());
        newUser.setCountry(user.getCountry());

        userWriteRepository.save(newUser);

        return "User profile is created successfully";
    }

    @Override
    public List<User> getAllUsers() {

        return userWriteRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        // Get existing user by ID
        User existingUser = userReadRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id));

        // Update fields
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setCity(user.getCity());
        existingUser.setState(user.getState());
        existingUser.setCountry(user.getCountry());

        // Update address flags
        existingUser.setResidentialAddressFlag(
                user.getResidentialAddressFlag()
        );

        existingUser.setCurrentAddressFlag(
                user.getCurrentAddressFlag()
        );

        existingUser.setWorkAddressFlag(
                user.getWorkAddressFlag()
        );

        // Save using write repository
        return userWriteRepository.save(existingUser);
    }

    @Override
    public List<UserRequestDTOa> getUserById(Long id) {

        User user = userReadRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id));

        UserRequestDTOa response = new UserRequestDTOa();

        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setCity(user.getCity());
        response.setState(user.getState());
        response.setCountry(user.getCountry());

        response.setResidentialAddressFlag(user.getResidentialAddressFlag());
        response.setCurrentAddressFlag(user.getCurrentAddressFlag());
        response.setWorkAddressFlag(user.getWorkAddressFlag());

        return List.of(response);
    }

    @Override
    public void deleteUser(Long id) {

        User existingUser = userWriteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        userWriteRepository.delete(existingUser);
    }
}