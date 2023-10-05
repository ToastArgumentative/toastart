package pine.toast.toastart.Classes.Items.Abilities;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pine.toast.toastart.LevelSystem.LevelManager;
import pine.toast.toastart.PluginUtilities.Keys;
import pine.toast.toastart.PluginUtilities.Rarity;

public class EchoingFury {

    public static void onHit(Player player) {
        int level = LevelManager.getLevel(player);
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        Rarity rarityString = Rarity.getRarityFromString(mainHand.getItemMeta().getPersistentDataContainer().get(Keys.rarity, PersistentDataType.STRING));

        if (rarityString == Rarity.LEGENDARY) {
            if (level >= 10) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3*20, 3));
            }
        } else if (rarityString == Rarity.EPIC) {
            if (level >= 5) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3*20, 3));
            }
        } else if (rarityString == Rarity.RARE) {
            if (level >= 1) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3*20, 2));
            }
        } else if (rarityString == Rarity.UNCOMMON) {
            if (level >= 1) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3*20, 1));
            }
        } else if (rarityString == Rarity.COMMON) {
            if (level >= 1) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3*20, 1));
            }
        }



    }
}
