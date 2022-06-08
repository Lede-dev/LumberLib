package me.lede.lumberlibforspigot.registry;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;

public class CommandRegistry {

    public static boolean register(@NotNull BukkitCommand command) {
        CommandMap commandMap = getCommandMap();
        if (commandMap == null) {
            throw new NullPointerException("Cannot find CommandMap.");
        }
        return commandMap.register(command.getName(), command);
    }

    @Nullable
    public static CommandMap getCommandMap() {
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            return (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
