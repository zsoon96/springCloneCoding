//package com.sparta.springclonecoding.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry){
//        registry.enableSimpleBroker("/queue","/topic"); //내장 브로컷 ㅏ용
//        //prefix가 붙은 메세지를 발행시 브로커가 처리
//        // "/queue" :1대1로 메세지를 보낼떄
//        // "/topic" :1대 다로 메세지를 보낼 떄
//        registry.setApplicationDestinationPrefixes("/app");
//        //메세지 핸들러로 라우팅되는 prefix
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry){
//        registry.addEndpoint("/gs-guide-websocket").withSockJS();
//        //웹소켓 연결 주소
//        //이전처럼 하나하나 Handler를 추가할 필요 없음
//    }
//}
