package com.chat.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.chat.redis.model.ChatMessage;
import com.chat.redis.service.RedisMessagePublisher;

@Controller
public class WebSocketMessageController {

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @MessageMapping("/chat")
    public void handleChatMessage(ChatMessage message) {
        redisMessagePublisher.publish("messages", message.getSender() + ": " + message.getContent());
    }
}
