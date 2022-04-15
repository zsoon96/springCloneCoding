package com.sparta.springclonecoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sparta.springclonecoding.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
