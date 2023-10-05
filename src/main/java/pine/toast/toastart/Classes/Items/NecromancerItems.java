package pine.toast.toastart.Classes.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import pine.toast.toastart.PluginUtilities.Keys;
import pine.toast.toastart.PluginUtilities.Rarity;

import java.util.ArrayList;
import java.util.List;

public class NecromancerItems {

    public static ItemStack getBoneShoesEpic() {
        ItemStack boneShoes = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta boneShoesMeta = boneShoes.getItemMeta();

        PersistentDataContainer itemData = boneShoesMeta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "EPIC");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        boneShoesMeta.setDisplayName(itemRarity.getColor() + "Bone Shoes"); // Set the color of the item name
        boneShoesMeta.setCustomModelData(1);
        boneShoesMeta.setUnbreakable(true);

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- Bone Shoes ---"); // Set the color of the headline
        lore.add(ChatColor.GRAY + "Shoes made from the bones of your enemies");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "Bone shoes alter your dark summoner skill.");
        lore.add(ChatColor.GRAY + "Summoner can now summon skeletons on top of zombies.");


        boneShoesMeta.setLore(lore);
        boneShoesMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        boneShoes.setItemMeta(boneShoesMeta);
        return boneShoes;



    }
}
