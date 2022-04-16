package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.DetailDto;
import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.dto.PostResponseDto;
import com.sparta.springclonecoding.dto.ProfileDto;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import com.sparta.springclonecoding.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    // 게시글 작성
    @PostMapping("/api/posts")

    public Post savePost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.postPost(postRequestDto, userDetails);
    }

    // 게시글 조회
    @GetMapping("/api/posts")
    public List<PostResponseDto> showPost(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.getPost(userDetails);
    }

    // 게시글 수정
    @PutMapping("/api/posts/{postId}")
    public Long updatePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto) {
        return postService.putPost(postId, postRequestDto);
    }

    // 게시글 삭제
    @DeleteMapping("/api/posts/{postId}")
    public Long deletePost(@PathVariable Long postId) {
        return postService.delPost(postId);
    }


    // 프로필 보기
    @GetMapping("/api/posts/mypost")
    public ProfileDto showProfile(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.showProfile(userDetails);
    }

    // 상세페이지
    @GetMapping("/api/detail/{postid}")
    public DetailDto showDetail(@PathVariable Long postid,
                                @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.showDetail(postid, userDetails);
    }
}

