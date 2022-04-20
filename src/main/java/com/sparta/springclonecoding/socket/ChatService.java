//package com.sparta.springclonecoding.socket;
//
//import com.sparta.springclonecoding.dto.chat.ChatRoomDto;
//import com.sparta.springclonecoding.dto.chat.CreateRoomRequestDto;
//import com.sparta.springclonecoding.model.ChatRoom;
//import com.sparta.springclonecoding.repository.ChatRoomRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class ChatService {
//    private final ChatRoomRepository chatRoomRepository;
//
//    @Transactional
//    public ChatRoom createChatRoom(CreateRoomRequestDto createRoomRequestDto){
//        ChatRoom chatRoom = new ChatRoom(createRoomRequestDto);
//        chatRoomRepository.save(chatRoom);
//        return chatRoom;
//    }
//
//    public Long getRoomId(String destination){
//        int lastIndex = destination.lastIndexOf("/");
//        if(lastIndex!=-1){
//            return Long.parseLong(destination.substring(lastIndex+1));
//        }
//        else{
//            return 0L;
//        }
//    }
//}
