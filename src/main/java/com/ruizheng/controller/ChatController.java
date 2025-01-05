package com.ruizheng.controller;


import com.ruizheng.persistence.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class ChatController {
    @Autowired
    UserService userService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        Message  newMessage =
                Message.builder().sender(message.getSender()).content(message.getContent()).time(time).build();
        log.info("Sending new message from {}:\n{}", message.getSender(), newMessage.toString());
        return newMessage;
    }

    @MessageMapping("/chat/addUser")
    @SendTo("topic/messages")
    public Message addUser(Message message) {
        log.info("Adding new user: {}", message.getSender());
        message.setType(Message.MessageType.JOIN);
        return message;
    }

    @GetMapping("/chat")
    public String chatPage() {
        return "chat"; // This maps to templates/chat.html
    }
}
