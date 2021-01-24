package com.elwarriorcito.plugins.zoocraft.core;

import com.elwarriorcito.plugins.zoocraft.Commands.CowSpawnCommand;
import com.elwarriorcito.plugins.zoocraft.mobs.CustomCow;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZooCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("spawnCow").setExecutor(new CowSpawnCommand());

        getServer().getPluginManager().registerEvents(new CustomCow(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
