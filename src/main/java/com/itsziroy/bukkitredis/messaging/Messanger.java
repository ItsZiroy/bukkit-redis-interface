package com.itsziroy.bukkitredis.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsziroy.bukkitredis.BukkitRedisPlugin;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Messanger {

    private final JedisPool jedisPool;
    private final String channelName;
    private final String ip;
    private final BukkitRedisPlugin plugin;
    public Messanger(BukkitRedisPlugin plugin) {
        this.jedisPool = plugin.getJedisPool();
        this.channelName = plugin.getChannelName();
        this.ip = plugin.getServer().getIp();
        this.plugin = plugin;
    }

    public <T extends Messageable> void send(T m) {
        try (Jedis jedis = jedisPool.getResource()) {
            plugin.getLogger().info("Sending Message");
            Message<T> message = new Message<>(m, this.ip);
            jedis.publish(channelName, message.serialize());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
