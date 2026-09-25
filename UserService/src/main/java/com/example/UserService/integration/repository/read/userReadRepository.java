package com.example.UserService.integration.repository.read;

import com.example.UserService.integration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userReadRepository extends JpaRepository<User,Long> {

}
