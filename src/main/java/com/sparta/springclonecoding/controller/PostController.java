package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.DetailDto;
import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.dto.PostResponseDto;
import com.sparta.springclonecoding.dto.ProfileDto;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
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
    
    @GetMapping("/api/posts/mypost/{userid}")
    public ProfileDto showProfile(@PathVariable Long userid){
       return postService.showProfile(userid);
    }

    @GetMapping("/api/detail/{postid}/{userid}")
    public DetailDto showDetail(@PathVariable Long postid,
                                @PathVariable Long userid){
        return postService.showDetail(postid,userid);
    }
//
//    @PutMapping("/api/posts/{postid}")
//    public Long updatePost (@PathVariable Long postid, )
}
