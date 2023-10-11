package com.itsziroy.bukkitredis;

import com.itsziroy.bukkitredis.events.EventManager;
import com.itsziroy.bukkitredis.events.server.ServerStartEvent;
import com.itsziroy.bukkitredis.listeners.BukkitListener;
import com.itsziroy.bukkitredis.messaging.Messanger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.JedisPool;

import java.io.File;

public final class BukkitRedisPlugin extends JavaPlugin {

    private JedisPool jedisPool;

    private String channelName;
    private Messanger messanger;

    private static EventManager eventManager;
    @Override
    public void onEnable() {
        registerConfig();

        FileConfiguration config = getConfig();

        channelName = config.getString("channel_name");
        String host = config.getString("redis.host");
        int port = config.getInt("redis.port");
        String user = config.getString("redis.user");
        String password = config.getString("redis.password");


        jedisPool = new JedisPool(host, port, user, password);
        messanger = new Messanger(this);

        messanger.send(new ServerStartEvent());

        getServer().getPluginManager().registerEvents(new BukkitListener(this), this);

        // Plugin startup logic

    }

    public void registerConfig(){
        File config = new File(this.getDataFolder(), "config.yml");
        if(!config.exists()){
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
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

    public static EventManager getEventManager() {
        if(eventManager == null) {
            eventManager = new EventManager();
        }
        return eventManager;
    }

    public EventManager eventManager() {
        return BukkitRedisPlugin.getEventManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
