//package com.sparta.springclonecoding.Handler;
//
//import org.json.JSONObject;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class SocketTextHandler extends TextWebSocketHandler {
//
//    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session){
//        sessions.add(session);
//    }
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        JSONObject jsonObject = new JSONObject(payload);
//        for (WebSocketSession s : sessions) {
//            s.sendMessage(new TextMessage("HI" + jsonObject.get("user") + "! How may I help you"));
//        }
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws  Exception{
//        sessions.add(session);
//    }
//}
