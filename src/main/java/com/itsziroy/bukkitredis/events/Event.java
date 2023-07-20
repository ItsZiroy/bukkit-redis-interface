package com.itsziroy.bukkitredis.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itsziroy.bukkitredis.messaging.MessageType;
import com.itsziroy.bukkitredis.messaging.Messageable;

public abstract class Event implements Messageable {

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
