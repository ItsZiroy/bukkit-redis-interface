package com.itsziroy.bukkitredis.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisMessage<T extends Message> {

    public MessageType type;

    public String ip;
    public final T content;

    public RedisMessage(T content, String ip) {
        this.type = content.getType();
        this.ip = ip;
        this.content = content;
    }

    public String serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
