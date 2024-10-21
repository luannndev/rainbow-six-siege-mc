package dev.luan.r6.cam;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface CamManager {

    Cam createCam(Location location, Player operatingPlayer);

    void destroyCam(Location location);

}