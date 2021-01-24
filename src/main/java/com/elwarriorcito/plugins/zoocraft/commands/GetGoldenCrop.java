package com.elwarriorcito.plugins.zoocraft.commands;

import com.elwarriorcito.plugins.zoocraft.items.ZooItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetGoldenCrop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p;
        if (sender instanceof Player)
            p = (Player) sender;
        else
            return false;

        p.getInventory().addItem(ZooItems.ZooGoldCropGet());

        return true;
    }
}
