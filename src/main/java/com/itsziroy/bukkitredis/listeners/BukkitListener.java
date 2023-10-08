package com.itsziroy.bukkitredis.listeners;

import com.itsziroy.bukkitredis.BukkitRedisPlugin;
import com.itsziroy.bukkitredis.events.entity.PlayerDiedEvent;
import com.itsziroy.bukkitredis.events.player.PlayerJoinEvent;
import com.itsziroy.bukkitredis.events.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class BukkitListener implements Listener {

    BukkitRedisPlugin plugin;

    public BukkitListener(BukkitRedisPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        PlayerJoinEvent playerJoinEvent = new PlayerJoinEvent(event);
        this.plugin.getMessanger().send(playerJoinEvent);
    }

    @EventHandler
    public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event) {
        PlayerQuitEvent playerQuitEvent = new PlayerQuitEvent(event);
        this.plugin.getMessanger().send(playerQuitEvent);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        PlayerDiedEvent playerDiedEvent = new PlayerDiedEvent(event);
        this.plugin.getMessanger().send(playerDiedEvent);
    }
}
