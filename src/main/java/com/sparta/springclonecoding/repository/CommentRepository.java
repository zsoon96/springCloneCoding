package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByIdOrderByIdDesc(Long postid);
}
