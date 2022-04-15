package com.sparta.springclonecoding.exception;

public class ExceptionMessage {
    // Common

    // User
    public static final String ILLEGAL_USER_NAME_DUPLICATION = "중복된 아이디입니다.";
    public static final String ILLEGAL_NICK_NAME_DUPLICATION = "중복된 닉네임입니다.";
    public static final String ILLEGAL_PASS_WORD_DUPLICATION = "비밀번호가 일치하지 않습니다.";

    // team
    public static final String ILLEGAL_CANT_FOUND_team = "해당 그룹이 존재하지 않습니다.";
    public static final String ILLEGAL_CANT_FOUND_POST = "해당 포스트가 존재하지 않습니다.";
    public static final String ILLEGAL_ALREADY_JOINED_team= "이미 참가한 그룹입니다.";
    public static final String ILLEGAL_ALREADY_LEFT_team= "이미 나간 그룹입니다.";
    public static final String ILLEGAL_EXCEEDED_ALLOWED_MAXCOUNT = "허용인원을 초과하였습니다.";
}
