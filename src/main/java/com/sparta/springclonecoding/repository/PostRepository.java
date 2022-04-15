package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
