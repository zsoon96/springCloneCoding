//package com.sparta.springclonecoding.service;
//
//import com.sparta.springclonecoding.model.Follow;
//import com.sparta.springclonecoding.model.User;
//import com.sparta.springclonecoding.repository.UserRepository;
//import com.sparta.springclonecoding.security.UserDetailsImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@RequiredArgsConstructor
//@Service
//public class FollowService {
//
//    private final UserRepository userRepository;
//
//    // 팔로우 하기
//    @Transactional
//    public Follow save(Long touserid, UserDetailsImpl userDetails) {
//        User fromUser = userDetails.getUser();
//        User toUser = userRepository.findById(touserid).get();
//
//        return new Follow(fromUser, toUser);
//    }
//
//    @Transactional
//    public Long unfollow(Long touserid, UserDetailsImpl userDetails) {
//        User fromUser = userDetails.getUser();
//        User toUser = userRepository.findById(touserid).get();
//    }
//}
