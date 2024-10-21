package dev.luan.r6;

import dev.luan.r6.cam.CamManager;
import dev.luan.r6.cam.CamManagerImpl;
import dev.luan.r6.command.TestCommand;
import dev.luan.r6.listener.PlayerInteractListener;
import dev.luan.r6.listener.PlayerJoinListener;
import dev.luan.r6.listener.PlayerMoveListener;
import dev.luan.r6.player.GamePlayerManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class RainbowPlugin extends JavaPlugin {

    private GamePlayerManager gamePlayerManager;
    private CamManager camManager;

    @Override
    public void onEnable() {
        this.gamePlayerManager = new GamePlayerManager();
        this.camManager = new CamManagerImpl();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(gamePlayerManager), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(gamePlayerManager), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(gamePlayerManager), this);

        getCommand("test").setExecutor(new TestCommand(this));
    }
}