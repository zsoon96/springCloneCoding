package com.sparta.springclonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FollowDto {
    private String nickname;
    private String profile;
    private boolean followState;
    private boolean isLoginUser;

    public FollowDto(UserResponseDto followUserDto, boolean followState, boolean isLoginUser) {
        this.nickname = followUserDto.getNickname();
        this.profile = followUserDto.getProfile();
        this.followState = followState;
        this.isLoginUser = isLoginUser;
    }
}
