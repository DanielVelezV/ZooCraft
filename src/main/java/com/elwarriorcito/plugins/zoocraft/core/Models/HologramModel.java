package com.elwarriorcito.plugins.zoocraft.core.Models;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.HashMap;

public class HologramModel {

    public HashMap<Integer, ArmorStand> lines;
    private int Linescount;

    public HologramModel(){
        this.lines = new HashMap<Integer, ArmorStand>();
        Linescount = 0;

    }

    public void createLine(Location loc, String Line){
       ArmorStand firstLine = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
       firstLine.setCustomName(c(Line));
       firstLine.setCustomNameVisible(true);
       firstLine.setGravity(false);
       firstLine.setInvisible(true);
       firstLine.setInvulnerable(true);
       Linescount++;
       lines.put(Linescount, firstLine);
    }

    public void addLine(String Line){
        ArmorStand lineAbove = lines.get(Linescount);
        ArmorStand line = (ArmorStand) lineAbove.getLocation().getWorld().
                spawnEntity(lineAbove.getLocation().add(0, -0.3, 0), EntityType.ARMOR_STAND);
        line.setCustomName(c(Line));
        line.setCustomNameVisible(true);
        line.setGravity(false);
        line.setInvisible(true);
        line.setInvulnerable(true);
        Linescount++;
        lines.put(Linescount, line);
    }

    public void removeLine(int lineId){
        if (lines.get(lineId) != null){
            lines.get(lineId).remove();
        }
    }

    public int getLinescount(){return Linescount;}


    private String c(final String c) {
        return ChatColor.translateAlternateColorCodes('&', c);
    }


}
