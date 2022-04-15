package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.security.UserDetailsImpl;
import com.sparta.springclonecoding.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/api/like/{postid}")
    public String pressLike(@PathVariable Long postid,
                            @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long userid = userDetails.getUser().getId();
        likeService.pressLike(postid,userid);
        return "좋아요 눌름";
    }

    @DeleteMapping("/api/like/{postid}")
    public String unpresslike(@PathVariable Long postid,
                              @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long userid = userDetails.getUser().getId();
        likeService.unpressLike(postid,userid);
        return "좋아요 취소";
    }
}
