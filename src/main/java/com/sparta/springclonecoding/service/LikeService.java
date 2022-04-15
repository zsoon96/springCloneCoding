package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.LikeDto;
import com.sparta.springclonecoding.model.Like;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.repository.LikeRepository;
import com.sparta.springclonecoding.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    public void pressLike(Long postid, Long userid){
        Post post = postRepository.findById(postid).orElseThrow(
                ()-> new IllegalArgumentException("해당 포스트가 없습니다.")
        );
        LikeDto likeDto = new LikeDto(userid);
        Like like = new Like(likeDto);
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
