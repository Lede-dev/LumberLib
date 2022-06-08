package me.lede.lumberlibforspigot;

import me.lede.lumberlibforspigot.registry.ListenerRegistry;
import me.lede.lumberlibforspigot.message.MessageOverrideHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class LumberLib extends JavaPlugin {

    @Override
    public void onEnable() {

        // Register listeners
        ListenerRegistry.register(new MessageOverrideHandler());

        // Register Commands

    }

    @Override
    public void onDisable() {

    }

}
