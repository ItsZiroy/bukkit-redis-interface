package com.itsziroy.bukkitredis.events;

public abstract class Event {

    public String name;
    public Event(String name) {
        this.name = name;
    }
}
