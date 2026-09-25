package com.example.UserService.integration.repository.write;

import com.example.UserService.integration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorywriteRepository extends JpaRepository<User, Long> {

}