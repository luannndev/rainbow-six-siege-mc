package dev.luan.r6.command;

import dev.luan.r6.RainbowPlugin;
import dev.luan.r6.cam.Cam;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class TestCommand implements CommandExecutor {

    private final RainbowPlugin plugin;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Cam cam = plugin.getCamManager().createCam(new Location(plugin.getServer().getWorld("world"), 0, 150, 0), null);

        plugin.getGamePlayerManager().getPlayer((Player) sender).enterCam(cam);

        return false;
    }
}