package com.elwarriorcito.plugins.zoocraft.core;

import org.bukkit.Bukkit;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZooCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //This is a branch test
        Bukkit.broadcastMessage("Hello");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
