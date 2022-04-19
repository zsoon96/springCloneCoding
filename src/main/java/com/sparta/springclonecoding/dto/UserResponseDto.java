package com.sparta.springclonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private String username;
    private String nickname;

    public UserResponseDto(String username, String nickname) {
        this.username = username;
        this.nickname = nickname;
    }
}
