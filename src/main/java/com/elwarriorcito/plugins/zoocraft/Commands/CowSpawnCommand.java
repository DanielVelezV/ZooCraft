package com.elwarriorcito.plugins.zoocraft.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CowSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p;
        if (sender instanceof Player)
            p = (Player) sender;
        else
            return false;


        p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.BEE);

        return true;
    }
}
