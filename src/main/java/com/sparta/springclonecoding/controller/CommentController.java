package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.CommentRequestDto;
import com.sparta.springclonecoding.model.Comment;
import com.sparta.springclonecoding.service.CommentService;
import lombok.RequiredArgsConstructor;
import com.sparta.springclonecoding.security.UserDetailsImpl;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentservice;

    // 댓글 작성
    @PostMapping("/api/comment")
    public Comment registComment(@RequestBody CommentRequestDto commentRequestDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long userid = userDetails.getUser().getId();
        return commentservice.registComment(commentRequestDto,userid);
    }

    @DeleteMapping("/api/comment/{commentid}")
    public String deleteComment(@PathVariable Long commentid){
        commentservice.deleteComment(commentid);
        return "지우기 성공!!";
    }
}
