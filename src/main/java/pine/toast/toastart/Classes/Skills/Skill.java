package pine.toast.toastart.Classes.Skills;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public interface Skill {
    String getName();
    Material getIcon();
    List<String> getDescription();
    List<String> getStats();
    // Additional methods or properties as needed

    public static ItemStack getSkillItem(Skill skill) {
        ItemStack itemStack = new ItemStack(skill.getIcon());
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + skill.getName());
        itemMeta.setLore(skill.getDescription());
        // You can add more lore lines for stats or additional information here
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
