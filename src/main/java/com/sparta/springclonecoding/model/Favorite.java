package com.sparta.springclonecoding.model;

import com.sparta.springclonecoding.dto.LikeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private Long userid;

    public Favorite(LikeDto likeDto){
        this.userid = likeDto.getUserid();
    }
}