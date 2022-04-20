package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.socket.Greeting;
import com.sparta.springclonecoding.socket.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")  //MESSAGE를 보냈을 떄 여기서 처리
    @SendTo("/topic/greeting")  //STOMP 사용시 따로 상속을 받을 필요 없이 Controller로 사용가능,    //핸들러에서 처리를 마치고 반환값을 topic으로 다시 메시지로 보냄
    public Greeting greeting(HelloMessage message)throws Exception{
        Thread.sleep(1000);
        return new Greeting(
                "Hello,"+ HtmlUtils.htmlEscape(message.getName())+"!");
    }
}
