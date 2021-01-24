package com.elwarriorcito.plugins.zoocraft.core.Models;

import com.elwarriorcito.plugins.zoocraft.core.Enums.RarityEnum;
import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class CropModel {

    public int GrowTime;
    public RarityEnum Rarity;
    public String Name;
    public Location location;
    public Player Owner;
    public ZooCraft Main;

    private int particleTaskId;



    public CropModel(String Name, RarityEnum Rarity, int Growtime, ZooCraft main){
        this.Name = Name;
        Rarity = Rarity;
        this.GrowTime = Growtime;
        this.Main = main;
    }

    public void spawnCrop(Location loc, Player Owner){
        this.location = loc;
        loc.getWorld().getBlockAt(loc.add(0, 1, 0)).setType(Material.PLAYER_HEAD);

        particleTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main, new Runnable() {
            @Override
            public void run() {
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX(), loc.getY(), loc.getZ(), 1);
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX() + 0.5, loc.getY(), loc.getZ() + 0.5, 1);
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX() + 1, loc.getY(), loc.getZ() + 1, 1);
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX() + 1, loc.getY(), loc.getZ() + 0.5, 1);
                loc.getWorld().spawnParticle(Particle.HEART, loc.getX(), loc.getY(), loc.getZ() + 1, 1);
            }
        }, 5L, 10L );

    }

    public void stopParticles(){
            Bukkit.getScheduler().cancelTasks(Main);
    }
}
