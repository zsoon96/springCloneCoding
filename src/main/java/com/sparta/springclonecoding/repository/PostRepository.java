package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    int countAllByUserId(Long userid);

    List<Post> findAllByOrderByIdDesc();
    List<Post> findByUserId(Long userid);
}
