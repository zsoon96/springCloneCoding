package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.FollowDto;
import com.sparta.springclonecoding.model.Follow;
import com.sparta.springclonecoding.model.User;
import com.sparta.springclonecoding.repository.FollowRepository;
import com.sparta.springclonecoding.repository.UserRepository;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class FollowService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    // 팔로우 하기
    @Transactional
    public Follow save(Long userid, UserDetailsImpl userDetails) {
        // 현재 로그인된 유저 정보
        User fromUser = userDetails.getUser();
        // 팔로우 할 유저 정보
        User toUser = userRepository.findById(userid).get();

        return new Follow(fromUser, toUser);
    }

    // 언팔로우
    @Transactional
    public Long unfollow(Long userid, UserDetailsImpl userDetails) {
        // 현재 로그인된 유저 정보
        User fromUser = userDetails.getUser();
        // 언팔로우 할 유저 정보
        User toUser = userRepository.findById(userid).get();

        Follow follow = followRepository.findByFromUserAndToUser(fromUser, toUser);

        if (follow != null) {
            return follow.getId();
        }
        return -1L;
    }

    // 나를 따르는 사람들(팔로워)
    public List<FollowDto> getfollower(Long userid, UserDetailsImpl userDetails) {
        // 로그인 된 유저와 프로필 유저 일치 여부
        boolean loginUser = userid.equals(userDetails.getUser().getId());

        List<Follow> followerList = userRepository.findFollowerById(userid);
        List<FollowDto> followerDtoList = new ArrayList<>();

        for (Follow follower : followerList) {
            String nickname = follower.getFromUser().getNickname();
            String profile = follower.getFromUser().getProfile();

            User user = new User(nickname, profile);

            boolean followState = followRepository.countByFollowerIdAndFollowingId(userid, loginUser) != 0;
            FollowDto followDto = new FollowDto(user, followState, loginUser);
            followerDtoList.add(followDto);

        }
        return followerDtoList;
    }

    // 내가 따르는 사람들(팔로워)
    public List<FollowDto> getfollowing(Long userid, UserDetailsImpl userDetails) {
        // 로그인 된 유저와 프로필 유저 일치 여부
        boolean loginUser = userid.equals(userDetails.getUser().getId());

        List<Follow> followingList = userRepository.findFolloingById(userid);
        List<FollowDto> followingDtoList = new ArrayList<>();

        for (Follow following : followingList) {
            String nickname = following.getFromUser().getNickname();
            String profile = following.getFromUser().getProfile();

            User user = new User(nickname, profile);

            boolean followState = followRepository.countByFollowerIdAndFollowingId(userid, loginUser) != 0;
            FollowDto followDto = new FollowDto(user, followState, loginUser);
            followingDtoList.add(followDto);

        }
        return followingDtoList;
    }
}
