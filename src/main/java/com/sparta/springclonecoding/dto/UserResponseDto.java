package com.sparta.springclonecoding.dto;

import com.sparta.springclonecoding.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String nickname;
    private String profile;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.profile = user.getProfile();
    }
}
