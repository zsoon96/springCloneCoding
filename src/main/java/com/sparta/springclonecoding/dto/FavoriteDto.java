package com.sparta.springclonecoding.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteDto {
    private Long userid;

    public FavoriteDto(Long userid){
        this.userid = userid;
    }
}
