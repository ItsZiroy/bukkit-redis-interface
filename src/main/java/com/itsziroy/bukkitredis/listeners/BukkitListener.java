package com.itsziroy.bukkitredis.listeners;

import com.itsziroy.bukkitredis.BukkitRedisPlugin;
import com.itsziroy.bukkitredis.events.player.PlayerJoinEvent;
import com.itsziroy.bukkitredis.events.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BukkitListener implements Listener {

    BukkitRedisPlugin plugin;

    public BukkitListener(BukkitRedisPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        PlayerJoinEvent playerJoinEvent = new PlayerJoinEvent(event);
        playerJoinEvent.executeCallbacks();
        this.plugin.getMessanger().send(playerJoinEvent);
    }

    @EventHandler
    public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event) {
        PlayerQuitEvent playerQuitEvent = new PlayerQuitEvent(event);
        playerQuitEvent.executeCallbacks();
        this.plugin.getMessanger().send(playerQuitEvent);
    }
}
