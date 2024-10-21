package dev.luan.r6.player;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GamePlayerManager {

    private final List<GamePlayer> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(new GamePlayer(player));
    }

    public GamePlayer getPlayer(Player player) {
        return players.stream().filter(gamePlayer -> gamePlayer.getPlayer() == player).findFirst().orElse(null);
    }
}