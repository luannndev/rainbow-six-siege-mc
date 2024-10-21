package dev.luan.r6.listener;

import dev.luan.r6.player.GamePlayer;
import dev.luan.r6.player.GamePlayerManager;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

@RequiredArgsConstructor
public class PlayerMoveListener implements Listener {

    private final GamePlayerManager gamePlayerManager;

    @EventHandler
    public void handle(PlayerMoveEvent event) {
        GamePlayer gamePlayer = gamePlayerManager.getPlayer(event.getPlayer());

        if (gamePlayer.isInCam()) {
            event.setCancelled(true);
        }
    }
}