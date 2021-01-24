package com.elwarriorcito.plugins.zoocraft.core;

import com.elwarriorcito.plugins.zoocraft.core.Events.CropsHandler;
import com.elwarriorcito.plugins.zoocraft.mobs.CustomCow;
import org.bukkit.material.Crops;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZooCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CropsHandler(), this);
        getServer().getPluginManager().registerEvents(new CustomCow(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
