package com.itsziroy.bukkitredis.events.player;


public class PlayerQuitEvent extends PlayerEvent<org.bukkit.event.player.PlayerQuitEvent> {

    private static final String EVENT_NAME = "player_quit";

    public PlayerQuitEvent(org.bukkit.event.player.PlayerQuitEvent event) {
        super(EVENT_NAME, event);

        this.executeCallbacks();
    }
}
