package com.sparta.springclonecoding.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.springclonecoding.dto.PostRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

//    private Long userId;

    private String imageUrl;

    private String content;

    @Transient // 비즈니스 로직에만 필요 - 매핑 무시
    private Long likeCnt = 0L; // 좋아요 수 (초기화)

    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "like_id")
    private List<Like> likes = new ArrayList<>();


    public Post(PostRequestDto postRequestDto, Long likeCnt) {
        this.content = postRequestDto.getContent();
        this.imageUrl = postRequestDto.getImageUrl();
        this.likeCnt = likeCnt;
    }
}
