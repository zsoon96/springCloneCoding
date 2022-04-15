package com.sparta.springclonecoding.dto;

import com.sparta.springclonecoding.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private String imageUrl;
    private String content;
    private int likeCnt; // 좋아요 수
//    private Boolean myLike; // 해당 게시글에 대한 사용자의 좋아요 여부
    private int commentCnt; // 댓글 갯수
    private LocalDateTime createdAt;

    public PostResponseDto(Post post, int commentCnt) {
        this.imageUrl = post.getImageUrl();
        this.content = post.getContent();
//        this.likeCnt = likeCnt;
        this.commentCnt = commentCnt;
        this.createdAt = post.getCreatedAt();
    }
    public PostResponseDto(Post post,int likeCnt, int commentCnt){
        this.imageUrl = post.getImageUrl();
        this.content = post.getContent();
        this.commentCnt = commentCnt;
        this.likeCnt = likeCnt;
        this.createdAt = post.getCreatedAt();
    }
}
