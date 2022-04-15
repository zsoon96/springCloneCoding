package com.sparta.springclonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private String content;
//    private String imgfile; // 파일 변환 여부 확인
    private String imageUrl;
}
