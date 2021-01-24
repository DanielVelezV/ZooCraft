<<<<<<< HEAD:src/main/java/com/elwarriorcito/plugins/zoocraft/Commands/GetPlantedCrops.java
package com.elwarriorcito.plugins.zoocraft.Commands;

=======
package com.elwarriorcito.plugins.zoocraft.commands;
import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import com.elwarriorcito.plugins.zoocraft.core.models.CropSuperModel;
>>>>>>> e8c3728653310fc125cffd66576f05e5547ecb8a:src/main/java/com/elwarriorcito/plugins/zoocraft/commands/GetPlantedCrops.java
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GetPlantedCrops implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
<<<<<<< HEAD:src/main/java/com/elwarriorcito/plugins/zoocraft/Commands/GetPlantedCrops.java
        /*for (CropModel crops : ZooCraft.plantedCrops){
=======
        for (CropSuperModel crops : ZooCraft.plantedCrops){
>>>>>>> e8c3728653310fc125cffd66576f05e5547ecb8a:src/main/java/com/elwarriorcito/plugins/zoocraft/commands/GetPlantedCrops.java
            sender.sendMessage("Crop Location: X: " + crops.location.getX() +
                    " Y: " + crops.location.getY() + " Z: " + crops.location.getZ());
            sender.sendMessage(crops.Name + " Owner:" + crops.Owner);
        } */
        return true;
        }
    }
