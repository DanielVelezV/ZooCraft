package com.elwarriorcito.plugins.zoocraft.core.Events;

import com.elwarriorcito.plugins.zoocraft.core.Enums.RarityEnum;
import com.elwarriorcito.plugins.zoocraft.core.Models.CropModel;
import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class CropsHandler implements Listener {

    private ZooCraft Main;
    public CropsHandler(ZooCraft Main){
        this.Main = Main;
    }

    @EventHandler
    public void onPlayerPlantCrop(PlayerInteractEvent e){
        Player p = e.getPlayer(); //Get the player
        CropModel crop = new CropModel("&6&lWheat Golden Crop", RarityEnum.Common, 20, Main);
        if (e.getHand() == EquipmentSlot.OFF_HAND) return; //This is to avoid double calls

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && //If its clicking a Block
            p.getInventory().getItemInMainHand().getType().equals(Material.WHEAT_SEEDS)) { //If it is WheatSeeds
            Location clickedLocation = e.getClickedBlock().getLocation(); //Get the location on the clicked block


            crop.spawnCrop(clickedLocation, p);
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK &&
                p.getInventory().getItemInMainHand().getType().equals(Material.REDSTONE_BLOCK)){
            crop.stopParticles();
        }

    }
}
