package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.dto.PostResponseDto;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import com.sparta.springclonecoding.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/posts")
    public Post savePost (@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
       return postService.postPost(postRequestDto, userDetails);
    }

    @GetMapping("/api/posts")
    public List<PostResponseDto> showPost(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.getPost(userDetails);
    }

    @PutMapping("/api/posts/{postId}")
    public Long updatePost (@PathVariable Long postId,@RequestBody PostRequestDto postRequestDto ) {
        return postService.putPost(postId, postRequestDto);
    }

    @DeleteMapping("/api/posts/{postId}")
    public Long deletePost (@PathVariable Long postId){
        return postService.delPost(postId);
    }
}
