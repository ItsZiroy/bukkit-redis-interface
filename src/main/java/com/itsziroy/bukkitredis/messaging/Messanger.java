package com.itsziroy.bukkitredis.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsziroy.bukkitredis.BukkitRedisPlugin;
import com.itsziroy.bukkitredis.events.Event;
import com.itsziroy.bukkitredis.events.EventMessage;
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

    public <T extends Message> void send(T m) {
        try (Jedis jedis = jedisPool.getResource()) {

            if(m instanceof ExtensibleMessage) {
                ((ExtensibleMessage) m).executeCallbacks();
            }
            if(m instanceof EventMessage) {
                if(((Event) m).isCancelled()) {
                    plugin.getLogger().finest("Event got cancelled.");
                    return;
                }
            }

            RedisMessage<T> message = new RedisMessage<>(m, this.ip);
            plugin.getLogger().finest("Sending Message: " + message.serialize());
            jedis.publish(channelName, message.serialize());

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
