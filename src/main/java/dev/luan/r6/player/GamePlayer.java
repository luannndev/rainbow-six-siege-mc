package dev.luan.r6.player;

import dev.luan.r6.cam.Cam;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@Getter
@RequiredArgsConstructor
public class GamePlayer {

    private final Player player;
    private boolean isInCam = false;
    private ArmorStand playerDummy;

    public void enterCam(Cam cam) {
        isInCam = true;

        // set allow flight to true so the player will not be kicked for flying
        player.setAllowFlight(true);

        Location playerLocation = player.getLocation();

        this.playerDummy = (ArmorStand) player.getWorld().spawnEntity(playerLocation, EntityType.ARMOR_STAND);
        playerDummy.customName(Component.text(player.getName()));
        playerDummy.setCustomNameVisible(true);
        playerDummy.setInvulnerable(false);
        playerDummy.setGravity(false);
        playerDummy.setArms(true);
        playerDummy.setHelmet(new ItemStack(Material.PLAYER_HEAD));

        playerDummy.teleport(playerLocation);

        player.addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(1000, 2000), false);
        player.teleport(cam.getLocation().add(0, 1, 0));

        // create an item for leaving the camera
        ItemStack leaveItem = new ItemStack(Material.RED_DYE);
        ItemMeta itemMeta = leaveItem.getItemMeta();

        itemMeta.displayName(Component.text("Cam verlassen"));

        leaveItem.setItemMeta(itemMeta);

        player.getInventory().setItem(4, leaveItem);
    }

    public void leaveCam() {
        isInCam = false;

        for (PotionEffect activePotionEffect : player.getActivePotionEffects()) {
            player.removePotionEffect(activePotionEffect.getType());
        }

        restoreInventory();

        player.teleport(playerDummy.getLocation().add(0, 1, 0));
        player.setAllowFlight(false);

        playerDummy.remove();
    }

    private void restoreInventory() {
        player.getInventory().clear();

        //todo add weapons, drones, blalalalal
    }
}