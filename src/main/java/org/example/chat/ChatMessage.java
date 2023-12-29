package org.example.chat;

import java.io.Serializable;

public class ChatMessage implements Serializable {
    private String sender;
    private String content;

    public ChatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }
}
