package dev.brwr.piglinfix;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PiglinFixPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        this.getComponentLogger().debug(Component.text("hello i give many xp"));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDeath(EntityDeathEvent event) {
        var entity = event.getEntity();
        if (event.getEntityType() != EntityType.ZOMBIFIED_PIGLIN || !(entity instanceof PigZombie)) return;
        PigZombie piglin = (PigZombie) entity;

        if (!piglin.isAngry()) return;

        // piglin is angry. make sure it drops xp :3
        event.setDroppedExp(6);
    }
}
