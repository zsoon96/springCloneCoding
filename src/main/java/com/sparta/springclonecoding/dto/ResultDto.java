package com.sparta.springclonecoding.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResultDto {
    private boolean result;
    private String message;

    public ResultDto(boolean result, String message) {
        this.result = result;
        this.message = message;
    }
}
