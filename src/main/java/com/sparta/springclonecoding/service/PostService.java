package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.PostRequestDto;
import com.sparta.springclonecoding.dto.PostResponseDto;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // 게시물 저장
    public Post postPost (PostRequestDto postRequestDto){
        Long likeCnt = 0L; // 좋아요 수 초기화
        Post post = new Post(postRequestDto,likeCnt);
        return postRepository.save(post);
    }

    // 게시물 목록 조회 - 게시글 리스트를 반복문으로 꺼내서 각 게시글의 각 코멘트 갯수 보여주고 다시 담아주기
    public List<PostResponseDto> getPost () {
        List<Post> posts = postRepository.findAll();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for (Post post : posts) {
            Long commentCnt = (long) post.getComments().size();
//            Long likeCnt = (long) post.getLikes().size();
            PostResponseDto postResponseDto = new PostResponseDto(post,commentCnt);
            postResponseDtos.add(postResponseDto);
        }
        return postResponseDtos;
    }

}
