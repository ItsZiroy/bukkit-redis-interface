package com.itsziroy.bukkitredis.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsziroy.bukkitredis.events.Event;

public final class MessageSerializer {

    public static String make(Event event) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Message<Event> message = new Message<>(MessageType.EVENT, event);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
    }
}
