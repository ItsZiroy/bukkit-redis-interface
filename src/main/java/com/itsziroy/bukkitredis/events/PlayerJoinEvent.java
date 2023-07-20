package com.itsziroy.bukkitredis.events;

import org.bukkit.entity.Player;

public class PlayerJoinEvent extends Event {
    public static final String EVENT_NAME = "player_join";


    public Player player;
    public PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event) {
        super(EVENT_NAME);

        player = event.getPlayer();


    }
}
