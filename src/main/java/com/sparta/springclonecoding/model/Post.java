package com.sparta.springclonecoding.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.springclonecoding.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private Long userId;

    private String imageUrl;

    private String content;

    @OneToMany
    @JoinColumn
    private List<Comment> comments = new ArrayList<>();

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @OneToMany
    @JoinColumn
    private List<Favorite> favorites = new ArrayList<>();

    public Post(PostRequestDto postRequestDto, Long userid){
        this.imageUrl = postRequestDto.getImageUrl();
        this.content = postRequestDto.getContent();
        this.userId = userid;
    }
}

