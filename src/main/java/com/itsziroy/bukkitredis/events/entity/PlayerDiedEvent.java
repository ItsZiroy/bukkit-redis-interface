package com.itsziroy.bukkitredis.events.entity;

import com.itsziroy.bukkitredis.events.BukkitEvent;
import com.itsziroy.bukkitredis.events.player.MinecraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDiedEvent extends BukkitEvent<PlayerDeathEvent> {
    private static final String EVENT_NAME = "player_died";

    public static String KEY_MINECRAFT_USER = "minecraft_user";
    public PlayerDiedEvent(PlayerDeathEvent event) {
        super(EVENT_NAME, event);
        Player player = event.getEntity();

        this.put(KEY_MINECRAFT_USER, new MinecraftPlayer(player.getUniqueId().toString(), player.getName()));

    }
}
