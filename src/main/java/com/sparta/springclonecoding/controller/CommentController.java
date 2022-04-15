package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.CommentRequestDto;
import com.sparta.springclonecoding.model.Comment;
import com.sparta.springclonecoding.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentservice;

    @PostMapping("/api/comment/{userid}")
    public Comment registComment(@RequestBody CommentRequestDto commentRequestDto,
                                 @PathVariable Long userid){
       return commentservice.registComment(commentRequestDto,userid);
    }

    @DeleteMapping("/api/comment/{commentid}")
    public String deleteComment(@PathVariable Long commentid){
        commentservice.deleteComment(commentid);
        return "지우기 성공!!";
    }
}
