package pine.toast.toastart.PluginUtilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import pine.toast.toastart.LegendsRebornV2;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Mana implements Listener{
    public static Map<UUID, Double> mana = new HashMap<>();

    public static void startManaRegen(){
        new ManaRegen().runTaskTimer(LegendsRebornV2.getPlugin(), 0, 20);
    }
    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event){
        UUID uuid = event.getPlayer().getUniqueId();
        mana.put(uuid, 0.0);
    }

    public static double getMaxMana(Player player) {
        PersistentDataContainer playerData = player.getPersistentDataContainer();

        if(!(playerData.has(Keys.maxMana, PersistentDataType.DOUBLE)))
            Bukkit.getLogger().warning("You have not registered values!");

        return playerData.get(Keys.maxMana, PersistentDataType.DOUBLE);

    }

    public static double getManaPerSec(Player player) {
        PersistentDataContainer playerData = player.getPersistentDataContainer();

        if(!(playerData.has(Keys.manaPerSec, PersistentDataType.DOUBLE)))
            Bukkit.getLogger().warning("You have not registered values!");

        return playerData.get(Keys.manaPerSec, PersistentDataType.DOUBLE);
    }

    // Create a function that will subtract mana from the player in the hashmap
    public static void subtractMana(Player player, double manaToSubtract) {
        // Get the player's current mana
        double currentMana = mana.getOrDefault(player.getUniqueId(), 0.0);

        // Subtract manaToSubtract from the player's current mana
        currentMana -= manaToSubtract;

        // Ensure that the current mana doesn't go below 0
        if (currentMana < 0) {
            currentMana = 0;
        }

        // Update the player's mana in the mana map
        mana.put(player.getUniqueId(), currentMana);
    }


    // Create a set Max mana function
    public static void setMaxMana(Player player, double maxMana) {
        PersistentDataContainer playerData = player.getPersistentDataContainer();

        playerData.set(Keys.maxMana, PersistentDataType.DOUBLE, maxMana);
    }

    // Create a setmana per sec function
    public static void setManaPerSec(Player player, double manaPerSec) {
        PersistentDataContainer playerData = player.getPersistentDataContainer();

        playerData.set(Keys.manaPerSec, PersistentDataType.DOUBLE, manaPerSec);
    }





}

class ManaRegen extends BukkitRunnable {
    @Override
    public void run() {
        // Loop through all online players and update their mana
        for (Player player : Bukkit.getOnlinePlayers()) {
            double currentMana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);
            double manaPerSec = Mana.getManaPerSec(player);

            // Add manaPerSec to the player's current mana
            currentMana += manaPerSec;

            // Ensure that the current mana doesn't exceed the maximum mana
            double maxMana = Mana.getMaxMana(player);
            if (currentMana > maxMana) {
                currentMana = maxMana;
            }

            // Update the player's mana in the mana map
            Mana.mana.put(player.getUniqueId(), currentMana);
        }
    }

}