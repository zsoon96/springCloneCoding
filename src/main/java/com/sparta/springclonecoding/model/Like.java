package com.sparta.springclonecoding.model;

import com.sparta.springclonecoding.dto.LikeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    private Long userid;

    public Like(LikeDto likeDto){
        this.userid = likeDto.getUserid();
    }
}
