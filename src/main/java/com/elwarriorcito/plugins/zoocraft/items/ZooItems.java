package com.elwarriorcito.plugins.zoocraft.items;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class ZooItems {

    public static ItemStack ZooGoldCropGet(){
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTAxMjRhYzhkMzNmZTUxMzljOGRiMGZlNDUxMmZiMTY3NmQ5NWQzNjk4ZTVkZjU4Yjc2YjQxNTgzOGVhZWIifX19"));
        Field field;
        try{
            field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        }catch(NoSuchFieldException | IllegalArgumentException | IllegalAccessException e){
            System.out.println("Error giving item");
        }

        meta.setDisplayName(ChatColor.GOLD + "" +  ChatColor.BOLD + "Golden Wheat Crop");
        item.setItemMeta(meta);

        return item;
    }




}
