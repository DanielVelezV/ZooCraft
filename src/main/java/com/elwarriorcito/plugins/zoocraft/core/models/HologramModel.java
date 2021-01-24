package com.elwarriorcito.plugins.zoocraft.core.models;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import java.util.HashMap;

public class HologramModel {

    public HashMap<Integer, ArmorStand> lines; //Line : Text/Entity
    private int Linescount; //Count all the lines that an Hologram have

    public HologramModel(){
        this.lines = new HashMap<Integer, ArmorStand>();
        Linescount = 0;

    }

    public void createLine(Location loc, String Line){ //Always call this for the firstLine
       ArmorStand firstLine = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND); //First Line
       firstLine.setCustomName(c(Line)); //The line text (Can use color codes from Minecraft)
       firstLine.setCustomNameVisible(true); //Custom name visibility
       firstLine.setGravity(false); //No gravity
       firstLine.setInvisible(true); //Invisible
       firstLine.setInvulnerable(true); //Invulnerability (Only works on Survival Mode)
       Linescount++; //Add 1 to the lines count
       lines.put(Linescount, firstLine); //add this line to the line list
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

    public void removeLine(int lineId){ //Remove line by Line ID
        if (lines.get(lineId) != null){
            lines.get(lineId).remove();
        }
    }

    public void editLine(int lineId, String newLine){
        if (lines.get(lineId) !=null)
            lines.get(lineId).setCustomName(c(newLine));

    }

    public String getLine(int lineId){
        if (lines.get(lineId) !=null)
            return lines.get(lineId).getCustomName();
        else
            return null;
    }

    public void removeHolo(){
        lines.forEach((k, v) -> v.remove());
    }

    public int getLinescount(){return Linescount;} //Get how many lines this Hologram have


    private String c(final String c) { //Color codes from Minecraft
        return ChatColor.translateAlternateColorCodes('&', c);
    }


}
