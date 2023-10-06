package com.itsziroy.bukkitredis.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itsziroy.bukkitredis.BukkitRedisPlugin;
import com.itsziroy.bukkitredis.messaging.MessageType;
import com.itsziroy.bukkitredis.messaging.Messageable;

import java.util.HashMap;


public abstract class ExtensibleEvent extends HashMap<String, Object> implements Messageable {


    public <T extends ExtensibleEvent>  void executeCallbacks() {
        for (EventCallback<ExtensibleEvent> callback : BukkitRedisPlugin.getEventManager().getCallbacks(this.getClass())) {
            callback.execute(this);
        }
    }
    public ExtensibleEvent(String name) {
        this.put("name", name);
    }

    @JsonIgnore
    @Override
    public MessageType getType() {
        return MessageType.EVENT;
    }


}
