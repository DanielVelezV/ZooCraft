package com.elwarriorcito.plugins.zoocraft.core;

import com.elwarriorcito.plugins.zoocraft.commands.GetGoldenCrop;
import com.elwarriorcito.plugins.zoocraft.commands.GetPlantedCrops;
import com.elwarriorcito.plugins.zoocraft.mobs.CustomCow;
import com.elwarriorcito.plugins.zoocraft.core.events.CropsHandler;
import com.elwarriorcito.plugins.zoocraft.core.models.CropModel;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ZooCraft extends JavaPlugin {

    public static ArrayList<CropModel> plantedCrops;



    @Override
    public void onEnable() {
        plantedCrops = new ArrayList<>();
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CropsHandler(this), this);
        getServer().getPluginManager().registerEvents(new CustomCow(), this);
        getCommand("getGoldCrop").setExecutor(new GetGoldenCrop());
        getCommand("getCropInfo").setExecutor(new GetPlantedCrops());
    }


}
