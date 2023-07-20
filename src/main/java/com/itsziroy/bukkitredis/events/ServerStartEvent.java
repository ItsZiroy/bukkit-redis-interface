package com.itsziroy.bukkitredis.events;

public class ServerStartEvent extends Event {

    public static final String EVENT_NAME = "server_start";

    public ServerStartEvent() {
        super(EVENT_NAME);
    }
}
