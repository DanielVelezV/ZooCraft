package com.elwarriorcito.plugins.zoocraft.core;



import com.elwarriorcito.plugins.zoocraft.core.events.CropsHandler;
import com.elwarriorcito.plugins.zoocraft.mobs.api.MobType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.elwarriorcito.plugins.zoocraft.core.models.CropSuperModel;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public final class ZooCraft extends JavaPlugin {

    public static ArrayList<CropSuperModel> plantedCrops;



    private File MobDataYML;
    private File MobConfigYML;

    //This file will contain things specific to each individual mob
    public static FileConfiguration MobData;
    //This file will contain things specific to each group of mobs such as cows, chickens, etc
    public static FileConfiguration MobConfig;

    public static ZooCraft plugin;

    private String cow = String.valueOf(MobConfig.get(String.valueOf(MobType.COW)));
    private String chicken = String.valueOf(MobConfig.get(String.valueOf(MobType.CHICKEN)));
    private String sheep = String.valueOf(MobConfig.get(String.valueOf(MobType.SHEEP)));
    private String pig = String.valueOf(MobConfig.get(String.valueOf(MobType.PIG)));
    private String horse = String.valueOf(MobConfig.get(String.valueOf(MobType.HORSE)));
    private String dog = String.valueOf(MobConfig.get(String.valueOf(MobType.DOG)));

    //returns an instance of this class/plugin
    public static ZooCraft getInstance() {
        return plugin;
    }


    @Override
    public void onEnable() {
        plantedCrops = new ArrayList<>();
        // Plugin startup logic
        plugin = this;

        getServer().getPluginManager().registerEvents(new CropsHandler(this), this);


        //getCommand("getGoldCrop").setExecutor(new GetGoldenCrop());
        //getCommand("getCropInfo").setExecutor(new GetPlantedCrops());


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
        if (!MobConfig.contains(dog)) {
            MobConfig.get(dog + ".Default Health.Drops");
            MobConfig.set(dog + ".Default Health", 8);
        }
        if (!MobConfig.contains(horse)) {
            MobConfig.get(horse + ".Default Health.Drops");
            MobConfig.set(horse + ".Default Health", 25);
        }
        saveYmlFile(MobConfig, MobConfigYML);
    }

}
