package com.itsziroy.bukkitredis.events.server;

import com.itsziroy.bukkitredis.events.ExtensibleEvent;

public class ServerStartEvent extends ExtensibleEvent {

    public static final String EVENT_NAME = "server_start";

    public ServerStartEvent() {
        super(EVENT_NAME);
    }
}
