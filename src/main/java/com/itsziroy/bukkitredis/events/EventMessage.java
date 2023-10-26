package com.itsziroy.bukkitredis.events;

import com.itsziroy.bukkitredis.messaging.Message;

public interface EventMessage extends Message {

    void setCancelled(boolean cancelled);
    boolean isCancelled();
}
