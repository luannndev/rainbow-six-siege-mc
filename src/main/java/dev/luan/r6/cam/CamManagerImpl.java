package dev.luan.r6.cam;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CamManagerImpl implements CamManager {

    private final List<Cam> cams = new ArrayList<>();

    public Cam createCam(Location location, Player operatingPlayer) {
        Cam cam = new Cam(operatingPlayer, List.of(), location, CamState.ACTIVE);
        cams.add(cam);

        World world = location.getWorld();
        Bat entity = (Bat) world.spawnEntity(location, EntityType.BAT);

        entity.setAI(false);
        entity.setNoPhysics(true);
        entity.setInvulnerable(false);
        entity.setSilent(true);
        entity.setPersistent(true);

        return cam;
    }

    @Override
    public void destroyCam(Location location) {

    }
}