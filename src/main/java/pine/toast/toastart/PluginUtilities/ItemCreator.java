package pine.toast.toastart.PluginUtilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemCreator {

    public static ItemStack createItem(Material material, String displayName, List<String> lore, boolean unbreakable, List<Enchantment> enchantments, List<Integer> enchantmentLevels, ItemFlag... itemFlags) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(displayName);

        // Set lore
        if (lore != null && !lore.isEmpty()) {
            List<String> translatedLore = new ArrayList<>();
            for (String line : lore) {
                translatedLore.add(ChatColor.translateAlternateColorCodes('&', line));
            }
            itemMeta.setLore(translatedLore);
        }

        // Add enchantments
        if (enchantments != null && enchantmentLevels != null && enchantments.size() == enchantmentLevels.size()) {
            for (int i = 0; i < enchantments.size(); i++) {
                Enchantment enchantment = enchantments.get(i);
                int level = enchantmentLevels.get(i);
                itemMeta.addEnchant(enchantment, level, true);
            }
        }

        itemMeta.setUnbreakable(unbreakable);

        // Set item flags
        if (itemFlags != null && itemFlags.length > 0) {
            itemMeta.addItemFlags(itemFlags);
        }

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }


}
