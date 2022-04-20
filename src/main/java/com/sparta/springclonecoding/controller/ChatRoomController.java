//package com.sparta.springclonecoding.controller;
//
//import com.sparta.springclonecoding.dto.chat.CreateRoomRequestDto;
//import com.sparta.springclonecoding.model.ChatRoom;
//import com.sparta.springclonecoding.socket.ChatService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class ChatRoomController {
//    private final ChatService chatService;
//
//    @GetMapping("/api/chatroom")
//    public ChatRoom createRoom(@RequestBody CreateRoomRequestDto createRoomRequestDto){
//        return chatService.createChatRoom(createRoomRequestDto);
//    }
//}
