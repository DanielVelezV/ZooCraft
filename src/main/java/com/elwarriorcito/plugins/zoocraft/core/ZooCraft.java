package com.elwarriorcito.plugins.zoocraft.core;

import com.elwarriorcito.plugins.zoocraft.Mobs.CustomCow;
import com.elwarriorcito.plugins.zoocraft.core.Events.CropsHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZooCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CropsHandler(this), this);
        getServer().getPluginManager().registerEvents(new CustomCow(), this);

    }


}
