package com.elwarriorcito.plugins.zoocraft.core;
import com.elwarriorcito.plugins.zoocraft.core.Events.CropsHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZooCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new CropsHandler(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
