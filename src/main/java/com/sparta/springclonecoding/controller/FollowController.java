package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.FollowDto;
import com.sparta.springclonecoding.model.Follow;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import com.sparta.springclonecoding.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FollowController {

    private final FollowService followService;
    // 팔로우
    @PostMapping("/follow/{userid}")
    public Follow followUser(@PathVariable Long userid, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return followService.save(userid, userDetails);
    }

    // 언팔로우
    @DeleteMapping("/follow/{userid}")
    public Long unfollowUser(@PathVariable Long userid, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return followService.unfollow(userid, userDetails);
    }

    // 팔로워 조회
   @GetMapping("/follow/{userid}/follower")
    public List<FollowDto> getFollower(@PathVariable Long userid, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return followService.getfollower(userid, userDetails);
    }

    // 팔로잉 조회
    @GetMapping("/follow/{userid}/following")
    public List<FollowDto> getFollowing(@PathVariable Long userid, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return followService.getfollowing(userid, userDetails);
    }
}
