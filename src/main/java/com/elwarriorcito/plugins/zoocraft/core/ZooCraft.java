package com.elwarriorcito.plugins.zoocraft.core;

import com.elwarriorcito.plugins.zoocraft.commands.GetGoldenCrop;
import com.elwarriorcito.plugins.zoocraft.commands.GetPlantedCrops;
import com.elwarriorcito.plugins.zoocraft.core.models.CropSuperModel;
import com.elwarriorcito.plugins.zoocraft.mobs.CustomCow;
import com.elwarriorcito.plugins.zoocraft.core.events.CropsHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ZooCraft extends JavaPlugin {

    public static ArrayList<CropSuperModel> plantedCrops;



    @Override
    public void onEnable() {
        plantedCrops = new ArrayList<>();
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CropsHandler(this), this);
        getServer().getPluginManager().registerEvents(new CustomCow(), this);
        getCommand("getGoldCrop").setExecutor(new GetGoldenCrop()); //This will give you the Crop Item
        getCommand("getCropInfo").setExecutor(new GetPlantedCrops()); //This will give you info about all planted crops
    }


}
