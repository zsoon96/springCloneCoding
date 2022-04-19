package com.sparta.springclonecoding.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;

    private String profile;

    @OneToMany
    @JoinColumn
    private List<Post> posts = new ArrayList<>();

    @OneToMany
    @JoinColumn
    private List<Favorite> favorites = new ArrayList<>();

    private String nickname;

    public User(String username, String nickname, String password,String profile) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.profile = profile;
    }

    public void update(String imageUrl) {
        this.profile = imageUrl;
    }
}
