package com.elwarriorcito.plugins.zoocraft.core.models;

import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import com.elwarriorcito.plugins.zoocraft.core.enums.RarityEnum;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.TileEntitySkull;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Bed;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.UUID;

public abstract class CropSuperModel {

    public int GrowTime;
    public RarityEnum Rarity;
    public String Name;
    public Location location;
    public Player Owner;
    public ZooCraft Main;
    public HologramModel holo;
    public int remainingGrowTime;
    public Material dropType;
    public Particle particleEffect;

    public String skinUuid;
    public  int particleTaskId;
    public int growTimeTaskId;

    public CropSuperModel(Material DropType, Integer GrowTime, String Name,
                          String skinUUI, RarityEnum Rarity, Particle particleEffect, ZooCraft Main){
        this.dropType = DropType;
        this.GrowTime = GrowTime;
        this.Name = Name;
        this.skinUuid = skinUUI;
        this.Rarity = Rarity;
        this.particleEffect = particleEffect;
        this.Main = Main;

        remainingGrowTime = GrowTime;

    }

    public void spawnCrop(Location location, Player Owner, Boolean playParticles){
        this.location = location;
        this.Owner = Owner;
        setHeadLocation();
        setHolo();
        startGrowTime();
        if (playParticles)
            playParticles();
    }

    public void setHeadLocation(){
        //Set the block state to A skull with skin so the skin is not lost when logged out
        Block b = location.add(0, 1, 0).getBlock();
        b.setType(Material.PLAYER_HEAD);

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", skinUuid));
        TileEntitySkull skullTile = (TileEntitySkull)
                ((CraftWorld) b.getWorld()).getHandle().getTileEntity(
                        new BlockPosition(b.getX(), b.getY(), b.getZ()));
        if (skullTile != null) {
            skullTile.setGameProfile(profile);
        }
        b.getState().update(true);
    }
    public void setHolo(){
        holo = new HologramModel();
        Location holoLocation = location.clone();
        holo.createLine(holoLocation.add(0.5, -0.2, 0.5), Name);
        holo.addLine("Growtime");
    }
    public void startGrowTime(){
        Random rnd = new Random();
        if (holo.getLine(2) != null) {
            growTimeTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main, new Runnable() {
                @Override
                public void run() {
                    holo.editLine(2, "&2GrowTime: " + remainingGrowTime);
                    remainingGrowTime--;
                    if (remainingGrowTime == 0){
                        remainingGrowTime = GrowTime;
                        dropWhenGrowTimeDone();
                    }
                }
            }, 0L, 20L);

        }
    }
    public abstract void dropWhenGrowTimeDone();
    public void removeCrop(){
        Bukkit.getScheduler().cancelTask(particleTaskId);
        Bukkit.getScheduler().cancelTask(growTimeTaskId);
        particleTaskId = 0;
        growTimeTaskId = 0;
        holo.removeHolo();
    }
    public abstract void playParticles();


}
