package com.sparta.springclonecoding.model;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class FavoriteId {
    @Column
    private Long postid;

    @Column
    private Long userid;

    public FavoriteId(Long postid, Long userid){
        this.postid = postid;
        this.userid = userid;
    }
}
