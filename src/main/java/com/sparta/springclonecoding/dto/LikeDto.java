package com.sparta.springclonecoding.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDto {
    private Long userid;

    public LikeDto(Long userid){
        this.userid = userid;
    }
}
