package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Follow;
import com.sparta.springclonecoding.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sparta.springclonecoding.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);
//    Optional<User> findByNickname(String nickname);
    User findByPosts(Post post);

    List<Follow> findFollowerById(Long userid);

    List<Follow> findFolloingById(Long userid);

    Optional<User> findByUsername(String username);
}
