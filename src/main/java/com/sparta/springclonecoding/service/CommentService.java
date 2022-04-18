package com.sparta.springclonecoding.service;

import com.sparta.springclonecoding.dto.CommentRequestDto;
import com.sparta.springclonecoding.model.Comment;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.repository.CommentRepository;
import com.sparta.springclonecoding.repository.PostRepository;
import com.sparta.springclonecoding.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final Validator validator;

    @Transactional
    public Post registComment(CommentRequestDto commentRequestDto,Long userid){
        Post post = postRepository.findById(commentRequestDto.getPostid()).orElseThrow(
                ()-> new IllegalArgumentException("해당 포스트가 없습니다.")
        );
        validator.nullcomment(commentRequestDto);
        Comment comment = new Comment(commentRequestDto,userid);
        post.getComments().add(comment);
        commentRepository.save(comment);
        return post;
    }


    public void deleteComment(Long commentid){
        commentRepository.deleteById(commentid);
    }
}
