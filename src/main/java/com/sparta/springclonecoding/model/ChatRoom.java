//package com.sparta.springclonecoding.model;
//
//import com.sparta.springclonecoding.dto.chat.ChatRoomDto;
//import com.sparta.springclonecoding.dto.chat.CreateRoomRequestDto;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//public class ChatRoom {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
//    private Long id;
//
//    @Column
//    private Long userid1;
//
//    @Column
//    private Long userid2;
//
//    @OneToMany
//    @JoinColumn
//    private List<ChatContent> chatContents= new ArrayList<>();
//
//    public ChatRoom(CreateRoomRequestDto createRoomRequestDto){
//        this.userid1 = createRoomRequestDto.getUserid1();
//        this.userid2 = createRoomRequestDto.getUserid2();
//    }
//
//}
