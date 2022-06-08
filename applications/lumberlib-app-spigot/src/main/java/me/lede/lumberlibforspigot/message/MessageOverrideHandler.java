package me.lede.lumberlibforspigot.message;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MessageOverrideHandler implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        String joinMessage = Message.getJoinMessage();
        event.setJoinMessage(joinMessage);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(PlayerQuitEvent event) {
        String quitMessage = Message.getQuitMessage();
        event.setQuitMessage(quitMessage);
    }

}
