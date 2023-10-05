package pine.toast.toastart.PluginUtilities;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public enum Rarity {
    COMMON(ChatColor.WHITE, "COMMON"),
    UNCOMMON(ChatColor.GREEN, "UNCOMMON"),
    RARE(ChatColor.BLUE, "RARE"),
    EPIC(ChatColor.LIGHT_PURPLE, "EPIC"),
    LEGENDARY(ChatColor.GOLD, "LEGENDARY");

    private final ChatColor color;
    private final String stringValue;

    Rarity(ChatColor color, String stringValue) {
        this.color = color;
        this.stringValue = stringValue;
    }

    public ChatColor getColor() {
        return color;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static Rarity getRarityFromString(String rarityString) {
        for (Rarity rarity : Rarity.values()) {
            if (rarity.getStringValue().equals(rarityString)) {
                return rarity; // Found a matching Rarity enum value
            }
        }
        return Rarity.COMMON; // Default to COMMON if no match is found
    }

    public static Rarity getNextRarity(Rarity currentRarity) {
        int ordinal = currentRarity.ordinal();
        Rarity[] rarities = Rarity.values();

        if (ordinal < rarities.length - 1) {
            return rarities[ordinal + 1];
        } else {
            return currentRarity;
        }
    }




}


