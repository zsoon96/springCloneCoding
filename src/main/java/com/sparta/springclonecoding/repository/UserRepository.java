package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
