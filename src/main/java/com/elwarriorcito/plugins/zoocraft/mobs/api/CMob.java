package com.elwarriorcito.plugins.zoocraft.mobs.api;

import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class CMob implements Listener {

    protected MobInfo info;


    @EventHandler
    abstract void onDeath(EntityDeathEvent event);



    public CMob(MobType mobType, double health) {
        info = new MobInfo(mobType,health);

        //registers this as a listener
        ZooCraft.getInstance().getServer().getPluginManager().
                registerEvents(this, ZooCraft.getInstance());
    }
    public CMob(MobType mobType, double health, String breed) {
            info = new MobInfo(mobType, health,breed);
        //registers this as a listener
        ZooCraft.getInstance().getServer().getPluginManager().
                registerEvents(this, ZooCraft.getInstance());
    }
    public CMob(MobType mobType, double health, String breed, List<ItemStack> itemDrops) {
        info = new MobInfo(mobType, health,itemDrops ,breed);
        //registers this as a listener
        ZooCraft.getInstance().getServer().getPluginManager().
                registerEvents(this, ZooCraft.getInstance());
    }

    public void spawnMob(Player player) {
        //player.getLocation().getWorld().spawn()
    }

    public MobInfo getInfo() {
        return info;
    }
    public class MobInfo {
        private MobType mobType = null;
        private final List<ItemStack> itemDrops = (List<ItemStack>) ZooCraft.getInstance().MobConfig.
                                                getList( "type" + ".drops");
        private final String breed = ZooCraft.getInstance().MobData.getString("type.breed"); ;
        private final double health;


        public MobInfo(MobType mobType, double health) {
            this.mobType = mobType;
            this.health = health;


        }

        public MobInfo(MobType mobType, double health, List<ItemStack> itemDrops) {
            this.mobType = mobType;
            this.health = health;
        }

        public MobInfo(MobType mobType, double health, String breed) {
            this.mobType = mobType;
            this.health = health;
            ZooCraft.MobData.set("ID.type.breed", breed);
        }

        public MobInfo(MobType mobType, double health, List<ItemStack> itemDrops, String breed) {
            this.mobType = mobType;
            this.health = health;
        }
    }
}