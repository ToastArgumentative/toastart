package pine.toast.toastart.Classes;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import pine.toast.toastart.LegendsRebornV2;
import pine.toast.toastart.PluginUtilities.ActionBarManager;
import pine.toast.toastart.PluginUtilities.Keys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CharacterClass {
    private final double maxMana;
    private final double defense;
    private final int maxLevel;
    private final double manaPerSec;
    private String name;
    private Material icon;
    private int health;
    private int damage;



    public CharacterClass(String className, Material icon, int health, int damage, double maxMana, double manaPerSec, double defense, int maxLevel) {
        this.name = className;
        this.icon = icon;
        this.health = health;
        this.damage = damage;
        this.maxMana = maxMana;
        this.manaPerSec = manaPerSec;
        this.defense = defense;
        this.maxLevel = maxLevel;
    }



    public String getName() {
        return name;
    }

    public Material getIcon() {
        return icon;
    }


    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }


    public double getMaxMana() {
        return maxMana;
    }
    public double getManaPerSec() {
        return manaPerSec;
    }

    public double getDefense() {
        return defense;
    }
    public int getMaxLevel() {
        return maxLevel;
    }




    public static ItemStack getClassItem(CharacterClass characterClass) {
        // Create an ItemStack with the class's icon
        ItemStack itemStack = new ItemStack(characterClass.getIcon());

        // Get the ItemMeta to set lore
        ItemMeta meta = itemStack.getItemMeta();

        // Set the display name to the class name
        meta.setDisplayName(ChatColor.GOLD + characterClass.getName());
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        // Create lore to display class stats
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Health: " + characterClass.getHealth() + " ❤");
        lore.add(ChatColor.GRAY + "Damage: " + characterClass.getDamage() + " ☠");
        lore.add(ChatColor.GRAY + "Max Mana: " + characterClass.getMaxMana() + " ✨");
        lore.add(ChatColor.GRAY + "Mana Per Sec: " + characterClass.getManaPerSec() + " ✨");
        lore.add(ChatColor.GRAY + "Defense: " + characterClass.getDefense() + " 🛡");
        lore.add(ChatColor.GRAY + "Max Level: " + characterClass.getMaxLevel() + " ⚔");

        // Add the lore to the item
        meta.setLore(lore);

        // Apply the updated meta to the ItemStack
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public static void enforceClass(Player player, CharacterClass characterClass) {
        player.setHealthScale(40);

        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(characterClass.getHealth());
        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(characterClass.getDamage());
        player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(characterClass.getDefense());

        PersistentDataContainer playerData = player.getPersistentDataContainer();
        playerData.set(Keys.maxMana, PersistentDataType.DOUBLE, characterClass.getMaxMana());
        playerData.set(Keys.manaPerSec, PersistentDataType.DOUBLE, characterClass.getManaPerSec());
        playerData.set(Keys.characterClass, PersistentDataType.STRING, characterClass.getName());
        playerData.set(Keys.maxLevel, PersistentDataType.INTEGER, characterClass.getMaxLevel());


        player.setHealth(characterClass.getHealth());
        player.setFoodLevel(20);


    }

    public static boolean isBarbarian(Player player) {
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        return playerData.get(Keys.characterClass, PersistentDataType.STRING).equals("Barbarian");
    }

    public static boolean isMage(Player player) {
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        return playerData.get(Keys.characterClass, PersistentDataType.STRING).equals("Mage");
    }

    public static boolean isKnight(Player player) {
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        return playerData.get(Keys.characterClass, PersistentDataType.STRING).equals("Knight");
    }

    public static boolean isBomber(Player player) {
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        return playerData.get(Keys.characterClass, PersistentDataType.STRING).equals("Bomber");
    }

}

