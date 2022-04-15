package com.sparta.springclonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IsDto {
    private String username;
    private String nickname;

    public IsDto(String username, String nickname) {
        this.username = username;
        this.nickname = nickname;
    }
}
