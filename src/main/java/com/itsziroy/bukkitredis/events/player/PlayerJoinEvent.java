package com.itsziroy.bukkitredis.events.player;

public class PlayerJoinEvent extends PlayerEvent<org.bukkit.event.player.PlayerJoinEvent> {
    private static final String EVENT_NAME = "player_join";

    public PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event) {
        super(EVENT_NAME, event);

    }
}
