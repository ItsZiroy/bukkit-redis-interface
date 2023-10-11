package com.itsziroy.bukkitredis.events.player;

import com.itsziroy.bukkitredis.events.BukkitEvent;
import org.bukkit.entity.Player;

public class PlayerEvent<T extends org.bukkit.event.player.PlayerEvent> extends BukkitEvent<T> {

    public static String KEY_MINECRAFT_USER = "minecraft_user";
    public PlayerEvent(String name, T event) {
        super(name, event);

        Player player = event.getPlayer();

        this.put(KEY_MINECRAFT_USER, new MinecraftPlayer(player.getUniqueId().toString(), player.getName()));
    }
}
