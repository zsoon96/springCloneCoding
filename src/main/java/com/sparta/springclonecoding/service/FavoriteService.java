package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.FavoriteDto;

import com.sparta.springclonecoding.model.Favorite;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.repository.FavoriteRepository;
import com.sparta.springclonecoding.repository.PostRepository;
import com.sparta.springclonecoding.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final PostRepository postRepository;
    private final Validator validator;

    public void pressLike(Long postid, Long userid){
        Optional<Favorite> favorite = favoriteRepository.findByUseridAndPostid(userid,postid);
        if(favorite.isPresent()){
            throw new IllegalArgumentException("이미 눌러진 좋아요 입니다");
        }
        FavoriteDto favoriteDto = new FavoriteDto(userid,postid);
        Favorite favorite1 = new Favorite(favoriteDto);
        favoriteRepository.save(favorite1);
    }


    @Transactional
    public void unpressLike(Long postid,Long userid){
        Favorite favorite = favoriteRepository.findByUseridAndPostid(userid,postid).orElseThrow(
                ()-> new IllegalArgumentException("이미 좋아요가 취소되었습니다")
        );
        favoriteRepository.deleteByUseridAndPostid(userid, postid);
    }
}

