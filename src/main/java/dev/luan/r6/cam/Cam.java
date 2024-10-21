package dev.luan.r6.cam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cam {

    private final Player operatingUser;
    private final List<Player> viewers;
    private final Location location;

    private CamState state;

}