package com.elwarriorcito.plugins.zoocraft.Commands;

import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import com.elwarriorcito.plugins.zoocraft.core.models.CropSuperModel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GetPlantedCrops implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /*for (CropModel crops : ZooCraft.plantedCrops){

        for (CropSuperModel crops : ZooCraft.plantedCrops){
            sender.sendMessage("Crop Location: X: " + crops.location.getX() +
                    " Y: " + crops.location.getY() + " Z: " + crops.location.getZ());
            sender.sendMessage(crops.Name + " Owner:" + crops.Owner);
        } */
        return true;
        }
    }
