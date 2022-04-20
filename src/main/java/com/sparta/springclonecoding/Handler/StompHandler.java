//package com.sparta.springclonecoding.Handler;
//
//import com.sparta.springclonecoding.repository.UserRepository;
//import com.sparta.springclonecoding.security.jwt.JwtDecoder;
//import com.sparta.springclonecoding.socket.ChatService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.simp.stomp.StompCommand;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.messaging.support.ChannelInterceptor;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class StompHandler implements ChannelInterceptor {
//
//    private final JwtDecoder jwtDecoder;
//    private final ChatService chatService;
//    private UserRepository userRepository;
//
//    public Message<?> preSend(Message<?> message, MessageChannel channel) {
//        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
////        if(StompHeaderAccessor.COMMAND_HEADER == accessor.getCommand()){
////    }
//        if (StompCommand.SUBSCRIBE == accessor.getCommand()) {
////            헤더정보에서 구독 destination정보를 얻고 roomId추출
//            Long roomId = chatService.getRoomId(
//                    Optional.ofNullable(
//                            (String) message.getHeaders().get("simDestination")).orElse("InvalidRoomId"));
//            //     채팅방에 들어온 클라이언트 sessionId를 roomId와 맵핑해 놓는다.
//            //            (나중에 특정 세션이 어떤 채팅방에 들어가 있는지 알기 위함)
//
//            String SessionId = (String) message.getHeaders().get("simSessionId");
//
//        }
//    }
//}
//
//
