package com.sparta.springclonecoding.dto;

import com.sparta.springclonecoding.model.Favorite;
import com.sparta.springclonecoding.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private String imageUrl;
    private String content;
    private int favoriteCnt; // 좋아요 수
    private boolean myLike; // 해당 게시글에 대한 사용자의 좋아요 여부
    private int commentCnt; // 댓글 갯수
    private LocalDateTime createdAt;

    public PostResponseDto(Post post, int commentCnt, int favoriteCnt, boolean myLike) {
        this.imageUrl = post.getImageUrl();
        this.content = post.getContent();
        this.favoriteCnt = favoriteCnt;
        this.myLike = myLike;
        this.commentCnt = commentCnt;
        this.createdAt = post.getCreatedAt();
    }
}
