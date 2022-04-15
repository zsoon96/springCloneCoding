package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.repository.LikeRepository;
import com.sparta.springclonecoding.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/api/like/{postid}/{userid}")
    public String pressLike(@PathVariable Long postid,
                            @PathVariable Long userid){
        likeService.pressLike(postid,userid);
        return "좋아요 눌름";
    }

    @DeleteMapping("/api/like/{postid}/{userid}")
    public String unpresslike(@PathVariable Long postid,@PathVariable Long userid){
        likeService.unpressLike(postid,userid);
        return "좋아요 취소";
    }
}
