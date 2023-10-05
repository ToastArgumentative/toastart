package pine.toast.toastart.RPG_WORLD;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import pine.toast.toastart.Classes.CharacterClass;
import pine.toast.toastart.PluginUtilities.Keys;

import java.util.Objects;

public class Restrictions implements Listener {

    @EventHandler
    public void onItemBurnOrExplode(EntityDamageEvent event) {
        if(!(event.getEntity() instanceof Item)) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        PersistentDataContainer playerData = player.getPersistentDataContainer();
        String className = playerData.get(Keys.characterClass, PersistentDataType.STRING);

        if (!Objects.equals(className, "Barbarian")){
            if (item != null && item.getType() == Material.IRON_AXE) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You are not a Barbarian!");
            } else if (item != null && item.getType() == Material.STONE_AXE) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You are not a Barbarian!");
            } else if (item != null && item.getType() == Material.GOLDEN_AXE) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You are not a Barbarian!");
            } else if (item != null && item.getType() == Material.DIAMOND_AXE) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You are not a Barbarian!");
            } else if (item != null && item.getType() == Material.NETHERITE_AXE) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You are not a Barbarian!");
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)) {
            return;
        }

        Player attacker = (Player) event.getDamager();
        Player target = (Player) event.getEntity();

        PersistentDataContainer attackerData = attacker.getPersistentDataContainer();
        String attackerClass = attackerData.get(Keys.characterClass, PersistentDataType.STRING);

        if (!Objects.equals(attackerClass, "Barbarian")) {
            Material weaponType = attacker.getInventory().getItemInMainHand().getType();
            if (weaponType == Material.IRON_AXE ||
                    weaponType == Material.STONE_AXE ||
                    weaponType == Material.GOLDEN_AXE ||
                    weaponType == Material.DIAMOND_AXE ||
                    weaponType == Material.NETHERITE_AXE) {
                event.setCancelled(true);
                attacker.sendMessage(ChatColor.RED + "You are not a Barbarian!");
            }
        }
    }

}
