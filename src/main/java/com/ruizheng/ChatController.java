package com.ruizheng;


import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class ChatController {
//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public Message send(Message message) throws Exception {
//        String time = new SimpleDateFormat("HH:mm").format(new Date());
//        return Message.builder().sender(message.getSender()).content(message.getContent()).time(time).build();
//    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        Message  newMessage = Message.builder().sender(message.getSender()).content(message.getContent()).time(time).build();

        log.info("{} sends the message{}", message.getSender(), newMessage.toString());
        System.out.println("sending message");
        return newMessage;
    }

    @MessageMapping("/chat/addUser")
    @SendTo("topic/messages")
    public Message addUser(Message message) {
        log.info("the message is" + message.getSender());
        message.setType(Message.MessageType.JOIN);
        return message;
    }

    @GetMapping("/chat")
    public String chatPage() {
        log.info("Visiting /chat.");
        return "chat"; // This maps to templates/chat.html
    }
}
