package me.lede.lumberlibforspigot.registry;

import me.lede.lumberlibforspigot.LumberLib;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ListenerRegistry {

    public static void register(@NotNull Listener listener) {
        Plugin plugin = JavaPlugin.getPlugin(LumberLib.class);
        PluginManager manager = plugin.getServer().getPluginManager();
        manager.registerEvents(listener, plugin);
    }

}
