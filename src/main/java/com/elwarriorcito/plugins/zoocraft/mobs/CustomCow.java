package com.elwarriorcito.plugins.zoocraft.mobs;

import com.elwarriorcito.plugins.zoocraft.core.ZooCraft;
import com.elwarriorcito.plugins.zoocraft.mobs.api.CustomEntityProperties;
import com.elwarriorcito.plugins.zoocraft.mobs.api.CustomMob;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.stream.Stream;

public class CustomCow implements Listener {

    private CustomEntityProperties properties = new CustomEntityProperties();
    private CustomMob customMob = new CustomMob();
    private Cow cow;

    @SuppressWarnings("unused")
    public void summonCow(Player player, String customName, String breed) {
        cow = player.getWorld().spawn(player.getLocation(), Cow.class);

        customMob.assignID();

        cow.setHealth(ZooCraft.MobConfig.getDouble("Cow.Default Health"));
        cow.setRemoveWhenFarAway(false);
        cow.setCustomName(customName + "[" + properties.getLevel() + "]");
        cow.setCustomNameVisible(true);

        properties.setBreed(breed);

    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if (entity == cow) {
          ;
        }
    }

}
