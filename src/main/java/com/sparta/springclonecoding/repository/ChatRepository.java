package com.sparta.springclonecoding.repository;

import com.sparta.springclonecoding.model.ChatContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatContent,Long> {
    public final String CHAT_ROOMS = "CHAT_ROOM"; // 채팅룸 저장
    public static final String USER_COUNT = "USER_COUNT"; // 채팅룸에 입장한 클라이언트수 저장
    public static final String ENTER_INFO = "ENTER_INFO"; // 채팅룸에 입장한 클라이언트의 sessionId와 채팅룸 id를 맵핑한 정보 저장
    public static final String USER_NICKNAME = "USER_NICKNAME"; // 채팅룸에 입장한 유저 닉네임
}
