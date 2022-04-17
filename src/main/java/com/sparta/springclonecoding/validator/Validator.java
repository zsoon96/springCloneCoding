package com.sparta.springclonecoding.validator;

import com.sparta.springclonecoding.dto.CommentRequestDto;
import org.springframework.stereotype.Component;

@Component
public class Validator {


    public void nullcomment(CommentRequestDto commentRequestDto) {
        if(commentRequestDto.getContent() == null){
            throw new IllegalArgumentException("내용을 입력하세요");
        }
    }

    public void alreadyLike(boolean favorite, String message) {
        if(favorite){
            throw new IllegalArgumentException(message);
        }
    }

}
