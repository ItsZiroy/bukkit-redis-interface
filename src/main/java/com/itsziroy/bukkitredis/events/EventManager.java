package com.itsziroy.bukkitredis.events;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EventManager {

    public EventManager() {}

    private final HashMap<Class<?>, List<EventCallback<ExtensibleEvent>>> callbacks = new HashMap<>();
    @SuppressWarnings("unchecked")
    public <T extends ExtensibleEvent> void registerCallback(Class<T> cl, EventCallback<T> callback) {
        callbacks.computeIfAbsent(cl, k -> new LinkedList<>());
        List<EventCallback<ExtensibleEvent>> callbacksForClass = callbacks.get(cl);

        callbacksForClass.add((EventCallback<ExtensibleEvent>) callback);
    }

    public List<EventCallback<ExtensibleEvent>> getCallbacks(Class<?> cl) {
        if(callbacks.get(cl) == null) {
            return new LinkedList<>();
        }
        return callbacks.get(cl);
    }

}
