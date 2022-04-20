package com.sparta.springclonecoding.dto;

import com.sparta.springclonecoding.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FollowDto {
    private String nickname;
    private String profile;
    private boolean followState;
    private boolean loginUser;

    public FollowDto(User user, boolean followState, boolean loginUser) {
        this.nickname = user.getNickname();
        this.profile = user.getProfile();
        this.followState = followState;
        this.loginUser = loginUser;

    }

}
