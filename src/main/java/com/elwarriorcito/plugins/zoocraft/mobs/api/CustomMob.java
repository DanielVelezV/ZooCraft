package com.elwarriorcito.plugins.zoocraft.mobs.api;


import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import org.bukkit.inventory.ItemStack;

public class CustomMob {

    private int ID  = (int) Math.random();
    ItemStack[] is;

    //need to add item drops
    public void dropItems(ConfigEntityType entityType) {
        for (ItemStack itemStack: is  ) {

        }
    }

    public void assignID() {
        ZooCraft.MobData.set("ID", ID);
    }
}
