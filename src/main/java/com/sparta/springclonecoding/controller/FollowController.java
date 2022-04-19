//package com.sparta.springclonecoding.controller;
//
//import com.sparta.springclonecoding.model.Follow;
//import com.sparta.springclonecoding.security.UserDetailsImpl;
//import com.sparta.springclonecoding.service.FollowService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class FollowController {
//
//    private final FollowService followService;
//    // 팔로우
//    @PostMapping("/follow/{touserid}")
//    public Follow followUser(@PathVariable Long touserid, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return followService.save(touserid, userDetails);
//    }
//
//    // 언팔로우
//    @DeleteMapping("/follow/{touserid}")
//    public Long unfollowUser(@PathVariable Long touserid, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return followService.unfollow(touserid, userDetails);
//    }
//}
