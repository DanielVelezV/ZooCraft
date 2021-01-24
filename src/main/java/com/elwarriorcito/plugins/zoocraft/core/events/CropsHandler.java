package com.elwarriorcito.plugins.zoocraft.core.events;

import com.elwarriorcito.plugins.zoocraft.items.ZooItems;
import com.elwarriorcito.plugins.zoocraft.core.enums.RarityEnum;
import com.elwarriorcito.plugins.zoocraft.core.models.CropModel;
import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
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
            p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().
                    equals(ZooItems.ZooGoldCropGet().getItemMeta().getDisplayName()) ) { //If it is the ZooItem GoldCrop


            Location clickedLocation = e.getClickedBlock().getLocation(); //Get the location on the clicked block


            crop.spawnCrop(clickedLocation, p);
            ZooCraft.plantedCrops.add(crop);
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK &&
                p.getInventory().getItemInMainHand().getType().equals(Material.REDSTONE_BLOCK)){
            crop.stopParticles();
        }

    }

    @EventHandler
    public void onPlayerRemoveCrop(BlockBreakEvent e){
        Location loc = e.getBlock().getLocation();

        if (ZooCraft.plantedCrops.stream().anyMatch(item -> (item.location.getX() == loc.getX() &&
                item.location.getY() == loc.getY() &&
                item.location.getZ() == loc.getZ()))){

            CropModel crop = ZooCraft.plantedCrops.stream().filter(item -> (item.location.getX() == loc.getX() &&
                    item.location.getY() == loc.getY() &&
                    item.location.getZ() == loc.getZ())).findFirst().get();

            if (crop.Owner != null)
            {
                crop.Owner.sendMessage("Someone destroyed your crop");
                crop.removeCrop();
                ZooCraft.plantedCrops.remove(crop);
            }


        }

    }

}
