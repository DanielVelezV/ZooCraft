package com.elwarriorcito.plugins.zoocraft.Mobs.Api;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class CustomEntityProperties {

    private int level;
    private List<ItemStack> itemDrops;
    private String breed;
    private EntityType entityType;

    public int getLevel() {
      return level;
    }

    public List<ItemStack> getItemDrops() {
        return itemDrops;
    }

    public String getBreed() {
        return breed;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void setItemDrops(List<ItemStack> itemDrops) {
        this.itemDrops = itemDrops;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    enum EntityType {
        COW,
        SHEEP,
        PIG,
        CHICKEN
    }

    public void setType(EntityType entityType) {
        this.entityType = entityType;
    }

    public EntityType getType() {
        return this.entityType;
    }

}
