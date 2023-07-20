package com.itsziroy.bukkitredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsziroy.bukkitredis.events.PlayerJoinEvent;
import com.itsziroy.bukkitredis.events.ServerStartEvent;
import com.itsziroy.bukkitredis.messaging.MessageSerializer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public final class BukkitRedisPlugin extends JavaPlugin {

    public JedisPool jedisPool;

    private String channelName;
    @Override
    public void onEnable() {

        FileConfiguration config = getConfig();

        channelName = config.getString("channel_name");
        String host = config.getString("redis.host");
        int port = config.getInt("redis.port");
        String user = config.getString("redis.user");
        String password = config.getString("redis.password");


        jedisPool = new JedisPool(host, port, user, password);

        try (Jedis jedis = jedisPool.getResource()) {
            getLogger().info("Jedis successfully loaded");
            jedis.publish(channelName, MessageSerializer.make(new ServerStartEvent()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        // Plugin startup logic

    }

    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.publish(channelName, MessageSerializer.make(new PlayerJoinEvent(event)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
