package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Follow;
import com.sparta.springclonecoding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Follow findByFromUserAndToUser(User fromUser, User toUser);
}
