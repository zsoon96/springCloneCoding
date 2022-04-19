package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.dto.PostResponseDto;
import com.sparta.springclonecoding.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    int countAllByUserId(Long userid);
    Page<PostResponseDto> findByAll(Pageable pageable);
}
