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

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String profile;

    private String nickname;

    @OneToMany
    @JoinColumn
    private List<Post> posts;
}
