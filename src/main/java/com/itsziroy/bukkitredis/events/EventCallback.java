package com.itsziroy.bukkitredis.events;

@FunctionalInterface
public interface EventCallback<T extends ExtensibleEvent> {
    void execute(T event);
}
