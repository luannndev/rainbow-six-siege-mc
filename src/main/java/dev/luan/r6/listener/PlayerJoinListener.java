package dev.luan.r6.listener;

import dev.luan.r6.player.GamePlayerManager;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {

    private final GamePlayerManager gamePlayerManager;

    @EventHandler
    public void handle(PlayerJoinEvent event) {
        gamePlayerManager.addPlayer(event.getPlayer());
    }
}