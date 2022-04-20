package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Favorite;
import com.sparta.springclonecoding.model.Follow;
import com.sparta.springclonecoding.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Follow findByFromUserAndToUser(User fromUser, User toUser);

    List<Follow> findAllByFromUser(Long userid);
    List<Follow> findAllByToUser(Long userid);

    Long countAllByFromUser(User FromUser);
    Long countAllByToUser(User ToUser);

    void deleteByFromUserAndToUser(User fromUser, User toUser);

    Long countByFromUserAndToUser(Long userid, User toUser);
}
