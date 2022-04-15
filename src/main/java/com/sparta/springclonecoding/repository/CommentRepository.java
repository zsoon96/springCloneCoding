package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
