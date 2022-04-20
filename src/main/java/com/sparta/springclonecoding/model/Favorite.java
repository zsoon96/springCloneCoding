package com.sparta.springclonecoding.model;

import com.sparta.springclonecoding.dto.FavoriteDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@IdClass(FavoriteId.class)
public class Favorite {
    @Id
    @Column
    private Long userid;

    @Id
    @Column
    private Long postid;

    public Favorite(FavoriteDto favoriteDto){
        this.postid= favoriteDto.getPostid();
        this.userid = favoriteDto.getUserid();
    }
}
