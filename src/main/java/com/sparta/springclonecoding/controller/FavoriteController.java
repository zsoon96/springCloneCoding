package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.security.UserDetailsImpl;
import com.sparta.springclonecoding.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FavoriteController {
    private final FavoriteService favoriteService;

    @ExceptionHandler(IllegalArgumentException.class)
    public String nullex(IllegalArgumentException e) {
        return e.getMessage();
    }

    @PostMapping("/api/like/{postid}")
    public String pressLike(@PathVariable Long postid,
                            @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long userid = userDetails.getUser().getId();
        favoriteService.pressLike(postid,userid);
        return "좋아요 눌름";
    }

    @DeleteMapping("/api/like/{postid}")
    public String unpresslike(@PathVariable Long postid,
                              @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long userid = userDetails.getUser().getId();
        favoriteService.unpressLike(postid,userid);
        return "좋아요 취소";
    }
}
