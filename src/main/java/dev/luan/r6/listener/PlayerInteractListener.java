package dev.luan.r6.listener;

import dev.luan.r6.player.GamePlayerManager;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

@RequiredArgsConstructor
public class PlayerInteractListener implements Listener {

    private final GamePlayerManager gamePlayerManager;

    @EventHandler
    public void handle(PlayerInteractEvent event) {
        if (event.getItem().getItemMeta().displayName().equals(Component.text("Cam verlassen"))) {
            gamePlayerManager.getPlayer(event.getPlayer()).leaveCam();
        }
    }

}