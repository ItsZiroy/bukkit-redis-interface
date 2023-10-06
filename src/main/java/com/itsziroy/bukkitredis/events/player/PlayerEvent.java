package com.itsziroy.bukkitredis.events.player;

import com.itsziroy.bukkitredis.events.BukkitEvent;
import com.itsziroy.bukkitredis.events.SimplePlayer;
import org.bukkit.entity.Player;

public class PlayerEvent<T extends org.bukkit.event.player.PlayerEvent> extends BukkitEvent<T> {

    public PlayerEvent(String name, T event) {
        super(name, event);

        Player player = event.getPlayer();

        this.put("minecraft_user", new SimplePlayer(player.getUniqueId().toString(), player.getName()));
    }
}
