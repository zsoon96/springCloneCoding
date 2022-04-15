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

    @PostMapping("/api/posts")
    public Post savePost (@RequestBody PostRequestDto postRequestDto,
                          @AuthenticationPrincipal UserDetailsImpl userDetails) {
       return postService.postPost(postRequestDto,userDetails);
    }

    @GetMapping("/api/posts")
    public List<PostResponseDto> showPost() {
        return postService.getPost();
        
    }

    // 프로필 보기
    @GetMapping("/api/posts/mypost")
    public ProfileDto showProfile(@AuthenticationPrincipal UserDetailsImpl userDetails){
       return postService.showProfile(userDetails);
    }

    @GetMapping("/api/detail/{postid}")
    public DetailDto showDetail(@PathVariable Long postid,
                                @AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.showDetail(postid,userDetails);
    }
//
//    @PutMapping("/api/posts/{postid}")
//    public Long updatePost (@PathVariable Long postid, )
}
