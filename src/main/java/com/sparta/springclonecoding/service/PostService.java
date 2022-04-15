package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.DetailDto;
import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.dto.PostResponseDto;
import com.sparta.springclonecoding.dto.ProfileDto;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.model.User;
import com.sparta.springclonecoding.repository.CommentRepository;
import com.sparta.springclonecoding.repository.FavoriteRepository;
import com.sparta.springclonecoding.repository.PostRepository;
import com.sparta.springclonecoding.repository.UserRepository;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final FavoriteRepository likeRepository;
    private final CommentRepository commentRepository;

    public ProfileDto showProfile(UserDetailsImpl userDetails){
        Long userid = userDetails.getUser().getId();
        User user = userRepository.findById(userid).orElseThrow(
                () -> new IllegalArgumentException("없는 유저입니다."));
        int postCnt = postRepository.countAllByUserId(userid);
        ProfileDto profileDto= new ProfileDto(user,postCnt);
        return profileDto;
    }

    public DetailDto showDetail(Long postid,UserDetailsImpl userDetails){
        Post post =postRepository.findById(postid).orElseThrow(
                ()-> new IllegalArgumentException("없는 포스트입니다"));
        Boolean myLike = false;
        Long userid =userDetails.getUser().getId();
        for(int i =0; i<post.getFavorites().size(); i++){
            if (post.getFavorites().get(i).getUserid() == userid) {
                myLike = true;
                break;
            }
        }
        return new DetailDto(post,post.getFavorites().size(),myLike);
    }


    // 게시물 저장
    public Post postPost (PostRequestDto postRequestDto,UserDetailsImpl userDetails){
        Long likeCnt = 0L; // 좋아요 수 초기화

        Long userid = userDetails.getUser().getId();
        User user = userRepository.findById(userid).orElseThrow(
                ()-> new IllegalArgumentException("없는 유저입니다람쥐")
        );
        Post post = new Post(postRequestDto,userid);
        user.getPosts().add(post);
        return postRepository.save(post);
    }

    // 게시물 목록 조회 - 게시글 리스트를 반복문으로 꺼내서 각 게시글의 각 코멘트 갯수 보여주고 다시 담아주기
    public List<PostResponseDto> getPost () {
        List<Post> posts = postRepository.findAll();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for (Post post : posts) {
            int commentCnt = 0;
            if (!post.getComments().isEmpty()) {
                commentCnt = post.getComments().size();
            }

            int likeCnt = 0;
            if (!post.getFavorites().isEmpty()) {
                likeCnt = post.getFavorites().size();
            }

            PostResponseDto postResponseDto = new PostResponseDto(post,commentCnt,likeCnt);
            postResponseDtos.add(postResponseDto);
        }
        return postResponseDtos;
    }
}
