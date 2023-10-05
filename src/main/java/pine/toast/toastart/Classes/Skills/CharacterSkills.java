package pine.toast.toastart.Classes.Skills;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import pine.toast.toastart.Classes.CharacterClass;
import pine.toast.toastart.Classes.Items.Abilities.EchoingFury;
import pine.toast.toastart.Classes.Items.Abilities.TheFurnace;
import pine.toast.toastart.Classes.Items.BarbarianItems;
import pine.toast.toastart.Classes.Items.NecromancerItems;
import pine.toast.toastart.LevelSystem.LevelManager;
import pine.toast.toastart.PluginUtilities.Cooldown.CooldownManager;
import pine.toast.toastart.PluginUtilities.InventorySlot;
import pine.toast.toastart.PluginUtilities.Keys;
import pine.toast.toastart.PluginUtilities.Mana;

import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("ALL")
public class CharacterSkills implements Listener {

    CooldownManager cooldownManager = new CooldownManager();
    private static Boolean LevelChecker(int currentLevel, int levelRequirement, int endLevelRequirement){
        return currentLevel >= levelRequirement && currentLevel < endLevelRequirement;
    }

    @EventHandler
    private void onWhirlwindUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        String className = playerData.get(Keys.characterClass, PersistentDataType.STRING);
        Boolean whirlwind = playerData.get(Keys.whirlwind, PersistentDataType.BOOLEAN);
        ItemStack item = player.getInventory().getItemInMainHand();
        UUID userId = player.getUniqueId();

        if (!Boolean.TRUE.equals(whirlwind)) return;
        if (!Objects.equals(className, "Barbarian")) return;
        if (!(item.getType() == Material.IRON_AXE || item.getType() == Material.STONE_AXE)) return;
        if (!(event.getAction() == Action.RIGHT_CLICK_AIR)) return;

        if(cooldownManager.isOnCooldown(userId, "whirlwind")) {
            player.sendMessage(ChatColor.GOLD + "Whirlwind" + ChatColor.RED + " is on cool down! " + cooldownManager.getRemainingCooldownSeconds(userId, "whirlwind"));
            return;
        }

        double manaCost = 20.0;
        double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

        if (currentMana < manaCost) {
            player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!");
        } else {

            Mana.subtractMana(player, manaCost);
            player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Whirlwind!");
            int currentLevel = LevelManager.getLevel(player);

            cooldownManager.putOnCooldown(userId, "whirlwind", 3);

            if(LevelChecker(currentLevel, 5, 12)) {
                double radius = 4.0;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(10.0, player);
                    }
                }
                TheFurnace.whirlwindBuff(player);
            } else if (LevelChecker(currentLevel, 12, 18)) {
                double radius = 5.5;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(11.5, player);
                    }
                }
                TheFurnace.whirlwindBuff(player);
                
            } else if (LevelChecker(currentLevel, 18, 27)){
                double radius = 7.0;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(13.0, player);
                    }
                }
                TheFurnace.whirlwindBuff(player);

            } else if (LevelChecker(currentLevel, 27, 32)) {
                double radius = 8.5;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(14.5, player);
                    }
                }
                TheFurnace.whirlwindBuff(player);

            } else if (currentLevel >= 32) {
                double radius = 10.0;
                for (Entity entity : player.getNearbyEntities(radius, radius, radius)) {
                    // Check if the entity is not the player themselves
                    if (!entity.equals(player) && entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;
                        // Deal 10 damage to the entity
                        target.damage(16.0, player);
                    }
                }
                TheFurnace.whirlwindBuff(player);

            }

        }
    }

    @EventHandler
    private void onEchoingFuryUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        int handModelData = mainHand.getItemMeta().getCustomModelData();

        if(!mainHand.getItemMeta().hasCustomModelData()) return;

        if (!(handModelData == BarbarianItems.getEchoingFuryCommon().getItemMeta().getCustomModelData())) return;
        if (!(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)) return;

        EchoingFury.onHit(player);
    }

    @EventHandler
    private void onBomberDeath(PlayerDeathEvent event){
        Player player = event.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        String className = playerData.get(Keys.characterClass, PersistentDataType.STRING);
        ItemStack item = player.getInventory().getItemInMainHand();
        Boolean lastResort = playerData.get(Keys.lastResort, PersistentDataType.BOOLEAN);
        UUID userId = player.getUniqueId();

        if (!CharacterClass.isBomber(player)) return;
        if (!Boolean.TRUE.equals(lastResort)) return;

        if (cooldownManager.isOnCooldown(userId, "lastResort")) {
            player.sendMessage(ChatColor.GOLD + "Whirlwind" + ChatColor.RED + " is on cool down! " + cooldownManager.getRemainingCooldownSeconds(userId, "lastResort"));
            return;
        }

        Location blastLocation = player.getLocation();
        int currentLevel = LevelManager.getLevel(player);

        cooldownManager.putOnCooldown(userId, "lastResort", 60);
        player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Last Resort!");

        if(LevelChecker(currentLevel, 8, 15)){
            double manaCost = 30.0;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);
            // Create a small explosion where the player died
            player.getWorld().createExplosion(blastLocation, 1.0f, false, false, player);
            event.setCancelled(true);
            // Set the player's current health to 5% of the overall max health
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() % 5);

        } else if (LevelChecker(currentLevel, 15, 27)){
            double manaCost = 27.75;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);
            // Create a small explosion where the player died
            player.getWorld().createExplosion(blastLocation, 2.25f, false, false, player);
            event.setCancelled(true);
            // Set the player's current health to 12% of the overall max health
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() % 12);
        } else if (LevelChecker(currentLevel, 27, 32)){
            double manaCost = 23.25;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);
            // Create a small explosion where the player died
            player.getWorld().createExplosion(blastLocation, 3.75f, false, false, player);
            event.setCancelled(true);
            // Set the player's current health to 5% of the overall max health
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() % 22);
        } else if (currentLevel >= 32){
            double manaCost = 20.50;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);
            // Create a small explosion where the player died
            player.getWorld().createExplosion(blastLocation, 5.5f, false, false, player);
            event.setCancelled(true);
            // Set the player's current health to 5% of the overall max health
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() % 33);
        }



        player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Last Resort!");
        player.sendMessage(ChatColor.GREEN + "You have been revived with " + ChatColor.GOLD + player.getHealth() + ChatColor.GREEN + " health!");

        event.setCancelled(true);

    }


    @EventHandler
    private void onBerserkerClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        String className = playerData.get(Keys.characterClass, PersistentDataType.STRING);
        Boolean berserker = playerData.get(Keys.berserker, PersistentDataType.BOOLEAN);
        ItemStack item = player.getInventory().getItemInMainHand();
        UUID userId = player.getUniqueId();

        if (!Boolean.TRUE.equals(berserker)) return;
        if (!Objects.equals(className, "Barbarian")) return;
        if (!(item.getType() == Material.AIR)) return;
        if (!(event.getAction() == Action.LEFT_CLICK_AIR)) return;

        if (cooldownManager.isOnCooldown(userId, "berserker")) {
            player.sendMessage(ChatColor.GOLD + "Berserker" + ChatColor.RED + " is on cool down! " + cooldownManager.getRemainingCooldownSeconds(userId, "berserker"));
            return;
        }

        int currentLevel = LevelManager.getLevel(player);
        cooldownManager.putOnCooldown(userId, "berserker", 45);


        if(LevelChecker(currentLevel, 11, 21)) {
            double manaCost = 25.0;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);
            player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Berserker!");

            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30*20, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30*20, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 30*20, 1));

        } else if (LevelChecker(currentLevel, 21, 27)) {
            double manaCost = 24.75;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);
            player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Berserker!");

            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 32*20, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 32*20, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 32*20, 1));

        } else if (LevelChecker(currentLevel, 27, 32)) {
            double manaCost = 23.25;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);
            player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Berserker!");

            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 35*20, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 35*20, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 35*20, 1));

        } else if (currentLevel >= 32){
            double manaCost = 21.75;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);
            player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Berserker!");

            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40*20, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40*20, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40*20, 2));
        }


    }

    @EventHandler
    private void onMageShieldUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        String className = playerData.get(Keys.characterClass, PersistentDataType.STRING);
        Boolean shield = playerData.get(Keys.shield, PersistentDataType.BOOLEAN);
        ItemStack item = player.getInventory().getItemInMainHand();
        UUID userId = player.getUniqueId();

        if (!Boolean.TRUE.equals(shield)) return;
        if (!Objects.equals(className, "Mage")) return;
        if (!(item.getType() == Material.BOOK)) return;
        if (!(event.getAction() == Action.RIGHT_CLICK_AIR)) return;

        if(cooldownManager.isOnCooldown(userId, "shield")) {
            player.sendMessage(ChatColor.GOLD + "Shield" + ChatColor.RED + " is on cool down! " + cooldownManager.getRemainingCooldownSeconds(userId, "shield"));
            return;
        }

        int currentLevel = LevelManager.getLevel(player);

        cooldownManager.putOnCooldown(userId, "shield", 40);
        player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Shield!");

        if(LevelChecker(currentLevel, 5, 8)){
            double manaCost = 25.0;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);

            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 7*20, 2));
        } else if (LevelChecker(currentLevel, 8, 13)){
            double manaCost = 24.75;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);

            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 9*20, 2));
        } else if (LevelChecker(currentLevel, 13, 18)){
            double manaCost = 24.25;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);

            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 14*20, 3));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 14*20, 1));
        } else if (LevelChecker(currentLevel, 18, 27)){
            double manaCost = 24.0;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);

            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 14*20, 3));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 14*20, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 14*20, 1));
        } else if (LevelChecker(currentLevel, 27, 32)){
            double manaCost = 23.0;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);

            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 21*20, 3));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 21*20, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 21*20, 2));
        } else if (currentLevel >= 32) {
            double manaCost = 22.50;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if(currentMana < manaCost) return;

            Mana.subtractMana(player, manaCost);

            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 30*20, 5));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 30*20, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30*20, 2));

        }



    }

    @EventHandler
    private void onMageSummonUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        String className = playerData.get(Keys.characterClass, PersistentDataType.STRING);
        Boolean summoner = playerData.get(Keys.summoner, PersistentDataType.BOOLEAN);
        ItemStack item = player.getInventory().getItemInMainHand();
        UUID userId = player.getUniqueId();

        if (!Boolean.TRUE.equals(summoner)) return;
        if (!Objects.equals(className, "Mage")) return;
        if (!(item.getType() == Material.BLAZE_POWDER)) return;
        if (!(event.getAction() == Action.LEFT_CLICK_AIR)) return;

        if (cooldownManager.isOnCooldown(userId, "summoner")) {
            player.sendMessage(ChatColor.GOLD + "Summoner" + ChatColor.RED + " is on cool down! " + cooldownManager.getRemainingCooldownSeconds(userId, "summoner"));
            return;
        }

        int currentLevel = LevelManager.getLevel(player);
        Location playerLocation = player.getLocation();

        cooldownManager.putOnCooldown(userId, "summoner", 60);
        player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Summoner!");



    }

    @EventHandler
    private void onNecroSummonUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        String className = playerData.get(Keys.characterClass, PersistentDataType.STRING);
        Boolean summoner = playerData.get(Keys.summoner, PersistentDataType.BOOLEAN);
        ItemStack item = player.getInventory().getItemInMainHand();
        UUID userId = player.getUniqueId();

        if (!Boolean.TRUE.equals(summoner)) return;
        if (!Objects.equals(className, "Necromancer")) return;
        if (!(item.getType() == Material.BLAZE_POWDER)) return;
        if (!(event.getAction() == Action.LEFT_CLICK_AIR)) return;

        if (cooldownManager.isOnCooldown(userId, "darkSummoner")) {
            player.sendMessage(ChatColor.GOLD + "Summoner" + ChatColor.RED + " is on cool down! " + cooldownManager.getRemainingCooldownSeconds(userId, "summoner"));
            return;
        }

        int currentLevel = LevelManager.getLevel(player);
        Location playerLocation = player.getLocation();

        cooldownManager.putOnCooldown(userId, "darkSummoner", 2);
        player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Summoner!");

        // Summons the zombies with attributes based off the level of the player
        necroLevel(currentLevel, player, playerLocation);

        Inventory playerInv = player.getInventory();

        // Check if the player has a helmet
        ItemStack boots = playerInv.getItem(InventorySlot.BOOTS.getSlotId());
        int bootsModelData = boots.getItemMeta().getCustomModelData();

        // Checking if the player is wearing boneBoots, if they are skeletons will spawn with zombies.
        if (bootsModelData == NecromancerItems.getBoneShoesEpic().getItemMeta().getCustomModelData()) {
            necroWskelly(currentLevel, player, playerLocation);
        }

    }


    private static void necroLevel(int currentLevel, Player player, Location playerLocation){
        if(LevelChecker(currentLevel, 5, 12)) {
            double manaCost = 40.0;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 4; i++) {
                Zombie zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Zombie.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setArmsRaised(true);
                zombie.setBaby(false);
                zombie.setVisualFire(true);

            }
        } else if (LevelChecker(currentLevel, 12, 18)) {
            double manaCost = 39.25;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 4; i++) {
                Zombie zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Zombie.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setArmsRaised(true);
                zombie.setBaby(false);
                zombie.setVisualFire(true);
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30 * 20, 1, false, false));

            }
        } else if(LevelChecker(currentLevel, 18, 27)) {
            double manaCost = 38.25;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 6; i++) {
                Zombie zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Zombie.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setArmsRaised(true);
                zombie.setBaby(false);
                zombie.setVisualFire(true);
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30 * 20, 1, false, false));
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30 * 20, 1, false, false));

            }
        } else if(LevelChecker(currentLevel, 27, 32)) {
            double manaCost = 38.25;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 8; i++) {
                Zombie zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Zombie.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setArmsRaised(true);
                zombie.setBaby(false);
                zombie.setVisualFire(true);
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30 * 20, 1, false, false));
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30 * 20, 1, false, false));
                zombie.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_SWORD));

            }
        } else if (currentLevel >= 32){
            double manaCost = 35.0;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 12; i++) {
                Zombie zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Zombie.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setArmsRaised(true);
                zombie.setBaby(false);
                zombie.setVisualFire(true);
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30 * 20, 2, false, false));
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30 * 20, 2, false, false));
                zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30 * 20, 2, false, false));

            }
        }
    }
    private static void necroWskelly(int currentLevel, Player player, Location playerLocation) {

        if(LevelChecker(currentLevel, 5, 12)) {
            double manaCost = 40.0;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 4; i++) {
                Skeleton zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Skeleton.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setVisualFire(true);

            }
        } else if (LevelChecker(currentLevel, 12, 18)) {
            double manaCost = 39.25;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 4; i++) {
                Zombie zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Zombie.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setArmsRaised(true);
                zombie.setBaby(false);
                zombie.setVisualFire(true);
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30 * 20, 1, false, false));

            }
        } else if(LevelChecker(currentLevel, 18, 27)) {
            double manaCost = 38.25;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 6; i++) {
                Skeleton zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Skeleton.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setVisualFire(true);
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30 * 20, 1, false, false));
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30 * 20, 1, false, false));


            }
        } else if(LevelChecker(currentLevel, 27, 32)) {
            double manaCost = 38.25;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 8; i++) {
                Skeleton zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Skeleton.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setVisualFire(true);
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30 * 20, 1, false, false));
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30 * 20, 1, false, false));

                // Create a bow with power 2
                ItemStack bow = new ItemStack(Material.BOW);
                bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
                zombie.getEquipment().setItemInMainHand(bow);


            }
        } else if (currentLevel >= 32){
            double manaCost = 35.0;
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

            if (currentMana < manaCost) { player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!"); return; }

            Mana.subtractMana(player, manaCost);
            for (int i = 0; i < 12; i++) {
                Skeleton zombie = player.getWorld().spawn(playerLocation.add(0, 1, 0), Skeleton.class);
                zombie.setCustomName(player.getName());
                zombie.setCustomNameVisible(false);
                zombie.setVisualFire(true);
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30 * 20, 2, false, false));
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30 * 20, 2, false, false));
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30 * 20, 2, false, false));

                // Create a bow with power 3
                ItemStack bow = new ItemStack(Material.BOW);
                bow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
                bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
                zombie.getEquipment().setItemInMainHand(bow);
            }
        }
    }




    @EventHandler
    private void onZombieTargetLivingEntity(EntityTargetLivingEntityEvent event){
        if(!(event.getEntity() instanceof Zombie)) return;
        Zombie zombie = (Zombie) event.getEntity();
        if(zombie.getCustomName() == null) return;

        // If a zombie has the same name as the target, then cancel the event
        if(zombie.getCustomName().equals(event.getTarget().getName())){
            event.setCancelled(true);
        } else return;
    }

    @EventHandler
    private void onTntBombUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        String className = playerData.get(Keys.characterClass, PersistentDataType.STRING);
        Boolean bomb = playerData.get(Keys.bomb, PersistentDataType.BOOLEAN);
        ItemStack item = player.getInventory().getItemInMainHand();
        UUID userId = player.getUniqueId();

        if (!Boolean.TRUE.equals(bomb)) return;
        if (!Objects.equals(className, "Bomber")) return;
        if (!(item.getType() == Material.TNT)) return;
        if (!(event.getAction() == Action.LEFT_CLICK_AIR)) return;

        if (cooldownManager.isOnCooldown(userId, "bomb")) {
            player.sendMessage(ChatColor.GOLD + "Bomb" + ChatColor.RED + " is on cool down! " + cooldownManager.getRemainingCooldownSeconds(userId, "bomb") + " seconds remaining");
            return;
        }

        double manaCost = 10.0;
        double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);

        if (currentMana < manaCost) {
            player.sendMessage(ChatColor.RED + "You do not have enough mana to use this skill!");
        } else {
            Mana.subtractMana(player, manaCost);
            player.sendMessage(ChatColor.GREEN + "You have used " + ChatColor.GOLD + "Bomb!");
            cooldownManager.putOnCooldown(userId, "bomb", 1);

            // Shoot a piece of tnt in the direction the player is looking
            Location playerLocation = player.getLocation();
            Vector direction = playerLocation.getDirection();

            // Create a TNT entity
            TNTPrimed tnt = player.getWorld().spawn(playerLocation.add(0, 1, 0), TNTPrimed.class);

            // Set the TNT's velocity based on the player's direction
            tnt.setVelocity(direction.multiply(2));

            int level = LevelManager.getLevel(player);

            if(LevelChecker(level, 5, 12)) {
                tnt.setFuseTicks(40);
            } else if (LevelChecker(level, 12, 18)) {
                tnt.setFuseTicks(35);
            } else if (LevelChecker(level, 18, 27)) {
                tnt.setFuseTicks(30);
            } else if (LevelChecker(level, 27, 32)) {
                tnt.setFuseTicks(25);
            } else if (level >= 32) {
                tnt.setFuseTicks(20);
            }
        }
    }


}
