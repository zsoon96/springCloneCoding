package com.sparta.springclonecoding.dto;

import com.sparta.springclonecoding.model.Comment;
import com.sparta.springclonecoding.model.Favorite;
import com.sparta.springclonecoding.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private String imageUrl;
    private String content;
    private int favoriteCnt; // 좋아요 수
    private int commentCnt; // 댓글 갯수
    private LocalDateTime createdAt;
    private List<Comment> comments;
    private List<Favorite> favorites;

    public PostResponseDto(Post post, int commentCnt) {
        this.imageUrl = post.getImageUrl();
        this.content = post.getContent();
        this.commentCnt = commentCnt;
        this.createdAt = post.getCreatedAt();
    }

    public PostResponseDto(Post post,int commentCnt, int favoriteCnt){
        this.imageUrl = post.getImageUrl();
        this.content = post.getContent();
        this.commentCnt = commentCnt;
        this.favoriteCnt = favoriteCnt;
        this.comments = post.getComments();
        this.createdAt = post.getCreatedAt();
        this.favorites = post.getFavorites();
    }
}
