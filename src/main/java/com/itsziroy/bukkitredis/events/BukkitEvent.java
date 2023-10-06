package com.itsziroy.bukkitredis.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bukkit.event.Event;

public class BukkitEvent<T extends Event> extends ExtensibleEvent {
    private final T original;
    public BukkitEvent(String name, T original) {
        super(name);
        this.original = original;
    }

    @JsonIgnore
    public Event getOriginal() {
        return original;
    }
}
