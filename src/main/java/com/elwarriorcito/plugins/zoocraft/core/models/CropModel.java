package com.elwarriorcito.plugins.zoocraft.core.models;

import com.elwarriorcito.plugins.zoocraft.core.enums.RarityEnum;
import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CropModel {

    public int GrowTime;
    public RarityEnum Rarity;
    public String Name;
    public Location location;
    public Player Owner;
    public ZooCraft Main;
    public HologramModel holo;
    public int remainingGrowTime;

    public  int particleTaskId;
    public int growTimeTaskId;



    public CropModel(String Name, RarityEnum Rarity, int Growtime, ZooCraft main){
        this.Name = Name;
        Rarity = Rarity;
        this.GrowTime = Growtime;
        this.Main = main;
        remainingGrowTime = GrowTime;
    }

    public void spawnCrop(Location loc, Player Owner){
        this.location = loc;
        this.Owner = Owner;


        loc.getWorld().getBlockAt(loc.add(0, 1, 0)).setType(Material.PLAYER_HEAD);

        loc.getWorld().getBlockAt(loc);

        particleTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main, new Runnable() {
            @Override
            public void run() {
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX(), loc.getY(), loc.getZ(), 1);
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX() + 0.5, loc.getY(), loc.getZ() + 0.5, 1);
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX() + 1, loc.getY(), loc.getZ() + 1, 1);
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX() + 1, loc.getY(), loc.getZ() + 0.5, 1);
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX(), loc.getY(), loc.getZ() + 1, 1);
            }
        }, 0L, 40L );

        holo = new HologramModel();
        Location holoLocation = loc.clone();

        holo.createLine(holoLocation.add(0.5, -0.2, 0.5), Name);
        holo.addLine("&2GrowTime: ");
        holo.addLine("&4Rarity: ");
        startGrowTimeCountDown();

    }

    public void stopParticles(){
            Bukkit.getScheduler().cancelTasks(Main);
            particleTaskId = 0;
            growTimeTaskId = 0;
    }

    public void startGrowTimeCountDown() {
        if (holo.getLine(2) != null) {
            growTimeTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main, new Runnable() {
                @Override
                public void run() {
                    holo.editLine(2, "&2GrowTime: " + remainingGrowTime);
                    remainingGrowTime--;
                    if (remainingGrowTime == 0){
                        remainingGrowTime = GrowTime;
                        location.getWorld().dropItem(location, new ItemStack(Material.WHEAT_SEEDS));
                    }
                }
            }, 0L, 20L);

        }

    }

    public void removeCrop(){
        Bukkit.getScheduler().cancelTask(particleTaskId);
        Bukkit.getScheduler().cancelTask(growTimeTaskId);
        particleTaskId = 0;
        growTimeTaskId = 0;
        holo.removeHolo();
    }
}
