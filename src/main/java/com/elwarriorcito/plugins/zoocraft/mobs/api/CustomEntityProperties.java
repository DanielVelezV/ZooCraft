package com.elwarriorcito.plugins.zoocraft.mobs.api;

import com.elwarriorcito.plugins.zoocraft.core.Enums.ConfigEntityType;
import com.elwarriorcito.plugins.zoocraft.core.Enums.DataEntityType;
import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import sun.security.krb5.Config;

import java.util.List;

public class CustomEntityProperties {

    private int level = ZooCraft.MobData.getInt("ID.type.level");
    private String breed = ZooCraft.MobData.getString("ID.type.breed");
    private int ID = ZooCraft.MobData.getInt("ID");

    private DataEntityType entityType = (DataEntityType) ZooCraft.MobData.get("ID.type");
    private ConfigEntityType configEntityType = (ConfigEntityType) ZooCraft.MobConfig.get("Type");

    private List<ItemStack> itemDrops = (List<ItemStack>) ZooCraft.MobConfig.getList(configEntityType + ".drops");

    public int getLevel() {
      return level;
    }

    public int getID() {
      return  ID;
    }

    public List<ItemStack> getItemDrops() {
        return itemDrops;
    }

    public String getBreed() {
        return breed;
    }

    public void setLevel(int level) {
        ZooCraft.MobData.set(String.valueOf(this.level), level);
    }
    public void setItemDrops(List<ItemStack> itemDrops) {
        this.itemDrops = itemDrops;
    }

    public void setBreed(String breed) {
        ZooCraft.MobData.set(this.breed, breed);
    }


    public void setType(DataEntityType entityType) {
        this.entityType = entityType;
    }

    public DataEntityType getType() {
        return (DataEntityType) ZooCraft.MobData.get("ID.type");

    }
    public ConfigEntityType getConfigType() {
        return configEntityType;
    }
}
