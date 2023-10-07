package com.itsziroy.bukkitredis.events.player;

public class PlayerDiedEvent extends PlayerEvent<org.bukkit.event.player.Player> {
    private static final String EVENT_NAME = "player_join";

    public PlayerDiedEvent(org.bukkit.event.player.PlayerJoinEvent event) {
        super(EVENT_NAME, event);

    }
}
