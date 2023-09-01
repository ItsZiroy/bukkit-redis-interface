package com.itsziroy.bukkitredis;

import com.itsziroy.bukkitredis.events.PlayerJoinEvent;
import com.itsziroy.bukkitredis.events.ServerStartEvent;
import com.itsziroy.bukkitredis.messaging.Messanger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.JedisPool;

public final class BukkitRedisPlugin extends JavaPlugin {

    private JedisPool jedisPool;

    private String channelName;
    private Messanger messanger;
    @Override
    public void onEnable() {

        FileConfiguration config = getConfig();

        channelName = config.getString("channel_name");
        String host = config.getString("redis.host");
        int port = config.getInt("redis.port");
        String user = config.getString("redis.user");
        String password = config.getString("redis.password");


        jedisPool = new JedisPool(host, port, user, password);
        messanger = new Messanger(this);

        messanger.send(new ServerStartEvent());


        // Plugin startup logic

    }
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        messanger.send(new PlayerJoinEvent(event));

    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public String getChannelName() {
        return channelName;
    }

    public Messanger getMessanger() {
        return messanger;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
