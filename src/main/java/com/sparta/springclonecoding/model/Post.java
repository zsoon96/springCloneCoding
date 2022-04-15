package com.sparta.springclonecoding.model;



import com.sparta.springclonecoding.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@ToString
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private Long userId;

    private String imageUrl;

    private String content;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Comment> comments =new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "like_id")
    private List<Like> likes = new ArrayList<>();

//    @CreatedDate
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDateTime createdAt;

    public Post(PostRequestDto postRequestDto, Long userid){
        this.imageUrl = postRequestDto.getImage();
        this.content = postRequestDto.getContent();
        this.userId = userid;
    }
}