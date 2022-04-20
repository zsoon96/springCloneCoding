package com.sparta.springclonecoding.dto.chat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.TrayIcon;

@Setter
@Getter
@NoArgsConstructor
public class ChatMessageDto {

    private TrayIcon.MessageType type;
    private Long roomid;
    private String sender;
    private String message;

    public ChatMessageDto(TrayIcon.MessageType type, Long roomid, String sender,
                          String message){
        this.type = type;
        this.roomid = roomid;
        this.sender = sender;
        this.message = message;
    }

}
