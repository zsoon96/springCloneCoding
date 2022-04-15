package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.dto.PostResponseDto;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/posts")
    public Post savePost (@RequestBody PostRequestDto postRequestDto) {
       return postService.postPost(postRequestDto);
    }

    @GetMapping("/api/posts")
    public List<PostResponseDto> showPost() {
        return postService.getPost();
    }
//
//    @PutMapping("/api/posts/{postid}")
//    public Long updatePost (@PathVariable Long postid, )
}
