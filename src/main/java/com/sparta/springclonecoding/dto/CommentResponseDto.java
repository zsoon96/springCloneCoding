package com.sparta.springclonecoding.dto;

import com.sparta.springclonecoding.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String content;
    private Long userid;
    private String nickname;

    public CommentResponseDto(Comment comment, String nickname) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userid = comment.getUserid();
        this.nickname = nickname;
    }
}
