package com.sparta.springclonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private String content;
    private MultipartFile multipartFile;
}
