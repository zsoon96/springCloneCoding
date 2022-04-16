package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.DetailDto;
import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.dto.PostResponseDto;

import com.sparta.springclonecoding.model.Favorite;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.model.User;

import com.sparta.springclonecoding.dto.ProfileDto;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.model.User;
import com.sparta.springclonecoding.repository.CommentRepository;

import com.sparta.springclonecoding.repository.FavoriteRepository;
import com.sparta.springclonecoding.repository.PostRepository;
import com.sparta.springclonecoding.repository.UserRepository;
import com.sparta.springclonecoding.security.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final FavoriteRepository favoriteRepository;
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

    // 게시글 저장
    public Post postPost (PostRequestDto postRequestDto, UserDetailsImpl userDetails){
        Post post = new Post(postRequestDto, userDetails);
        User user = userRepository.findById(userDetails.getUser().getId()).orElseThrow(
                () -> new IllegalArgumentException("계정이 없습니다.")
        );
        user.getPosts().add(post);
        return postRepository.save(post);
    }

    // 게시글 목록 조회 - 게시글 리스트를 반복문으로 꺼내서 각 게시글의 각 코멘트 갯수 보여주고 다시 담아주기
    public List<PostResponseDto> getPost (UserDetailsImpl userDetails) {
        List<Post> posts = postRepository.findAll();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        Long userId = userDetails.getUser().getId();
        if ( userId == null ) {
            throw new IllegalArgumentException("계정이 없습니다.");
        }

        for (Post post : posts) {

            // 해당 게시물에 대한 사용자의 좋아요 확인 -> 각 포스트마다 좋아요한 리스트에 userid가 사용자와 일치하면 true로 변환
            boolean myLike = false;
            for (int i = 0; i < post.getFavorites().size(); i++) {
                if (post.getFavorites().get(i).getUserid() == userId){
                   myLike = true;
                }
            }

            // 댓글 갯수

            int commentCnt = 0;
            if (!post.getComments().isEmpty()) {
                commentCnt = post.getComments().size();
            }

            // 좋아요 수
            int favoriteCnt = 0;
            if (!post.getFavorites().isEmpty()) {
                favoriteCnt = post.getFavorites().size();
            }
            PostResponseDto postResponseDto = new PostResponseDto(post,commentCnt,favoriteCnt, myLike);

            postResponseDtos.add(postResponseDto);
        }
        return postResponseDtos;
    }


    // 게시글 수정
    @Transactional
    public Long putPost(Long postId, PostRequestDto postRequestDto){
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 없습니다.")
        );
        post.update(postRequestDto);
        return post.getId();
    }


    // 게시글 삭제
    public Long delPost(Long postId) {
        postRepository.deleteById(postId);
        return postId;
    }
}
