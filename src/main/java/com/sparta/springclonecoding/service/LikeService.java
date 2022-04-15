package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.FavoriteDto;

import com.sparta.springclonecoding.model.Favorite;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.repository.FavoriteRepository;
import com.sparta.springclonecoding.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class LikeService {
    private final FavoriteRepository likeRepository;
    private final PostRepository postRepository;

    public void pressLike(Long postid, Long userid){
        Post post = postRepository.findById(postid).orElseThrow(
                ()-> new IllegalArgumentException("해당 포스트가 없습니다.")
        );
        FavoriteDto likeDto = new FavoriteDto(userid);
        Favorite like = new Favorite(likeDto);
        post.getLikes().add(like);
    }

    public void unpressLike(Long postid,Long userid){
        Post post = postRepository.findById(postid).orElseThrow(
                ()-> new IllegalArgumentException("해당 포스트가 없습니다.")
        );
        for(int i=0; i<post.getLikes().size(); i++) {
            if(post.getLikes().get(i).getUserid()==userid){
                post.getLikes().remove(i);
            }
        }

    }
}
