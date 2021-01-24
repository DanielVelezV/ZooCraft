package com.elwarriorcito.plugins.zoocraft.mobs;

import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import com.elwarriorcito.plugins.zoocraft.mobs.api.CustomEntityProperties;

public class CustomCow implements Listener {

    private CustomEntityProperties properties = new CustomEntityProperties();

    private Cow cow;

    @SuppressWarnings("unused")
    public void summonCow(Player player, String customName, double health, String breed) {
        cow = player.getWorld().spawn(player.getLocation(), Cow.class);

        cow.setHealth(health);
        cow.setRemoveWhenFarAway(false);
        cow.setCustomName(customName + "[" + properties.getLevel() + "]");
        cow.setCustomNameVisible(true);

        properties.setBreed(breed);

    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if (entity == cow) {
            entity.getLocation().getWorld();
        }
    }

}
