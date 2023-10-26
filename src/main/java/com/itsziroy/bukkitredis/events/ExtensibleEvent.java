package com.itsziroy.bukkitredis.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itsziroy.bukkitredis.BukkitRedisPlugin;
import com.itsziroy.bukkitredis.messaging.ExtensibleMessage;
import com.itsziroy.bukkitredis.messaging.MessageType;

import java.util.HashMap;


public abstract class ExtensibleEvent extends HashMap<String, Object> implements ExtensibleMessage, EventMessage {

    private boolean cancelled = false;

    /**
     * Callbacks to be executed before Event is dispatched on redis.
     * This implementation executes callbacks on child class and all
     * Parent classes. Therefore, you can create grouped listeners.
     */
    public void executeCallbacks() {
        Class<?> c = this.getClass();
        while (c != null) {
            if(ExtensibleMessage.class.isAssignableFrom(c)) {
                for (EventCallback<ExtensibleEvent> callback : BukkitRedisPlugin.getEventManager().getCallbacks(c)) {
                    callback.execute(this);
                }
                c = c.getSuperclass();
            } else {
                c = null;
            }
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

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }
}
