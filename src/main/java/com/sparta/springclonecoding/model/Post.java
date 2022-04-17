package com.sparta.springclonecoding.model;

import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JoinColumn(name = "commentid")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "favoriteId")
    private List<Favorite> favorites = new ArrayList<>();
  
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    public Post(String content , String imageUrl,UserDetailsImpl userDetails) {
        this.content = content;
        this.imageUrl = imageUrl;
        this.userId = userDetails.getUser().getId();
    }

    public void update(PostRequestDto postRequestDto) {
        this.content = postRequestDto.getContent();

    }
}

