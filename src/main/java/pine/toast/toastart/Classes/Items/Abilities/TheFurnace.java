package pine.toast.toastart.Classes.Items.Abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import pine.toast.toastart.Classes.Items.BarbarianItems;
import pine.toast.toastart.PluginUtilities.Keys;
import pine.toast.toastart.PluginUtilities.Rarity;

public class TheFurnace {

    public static void whirlwindBuff(Player player) {
        ItemStack playerMainHand = player.getInventory().getItemInMainHand();
        ItemMeta playerMainHandMeta = playerMainHand.getItemMeta();

        PersistentDataContainer playerMainHandData = playerMainHandMeta.getPersistentDataContainer();
        String itemRarityString = playerMainHandData.get(Keys.rarity, PersistentDataType.STRING);
        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString);

        PersistentDataContainer theFurnaceData = BarbarianItems.getTheFurnaceRare().getItemMeta().getPersistentDataContainer();
        String theFurnaceRarityString = theFurnaceData.get(Keys.rarity, PersistentDataType.STRING);
        Rarity theFurnaceRarity = Rarity.getRarityFromString(theFurnaceRarityString);

        int customModelData = playerMainHandMeta.getCustomModelData();
        int theFurnaceModelData = BarbarianItems.getTheFurnaceRare().getItemMeta().getCustomModelData();

        if (itemRarity == Rarity.LEGENDARY){
            if (customModelData == theFurnaceModelData) {
                double radius = 10.0;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(8, player);
                    }
                }
            }
            player.sendMessage(itemRarity.getColor() + "[ The Furnace ] " + ChatColor.GREEN + "Whirlwind buff applied!");
        } else if ( itemRarity == Rarity.EPIC) {
            if (customModelData == theFurnaceModelData) {
                double radius = 8.5;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(6.5, player);
                    }
                }
            }
            player.sendMessage(itemRarity.getColor() + "[ The Furnace ] " + ChatColor.GREEN + "Whirlwind buff applied!");
        } else if ( itemRarity == Rarity.RARE) {
            if (customModelData == theFurnaceModelData) {
                double radius = 7.5;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(3.25, player);
                    }
                }
            }
            player.sendMessage(itemRarity.getColor() + "[ The Furnace ] " + ChatColor.GREEN + "Whirlwind buff applied!");
        } else if ( itemRarity == Rarity.UNCOMMON) {
            if (customModelData == theFurnaceModelData) {
                double radius = 6.5;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(2.5, player);
                    }
                }
            }
            player.sendMessage(itemRarity.getColor() + "[ The Furnace ] " + ChatColor.GREEN + "Whirlwind buff applied!");
        } else if ( itemRarity == Rarity.COMMON) {
            if (customModelData == theFurnaceModelData) {
                double radius = 5.5;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(1.5, player);
                    }
                }
            }
            player.sendMessage(itemRarity + "[ The Furnace ] " + ChatColor.GREEN + "Whirlwind buff applied!");
        }


    }
}
