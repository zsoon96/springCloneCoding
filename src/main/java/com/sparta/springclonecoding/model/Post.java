package com.sparta.springclonecoding.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Post {
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

    @OneToMany
    @JoinColumn
    private List<Like> likes = new ArrayList<>();

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

}
