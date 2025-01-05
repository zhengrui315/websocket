package com.ruizheng;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private String sender;
    private String receiver;
    private String content;
    private String time;
    private MessageType type;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }


}
