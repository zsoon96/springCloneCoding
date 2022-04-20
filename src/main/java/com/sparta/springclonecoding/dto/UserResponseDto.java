package com.sparta.springclonecoding.dto;

import com.sparta.springclonecoding.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private String username;
    private String nickname;
    private String profile;

    public UserResponseDto(String username, String nickname, String profile) {
        this.username = username;
        this.nickname = nickname;
        this.profile = profile;
    }
}
