package com.elwarriorcito.plugins.zoocraft.core.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class CropsHandler implements Listener {

    @EventHandler
    public void onPlayerPlantCrop(PlayerInteractEvent e){
        Player p = e.getPlayer(); //Get the player

        if (e.getHand() == EquipmentSlot.OFF_HAND) return; //This is to avoid double calls

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && //If its clicking a Block
            p.getInventory().getItemInMainHand().getType().equals(Material.WHEAT_SEEDS)){ //If it is WheatSeeds
            Location clickedLocation = e.getClickedBlock().getLocation(); //Get the location on the clicked block

            p.getWorld().getBlockAt(clickedLocation.add(0, 1, 0)).setType(Material.PLAYER_HEAD); //add 1 on Y axis so it puts on top of the block
        }

    }
}
