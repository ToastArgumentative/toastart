package pine.toast.toastart.Classes.Items;

import io.papermc.paper.event.player.AsyncChatCommandDecorateEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import pine.toast.toastart.PluginUtilities.Keys;
import pine.toast.toastart.PluginUtilities.Rarity;

import java.util.ArrayList;
import java.util.List;

public class BarbarianItems {


    public static ItemStack getTheFurnaceCommon() {
        ItemStack theFurnace = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = theFurnace.getItemMeta();
        meta.setCustomModelData(0);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "COMMON");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses
        meta.setDisplayName(itemRarity.getColor() + "The Furnace"); // Set the color of the item name

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 5, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 0.5, AttributeModifier.Operation.ADD_NUMBER));

        double damage = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE).stream().findFirst().get().getAmount();
        double attackSpeed = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_SPEED).stream().findFirst().get().getAmount();

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- The Furnace ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Whirlwind does increased damage.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + damage);
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + attackSpeed);

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        theFurnace.setItemMeta(meta);
        return theFurnace;
    }

    public static ItemStack getTheFurnaceUncommon() {
        ItemStack theFurnace = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = theFurnace.getItemMeta();
        meta.setDisplayName(Rarity.RARE.getColor() + "The Furnace"); // Set the color of the item name
        meta.setCustomModelData(0);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "UNCOMMON");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 7, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 0.6, AttributeModifier.Operation.ADD_NUMBER));

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- The Furnace ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Whirlwind does increased damage.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + "7");
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + "0.6");

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        theFurnace.setItemMeta(meta);
        return theFurnace;
    }

    public static ItemStack getTheFurnaceRare() {
        ItemStack theFurnace = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = theFurnace.getItemMeta();
        meta.setDisplayName(Rarity.RARE.getColor() + "The Furnace"); // Set the color of the item name
        meta.setCustomModelData(0);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "RARE");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 9, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 0.7, AttributeModifier.Operation.ADD_NUMBER));

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- The Furnace ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Whirlwind does increased damage.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + "9");
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + "0.7");

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        theFurnace.setItemMeta(meta);
        return theFurnace;
    }

    public static ItemStack getTheFurnaceEpic() {
        ItemStack theFurnace = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = theFurnace.getItemMeta();
        meta.setDisplayName(Rarity.RARE.getColor() + "The Furnace"); // Set the color of the item name
        meta.setCustomModelData(0);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "EPIC");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 11, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 0.8, AttributeModifier.Operation.ADD_NUMBER));

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- The Furnace ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Whirlwind does increased damage.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + "11");
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + "0.8");

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        theFurnace.setItemMeta(meta);
        return theFurnace;
    }

    public static ItemStack getTheFurnaceLegendary() {
        ItemStack theFurnace = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = theFurnace.getItemMeta();
        meta.setDisplayName(Rarity.RARE.getColor() + "The Furnace"); // Set the color of the item name
        meta.setCustomModelData(0);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "LEGENDARY");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 13, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 0.9, AttributeModifier.Operation.ADD_NUMBER));

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- The Furnace ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Whirlwind does increased damage.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + "9");
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + "1.5");

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        theFurnace.setItemMeta(meta);
        return theFurnace;
    }


    public static ItemStack getEchoingFuryCommon() {
        ItemStack echoingFury = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = echoingFury.getItemMeta();
        meta.setDisplayName(Rarity.COMMON.getColor() + "Echoing Fury"); // Set the color of the item name
        meta.setCustomModelData(2);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "COMMON");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 5, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 0.5, AttributeModifier.Operation.ADD_NUMBER));

        double damage = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE).stream().findFirst().get().getAmount();
        double attackSpeed = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_SPEED).stream().findFirst().get().getAmount();

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- Echoing Fury ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Increased attack speed while attacking.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + damage);
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + attackSpeed);

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        echoingFury.setItemMeta(meta);
        return echoingFury;
    }

    public static ItemStack getEchoingFuryUncommon() {
        ItemStack echoingFury = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = echoingFury.getItemMeta();
        meta.setDisplayName(Rarity.UNCOMMON.getColor() + "Echoing Fury"); // Set the color of the item name
        meta.setCustomModelData(2);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "UNCOMMON");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 5.5, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 0.6, AttributeModifier.Operation.ADD_NUMBER));

        double damage = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE).stream().findFirst().get().getAmount();
        double attackSpeed = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_SPEED).stream().findFirst().get().getAmount();

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- Echoing Fury ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Increased attack speed while attacking.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + damage);
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + attackSpeed);

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        echoingFury.setItemMeta(meta);
        return echoingFury;
    }

    public static ItemStack getEchoingFuryRare() {
        ItemStack echoingFury = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = echoingFury.getItemMeta();
        meta.setDisplayName(Rarity.COMMON.getColor() + "Echoing Fury"); // Set the color of the item name
        meta.setCustomModelData(2);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "RARE");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 6.0, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 0.7, AttributeModifier.Operation.ADD_NUMBER));

        double damage = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE).stream().findFirst().get().getAmount();
        double attackSpeed = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_SPEED).stream().findFirst().get().getAmount();

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- Echoing Fury ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Increased attack speed while attacking.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + damage);
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + attackSpeed);

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        echoingFury.setItemMeta(meta);
        return echoingFury;
    }

    public static ItemStack getEchoingFuryEpic() {
        ItemStack echoingFury = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = echoingFury.getItemMeta();
        meta.setDisplayName(Rarity.EPIC.getColor() + "Echoing Fury"); // Set the color of the item name
        meta.setCustomModelData(2);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "EPIC");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 6.5, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 0.8, AttributeModifier.Operation.ADD_NUMBER));

        double damage = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE).stream().findFirst().get().getAmount();
        double attackSpeed = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_SPEED).stream().findFirst().get().getAmount();

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- Echoing Fury ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Increased attack speed while attacking.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + damage);
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + attackSpeed);

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        echoingFury.setItemMeta(meta);
        return echoingFury;
    }

    public static ItemStack getEchoingFuryLegendary() {
        ItemStack echoingFury = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = echoingFury.getItemMeta();
        meta.setDisplayName(Rarity.LEGENDARY.getColor() + "Echoing Fury"); // Set the color of the item name
        meta.setCustomModelData(2);

        PersistentDataContainer itemData = meta.getPersistentDataContainer();
        itemData.set(Keys.rarity, PersistentDataType.STRING, "LEGENDARY");

        String itemRarityString = itemData.get(Keys.rarity, PersistentDataType.STRING);

        Rarity itemRarity = Rarity.getRarityFromString(itemRarityString); // Use the method from previous responses

        // Remove all attribute modifiers
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);

        // Add new attribute modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack_damage", 9, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attack_speed", 1.0, AttributeModifier.Operation.ADD_NUMBER));

        double damage = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE).stream().findFirst().get().getAmount();
        double attackSpeed = meta.getAttributeModifiers(Attribute.GENERIC_ATTACK_SPEED).stream().findFirst().get().getAmount();

        List<String> lore = new ArrayList<>();
        lore.add(itemRarity.getColor() + " --- Echoing Fury ---"); // Set the color of the headline

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Description ---");
        lore.add(ChatColor.GRAY + "A powerful Mace.");
        lore.add(ChatColor.GRAY + "Increased attack speed while attacking.");

        lore.add("");

        lore.add(itemRarity.getColor() + " --- Stats ---");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.GREEN + damage);
        lore.add(ChatColor.GRAY + "Attack Speed: " + ChatColor.GREEN + attackSpeed);

        lore.add("");

        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        echoingFury.setItemMeta(meta);
        return echoingFury;
    }


}
