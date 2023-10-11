package com.itsziroy.bukkitredis.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itsziroy.bukkitredis.messaging.MessageType;
import com.itsziroy.bukkitredis.messaging.Message;

public abstract class Event implements Message {

    public String name;
    public Event(String name) {
        this.name = name;
    }

    @JsonIgnore
    @Override
    public MessageType getType() {
        return MessageType.EVENT;
    }
}
