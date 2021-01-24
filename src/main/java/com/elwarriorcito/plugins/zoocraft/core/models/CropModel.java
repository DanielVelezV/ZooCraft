package com.elwarriorcito.plugins.zoocraft.core.models;

import com.elwarriorcito.plugins.zoocraft.core.enums.RarityEnum;
import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.TileEntitySkull;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.UUID;

public class CropModel {

    public int GrowTime;
    public RarityEnum Rarity;
    public String Name;
    public Location location;
    public Player Owner;
    public ZooCraft Main;
    public HologramModel holo;
    public int remainingGrowTime;
    public Material DropType;

    public  int particleTaskId;
    public int growTimeTaskId;



    public CropModel(String Name, RarityEnum Rarity, int Growtime, ZooCraft main, Material DropType){
        this.Name = Name;
        this.Rarity = Rarity;
        this.GrowTime = Growtime;
        this.Main = main;
        remainingGrowTime = GrowTime;
        this.DropType = DropType;
    }

    public void spawnCrop(Location loc, Player Owner){
        this.location = loc;
        this.Owner = Owner;


        //Set the block state to A skull with skin so the skin is not lost when logged out
        Block b = loc.add(0, 1, 0).getBlock();
        b.setType(Material.PLAYER_HEAD);

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTAxMjRhYzhkMzNmZTUxMzljOGRiMGZlNDUxMmZiMTY3NmQ5NWQzNjk4ZTVkZjU4Yjc2YjQxNTgzOGVhZWIifX19"));
        TileEntitySkull skullTile = (TileEntitySkull)
                ((CraftWorld) b.getWorld()).getHandle().getTileEntity(
                        new BlockPosition(b.getX(), b.getY(), b.getZ()));
        if (skullTile != null) {
            skullTile.setGameProfile(profile);
        }
        b.getState().update(true);

        //loc.getWorld().getBlockAt(loc.add(0, 1, 0)).setType(Material.PLAYER_HEAD);

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
        startGrowTimeCountDown();

    }

    public void stopParticles(){
            Bukkit.getScheduler().cancelTasks(Main);
            particleTaskId = 0;
            growTimeTaskId = 0;
    }

    public void startGrowTimeCountDown() {
        Random rnd = new Random();
        if (holo.getLine(2) != null) {
            growTimeTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main, new Runnable() {
                @Override
                public void run() {
                    holo.editLine(2, "&2GrowTime: " + remainingGrowTime);
                    remainingGrowTime--;
                    if (remainingGrowTime == 0){
                        remainingGrowTime = GrowTime;
                        location.getWorld().dropItem(location, new ItemStack(DropType, rnd.nextInt(5)));
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
