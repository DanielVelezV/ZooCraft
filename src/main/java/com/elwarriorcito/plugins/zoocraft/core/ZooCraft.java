package com.elwarriorcito.plugins.zoocraft.core;

import com.elwarriorcito.plugins.zoocraft.Commands.GetGoldenCrop;
import com.elwarriorcito.plugins.zoocraft.core.Enums.ConfigEntityType;
import com.elwarriorcito.plugins.zoocraft.mobs.CustomCow;
import com.elwarriorcito.plugins.zoocraft.core.Events.CropsHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class ZooCraft extends JavaPlugin {

    private File MobDataYML;
    private File MobConfigYML;

    //This file will contain things specific to each individual mob
    public static FileConfiguration MobData;
    //This file will contain things specific to each group of mobs such as cows, chickens, etc
    public static FileConfiguration MobConfig;

    public static ZooCraft plugin;

    private String cow = String.valueOf(MobConfig.get(String.valueOf(ConfigEntityType.COW)));
    private String chicken = String.valueOf(MobConfig.get(String.valueOf(ConfigEntityType.CHICKEN)));
    private String sheep = String.valueOf(MobConfig.get(String.valueOf(ConfigEntityType.SHEEP)));
    private String pig = String.valueOf(MobConfig.get(String.valueOf(ConfigEntityType.PIG)));


    @Override
    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new CropsHandler(this), this);
        getServer().getPluginManager().registerEvents(new CustomCow(), this);
        getCommand("getGoldCrop").setExecutor(new GetGoldenCrop());

        //Create the MobData file
        MobDataYML = new File(this.getDataFolder() + "/MobData.yml");
        MobData = YamlConfiguration.loadConfiguration(MobDataYML);

        //Create the MobConfig file
        MobConfigYML = new File(this.getDataFolder() + "/MobConfig.yml");
        MobConfig = YamlConfiguration.loadConfiguration(MobConfigYML);
        createMobConfigDefaults();

    }
    @Override
    public void onDisable() {
        saveYmlFile(MobConfig, MobConfigYML);
        saveYmlFile(MobData, MobDataYML);
    }


    //Use this method to save any yml file
    public static void saveYmlFile(FileConfiguration config, File file) {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createMobConfigDefaults() {

        if (!MobConfig.contains(cow)) {
            MobConfig.get(cow + ".Default Health.Drops");
            MobConfig.set(cow + ".Default Health", 10);
        }
        if (!MobConfig.contains(pig)) {
            MobConfig.get(pig + ".Default Health.Drops");
            MobConfig.set(pig + ".Default Health", 10);
        }
        if (!MobConfig.contains(chicken)) {
            MobConfig.get(chicken + ".Default Health.Drops");
            MobConfig.set(chicken + ".Default Health", 4);
        }
        if (!MobConfig.contains(sheep)) {
            MobConfig.get(sheep + ".Default Health.Drops");
            MobConfig.set(sheep + ".Default Health", 8);
        }
        saveYmlFile(MobConfig, MobConfigYML);
    }

}
