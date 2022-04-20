//package com.sparta.springclonecoding.controller;
//
//import com.sparta.springclonecoding.dto.chat.ChatMessageDto;
//import com.sparta.springclonecoding.security.jwt.JwtDecoder;
//import com.sparta.springclonecoding.socket.ChatService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.stereotype.Controller;
//
//@RequiredArgsConstructor
//@Controller
//public class ChatController {
//    private final JwtDecoder jwtDecoder;
//    private final ChatService chatService;
//
//    @MessageMapping("/chat/message")
//    public void message(ChatMessageDto message, @Header("Autorization")String token){
//        String tokenInfo = token.substring(7);
//        String username = jwtDecoder.decodeUsername(tokenInfo);
//
//        message.setSender(username);
//    }
//}
