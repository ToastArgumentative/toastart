package pine.toast.toastart.init;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import pine.toast.toastart.LegendsRebornV2;
import pine.toast.toastart.LevelSystem.LevelManager;
import pine.toast.toastart.PluginUtilities.ActionBarManager;
import pine.toast.toastart.PluginUtilities.Keys;
import pine.toast.toastart.PluginUtilities.Mana;
import pine.toast.toastart.SelectionMenus.SelectClass;
import xyz.xenondevs.nova.api.Nova;
import xyz.xenondevs.nova.api.player.WailaManager;

public class PlayerJoin implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer playerData = player.getPersistentDataContainer();
        Nova nova = Nova.getNova();
        WailaManager wailiaManager = nova.getWailaManager();



        /* !!! REMEMBER TO INVERT THIS ON FINAL PRODUCTION !!! */
        if (player.hasPlayedBefore()) {
            playerData.set(Keys.whirlwind, PersistentDataType.BOOLEAN, false);
            playerData.set(Keys.shield, PersistentDataType.BOOLEAN, false);
            playerData.set(Keys.experience, PersistentDataType.INTEGER, 10);
            playerData.set(Keys.level, PersistentDataType.INTEGER, 1);
            playerData.set(Keys.bomb, PersistentDataType.BOOLEAN, false);
            playerData.set(Keys.lastResort, PersistentDataType.BOOLEAN, false);
            playerData.set(Keys.berserker, PersistentDataType.BOOLEAN, false);
            playerData.set(Keys.summoner, PersistentDataType.BOOLEAN, false);
            wailiaManager.setState(player, true);
            SelectClass.openClassSelectGUI(player);
            LevelManager.setLevel(player, 1);
        }

        // Create a BukkitRunnable to continuously update the action bar
        new BukkitRunnable() {
            @Override
            public void run() {
                // Update the action bar with player's current stats
                double health = player.getHealth();
                health = Math.round(health * 10.0) / 10.0;
                double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                double armor = player.getAttribute(Attribute.GENERIC_ARMOR).getValue();

                double mana = Mana.mana.getOrDefault(player.getUniqueId(), 0.0);
                double roundedMana = Math.round(mana * 10.0) / 10.0;

                double maxMana = Mana.getMaxMana(player);
                int level = LevelManager.getLevel(player);
                int maxLevel = LevelManager.getMaxLevel(player);

                ActionBarManager.sendPlayerStatsActionBar(player,health, maxHealth, armor, roundedMana, maxMana, level, maxLevel);
            }
        }.runTaskTimer(LegendsRebornV2.getPlugin(), 0L, 20L); // Repeats every second (20 ticks)
    }
}
