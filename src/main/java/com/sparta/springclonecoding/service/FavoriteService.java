package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.FavoriteDto;

import com.sparta.springclonecoding.model.Favorite;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.repository.FavoriteRepository;
import com.sparta.springclonecoding.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final PostRepository postRepository;

    public void pressLike(Long postid, Long userid){
        Post post = postRepository.findById(postid).orElseThrow(
                ()-> new IllegalArgumentException("해당 포스트가 없습니다.")
        );
        Optional<Favorite> favorite = favoriteRepository.findByUserid(userid);
        if(favorite.isPresent()){
            throw new IllegalArgumentException("이미눌러진 좋아요입니다");
        }
        FavoriteDto favoriteDto = new FavoriteDto(userid);
        Favorite favorite1 = new Favorite(favoriteDto);
        post.getFavorites().add(favorite1);
        favoriteRepository.save(favorite1);
    }

    public void unpressLike(Long postid,Long userid){

        Post post = postRepository.findById(postid).orElseThrow(
                ()-> new IllegalArgumentException("게시물이 없다람쥐")
        );
        Optional<Favorite> favorite = favoriteRepository.findByUserid(userid);
        if(!favorite.isPresent()) {
            throw new IllegalArgumentException("취소할 좋아요가 없습니다람쥐 ");
        }
        for(int i=0; i<post.getFavorites().size(); i++) {
            if(post.getFavorites().get(i).getUserid()==userid){
                post.getFavorites().remove(i);
            }
        }

    }
}

