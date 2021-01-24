package com.elwarriorcito.plugins.zoocraft.core.models;

import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import com.elwarriorcito.plugins.zoocraft.core.enums.RarityEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class CarrotCrop extends CropSuperModel{

    public CarrotCrop(Material DropType, Integer GrowTime, String Name, String skinUUI, RarityEnum Rarity, Particle particleEffect, ZooCraft Main) {
        super(DropType, GrowTime, Name, skinUUI, Rarity, particleEffect, Main);
    }

    @Override
    public void dropWhenGrowTimeDone() {
        Random rnd = new Random();
        this.location.getWorld().dropItem(location, new ItemStack(Material.CARROT, rnd.nextInt(5)));
    }

    @Override
    public void playParticles() {
        particleTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main, new Runnable() {
            @Override
            public void run() {
                location.getWorld().spawnParticle(particleEffect, location.getX(), location.getY(), location.getZ(), 1);
                location.getWorld().spawnParticle(particleEffect, location.getX() + 0.5, location.getY(), location.getZ() + 0.5, 1);
                location.getWorld().spawnParticle(particleEffect, location.getX() + 1, location.getY(), location.getZ() + 1, 1);
                location.getWorld().spawnParticle(particleEffect, location.getX() + 1, location.getY(), location.getZ() + 0.5, 1);
                location.getWorld().spawnParticle(particleEffect, location.getX(), location.getY(), location.getZ() + 1, 1);
            }
        }, 0L, 10L );
    }


}
