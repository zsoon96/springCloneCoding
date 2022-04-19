package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.model.Follow;
import com.sparta.springclonecoding.model.User;
import com.sparta.springclonecoding.repository.FollowRepository;
import com.sparta.springclonecoding.repository.UserRepository;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class FollowService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    // 팔로우 하기
    @Transactional
    public Follow save(Long touserid, UserDetailsImpl userDetails) {
        // 현재 로그인된 유저 정보
        User fromUser = userDetails.getUser();
        // 팔로우 할 유저 정보
        User toUser = userRepository.findById(touserid).get();

        return new Follow(fromUser, toUser);
    }

    // 언팔로우
    @Transactional
    public Long unfollow(Long touserid, UserDetailsImpl userDetails) {
        // 현재 로그인된 유저 정보
        User fromUser = userDetails.getUser();
        // 언팔로우 할 유저 정보
        User toUser = userRepository.findById(touserid).get();

        Follow follow = followRepository.findByFromUserAndToUser(fromUser, toUser);

        if (follow != null) {
            return follow.getId();
        }
        return -1L;

    }
}
