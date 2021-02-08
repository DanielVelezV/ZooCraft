package com.elwarriorcito.plugins.zoocraft.mobs;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityCow;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomStrollLand;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;



public class ZCow extends EntityCow {

    public ZCow(Location location, String customName, float health) {
        super(EntityTypes.COW, ((CraftWorld) location.getWorld()).getHandle());

        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.setCustomName(new ChatComponentText(customName));
        this.setCustomNameVisible(true);
        this.setHealth(health);

        //pathfinding
        //this.goalSelector(0, new PathfinderGoalRandomStrollLand(1,1,1));
    }
}
