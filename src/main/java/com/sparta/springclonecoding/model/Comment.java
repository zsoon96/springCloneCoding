package com.sparta.springclonecoding.model;

import com.sparta.springclonecoding.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String content;

    private Long userid;

    public Comment(CommentRequestDto commentRequestDto,Long userid){
        this.content = commentRequestDto.getContent();
        this.userid = userid;
    }
}
