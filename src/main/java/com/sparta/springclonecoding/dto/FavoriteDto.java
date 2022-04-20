package com.sparta.springclonecoding.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteDto {
    private Long userid;
    private Long postid;

    public FavoriteDto(Long userid,Long postid){
        this.userid = userid;
        this.postid = postid;
    }
}
