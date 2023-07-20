package com.itsziroy.bukkitredis;

import redis.clients.jedis.JedisPubSub;

public class RedisSubscriber extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        super.onMessage(channel, message);
    }
}
