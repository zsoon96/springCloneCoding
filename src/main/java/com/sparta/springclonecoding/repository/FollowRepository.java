package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Follow;
import com.sparta.springclonecoding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    List<Follow> findAllByFromUser(User fromUser);
    List<Follow> findAllByToUser(User toUser);

    Long countAllByFromUser(User FromUser);
    Long countAllByToUser(User ToUser);

    void deleteByFromUserAndToUser(User fromUser, User toUser);

    boolean existsByFromUserAndToUser(User fromUser, User toUser);

}
