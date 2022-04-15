package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.DetailDto;
import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.dto.ProfileDto;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.model.User;
import com.sparta.springclonecoding.repository.LikeRepository;
import com.sparta.springclonecoding.repository.PostRepository;
import com.sparta.springclonecoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void registPost(PostRequestDto postRequestDto){
        Long userid = 1L;
        System.out.println(postRequestDto);

        Post post = new Post(postRequestDto, userid);
        System.out.println(post);
        System.out.println("asd");
        postRepository.save(post);
    }

    public ProfileDto showProfile(Long userid){
        User user = userRepository.findById(userid).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다.")
        );
        int postCnt = postRepository.countAllByUserId(userid);
        ProfileDto profileDto= new ProfileDto(user,postCnt);
        return profileDto;
    }

    public DetailDto showDetail(Long postid,Long userid){
        Post post =postRepository.findById(postid).orElseThrow(
                ()-> new IllegalArgumentException("없는 포스트입니다")
        );
        Boolean myLike = false;
        for(int i =0; i<post.getLikes().size(); i++){
            if (post.getLikes().get(i).getUserid() == userid) {
                myLike = true;
                break;
            }
        }
        return new DetailDto(post,post.getLikes().size(),myLike);
    }
}
