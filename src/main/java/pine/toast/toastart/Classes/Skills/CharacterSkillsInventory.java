package pine.toast.toastart.Classes.Skills;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import pine.toast.toastart.Classes.Skills.Barbarian.BeserkerSkill;
import pine.toast.toastart.Classes.Skills.Barbarian.WhirlwindSkill;
import pine.toast.toastart.Classes.Skills.Bomber.BombSkill;
import pine.toast.toastart.Classes.Skills.Bomber.LastResortSkill;
import pine.toast.toastart.Classes.Skills.Mage.ShieldSkill;
import pine.toast.toastart.Classes.Skills.Mage.SummonSkill;
import pine.toast.toastart.Classes.Skills.Necromancer.BloodSiphon;
import pine.toast.toastart.Classes.Skills.Necromancer.DarkSummonerSkill;
import pine.toast.toastart.LevelSystem.LevelManager;
import pine.toast.toastart.PluginUtilities.Keys;

public class CharacterSkillsInventory implements Listener {

    public static void openClassSkillInventory(Player player, String characterClass) {

        switch (characterClass) {
            case "Barbarian":
                barbInv(player, characterClass);
                break;
            case "Mage":
                mageInv(player, characterClass);
                break;
            case "Bomber":
                bomberInv(player, characterClass);
                break;
        }

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        PersistentDataContainer playerData = player.getPersistentDataContainer();

        Boolean whirlwind = playerData.get(Keys.whirlwind, PersistentDataType.BOOLEAN);
        Boolean shield = playerData.get(Keys.shield, PersistentDataType.BOOLEAN);
        Boolean bomb = playerData.get(Keys.bomb, PersistentDataType.BOOLEAN);
        Boolean lastResort = playerData.get(Keys.lastResort, PersistentDataType.BOOLEAN);
        Boolean beserker = playerData.get(Keys.berserker, PersistentDataType.BOOLEAN);
        Boolean summoner = playerData.get(Keys.summoner, PersistentDataType.BOOLEAN);

        if(event.getInventory().getHolder() == null && event.getView().getTitle().contains("Barbarian Skills")) {
            event.setCancelled(true);
            if(!(LevelManager.getLevel(player) >= 5)) return;

            if(event.getSlot() == 0) {
                if(!whirlwind){
                    playerData.set(Keys.whirlwind, PersistentDataType.BOOLEAN, true);
                    event.getInventory().getItem(0).removeEnchantment(Enchantment.MENDING);
                    player.sendMessage(ChatColor.GREEN + "You have selected the Whirlwind skill!");
                } else {
                    playerData.set(Keys.whirlwind, PersistentDataType.BOOLEAN, false);
                    event.getInventory().getItem(0).addEnchantment(Enchantment.MENDING, 1);
                    event.getInventory().getItem(0).addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    player.sendMessage(ChatColor.GREEN + "You have deselected the Whirlwind skill!");
                }
            } else if (event.getSlot() == 1) {
                if(!beserker){
                    playerData.set(Keys.berserker, PersistentDataType.BOOLEAN, true);
                    event.getInventory().getItem(1).removeEnchantment(Enchantment.MENDING);
                    player.sendMessage(ChatColor.GREEN + "You have selected the Beserker skill!");
                } else {
                    playerData.set(Keys.berserker, PersistentDataType.BOOLEAN, false);
                    event.getInventory().getItem(1).addUnsafeEnchantment(Enchantment.MENDING, 1);
                    event.getInventory().getItem(1).addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    player.sendMessage(ChatColor.GREEN + "You have deselected the Beserker skill!");
                }
            }

        } else if (event.getInventory().getHolder() == null && event.getView().getTitle().contains("Mage Skills")) {
            event.setCancelled(true);
            if(!(LevelManager.getLevel(player) >= 3)) return;

            if(event.getSlot() == 0) {
                if(!shield){
                    playerData.set(Keys.shield, PersistentDataType.BOOLEAN, true);
                    event.getInventory().getItem(0).removeEnchantment(Enchantment.MENDING);
                    player.sendMessage(ChatColor.GREEN + "You have selected the Shield skill!");
                } else {
                    playerData.set(Keys.shield, PersistentDataType.BOOLEAN, false);
                    event.getInventory().getItem(0).addUnsafeEnchantment(Enchantment.MENDING, 1);
                    event.getInventory().getItem(0).addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    player.sendMessage(ChatColor.GREEN + "You have deselected the Shield skill!");
                }
            } else if (event.getSlot() == 1) {
                if(!summoner){
                    playerData.set(Keys.summoner, PersistentDataType.BOOLEAN, true);
                    event.getInventory().getItem(1).removeEnchantment(Enchantment.MENDING);
                    player.sendMessage(ChatColor.GREEN + "You have selected the Summoner skill!");
                } else {
                    playerData.set(Keys.summoner, PersistentDataType.BOOLEAN, false);
                    event.getInventory().getItem(1).addUnsafeEnchantment(Enchantment.MENDING, 1);
                    event.getInventory().getItem(1).addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    player.sendMessage(ChatColor.GREEN + "You have deselected the Summoner skill!");
                }
            }

        } else if (event.getInventory().getHolder() == null && event.getView().getTitle().contains("Knight Skills")) {
            event.setCancelled(true);

        } else if (event.getInventory().getHolder() == null && event.getView().getTitle().contains("Bomber Skills")) {
            event.setCancelled(true);

            if(!(LevelManager.getLevel(player) >= 4)) return;

            if(event.getSlot() == 0) {
                if(!bomb){
                    playerData.set(Keys.bomb, PersistentDataType.BOOLEAN, true);
                    event.getInventory().getItem(0).removeEnchantment(Enchantment.MENDING);
                    player.sendMessage(ChatColor.GREEN + "You have selected the Bomb skill!");
                } else {
                    playerData.set(Keys.bomb, PersistentDataType.BOOLEAN, false);
                    event.getInventory().getItem(0).addUnsafeEnchantment(Enchantment.MENDING, 1);
                    event.getInventory().getItem(0).addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    player.sendMessage(ChatColor.GREEN + "You have deselected the Bomb skill!");
                }
            } else if (event.getSlot() == 1) {
                if(!lastResort){
                    playerData.set(Keys.lastResort, PersistentDataType.BOOLEAN, true);
                    event.getInventory().getItem(1).removeEnchantment(Enchantment.MENDING);
                    player.sendMessage(ChatColor.GREEN + "You have selected the Last Resort skill!");
                } else {
                    playerData.set(Keys.lastResort, PersistentDataType.BOOLEAN, false);
                    event.getInventory().getItem(1).addUnsafeEnchantment(Enchantment.MENDING, 1);
                    event.getInventory().getItem(1).addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    player.sendMessage(ChatColor.GREEN + "You have deselected the Last Resort skill!");
                }
            }

        }
    }



    private static void barbInv(Player player, String characterClass) {
        Inventory barbInvenv = Bukkit.createInventory(null, 9, ChatColor.BOLD + characterClass + " Skills");

        PersistentDataContainer playerData = player.getPersistentDataContainer();
        int currentLevel = LevelManager.getLevel(player);

        if(LevelManager.getLevel(player) >= 5) {
            barbInvenv.setItem(0, Skill.getSkillItem(new WhirlwindSkill()));
        }

        if(LevelManager.getLevel(player) >= 11) {
            barbInvenv.setItem(1, Skill.getSkillItem(new BeserkerSkill()));
        }


        player.openInventory(barbInvenv);
    }

    private static void mageInv(Player player, String characterClass) {
        Inventory mageInv = Bukkit.createInventory(null, 9, ChatColor.BOLD + characterClass + " Skills");

        PersistentDataContainer playerData = player.getPersistentDataContainer();

        if(LevelManager.getLevel(player) >= 3) {
            mageInv.setItem(0, Skill.getSkillItem(new ShieldSkill()));
        }

        if (LevelManager.getLevel(player) >= 5) {
            mageInv.setItem(1, Skill.getSkillItem(new SummonSkill()));
        }


        player.openInventory(mageInv);

    }

    private static void necroInv(Player player, String characterClass) {
        Inventory necroInv = Bukkit.createInventory(null, 9, ChatColor.BOLD + characterClass + " Skills");

        PersistentDataContainer playerData = player.getPersistentDataContainer();

        if(LevelManager.getLevel(player) >= 3) {
            necroInv.setItem(0, Skill.getSkillItem(new BloodSiphon()));
        }

        if (LevelManager.getLevel(player) >= 5) {
            necroInv.setItem(1, Skill.getSkillItem(new DarkSummonerSkill()));
        }


        player.openInventory(necroInv);
    }


    private static void bomberInv(Player player, String characterClass) {
        Inventory bomberInv = Bukkit.createInventory(null, 9, ChatColor.BOLD + characterClass + " Skills");

        if(LevelManager.getLevel(player) >= 4) {
            bomberInv.setItem(0, Skill.getSkillItem(new BombSkill()));
        }

        if(LevelManager.getLevel(player) >= 25) {
            bomberInv.setItem(1, Skill.getSkillItem(new LastResortSkill()));
        }

        player.openInventory(bomberInv);

    }


}
