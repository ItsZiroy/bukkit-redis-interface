package com.itsziroy.bukkitredis.messaging;

public class Message<T> {

    public MessageType type;
    public final T content;

    public Message(MessageType type, T content) {
        this.type = type;
        this.content = content;
    }
}
