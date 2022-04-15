package com.sparta.springclonecoding.dto;

import com.sparta.springclonecoding.model.Comment;
import com.sparta.springclonecoding.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DetailDto {
    Long postid;
    String content;
    List<Comment> commentList;
    int likes;
    Boolean myLike;

    public DetailDto(Post post,int likes , Boolean myLike){
        this.postid = post.getId();
        this.content = post.getContent();
        this.commentList = post.getComments();
        this.likes = likes;
        this.myLike = myLike;
    }
}
