package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.DetailDto;
import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.dto.ProfileDto;
import com.sparta.springclonecoding.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/api/posts")
    public String registPost(@RequestBody PostRequestDto postRequestDto){
            postService.registPost(postRequestDto);
        return "등록완료";
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
}
