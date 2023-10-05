package pine.toast.toastart.LevelSystem;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.persistence.PersistentDataType;
import pine.toast.toastart.DamageManager.DamageManager;
import pine.toast.toastart.DefenseManager.DefenseManager;
import pine.toast.toastart.HealthManager.HealthManager;
import pine.toast.toastart.PluginUtilities.Keys;
import pine.toast.toastart.PluginUtilities.Mana;

public class Experience implements Listener {


    public static void buffs(Player player, int currentLevel, String className) {
        if (currentLevel % 3 == 0) {

            switch (className) {
                case "Barbarian" -> {
                    HealthManager.addMaxHealth(player, 3);
                    DefenseManager.addDefense(player, 2);
                    Mana.setManaPerSec(player, Mana.getManaPerSec(player) + 0.2);
                    Mana.setMaxMana(player, Mana.getMaxMana(player) + 2);
                    DamageManager.addDamage(player, 0.75);
                }
                case "Mage" -> {
                    HealthManager.addMaxHealth(player, 1);
                    DefenseManager.addDefense(player, 1);
                    Mana.setManaPerSec(player, Mana.getManaPerSec(player) + 1.5);
                    Mana.setMaxMana(player, Mana.getMaxMana(player) + 35);
                    DamageManager.addDamage(player, 0.25);
                }
                case "Bomber" -> {
                    HealthManager.addMaxHealth(player, 3);
                    DefenseManager.addDefense(player, 2);
                    Mana.setManaPerSec(player, Mana.getManaPerSec(player) + 0.10);
                    Mana.setMaxMana(player, Mana.getMaxMana(player) + 5);
                    DamageManager.addDamage(player, 0.5);
                }
                case "Necromancer" -> {
                    HealthManager.addMaxHealth(player, 2);
                    DefenseManager.addDefense(player, 1.25);
                    Mana.setManaPerSec(player, Mana.getManaPerSec(player) + 1.5);
                    Mana.setMaxMana(player, Mana.getMaxMana(player) + 25);
                    DamageManager.addDamage(player, 0.25);
                }

                default -> System.out.println("Invalid class name");
            }
        }
    }



    @EventHandler
    public void onExperiencePickUp(PlayerExpChangeEvent event) {

        int amount = event.getAmount() / 2;

        LevelManager.addExperience(event.getPlayer(), amount);

    }

    @EventHandler
    public void onPlayerDie(PlayerDeathEvent event){
        int experience = event.getEntity().getPersistentDataContainer().get(Keys.experience, PersistentDataType.INTEGER);

        LevelManager.setExperience(event.getEntity(), experience / 2);
        event.getEntity().sendMessage("You lost " + experience / 2 + " experience!");
    }

}
