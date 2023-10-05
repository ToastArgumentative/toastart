package pine.toast.toastart.PluginUtilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pine.toast.toastart.LegendsRebornV2;

public class ActionBarManager {

    public static void sendPlayerStatsActionBar(Player player, double health, double maxHealth, double defense, double mana, double maxMana, int level, int maxLevel) {
        // Format the message with placeholders and colors
        String actionBarMessage = ChatColor.GOLD + "Health: " + ChatColor.RED + health + "/" + ChatColor.RED + maxHealth + ChatColor.WHITE + "  |  " +
                ChatColor.GOLD + "Defense: " + ChatColor.AQUA + defense + ChatColor.WHITE + "  |  " +
                ChatColor.GOLD + "Mana: " + ChatColor.BLUE + mana + ChatColor.WHITE + "/" + ChatColor.BLUE + maxMana + ChatColor.WHITE + "  |  " +
                ChatColor.GREEN + "Level: " + ChatColor.YELLOW + level + "/" + ChatColor.GREEN + maxLevel;

        // Send the formatted message as an action bar
        sendActionBar(player, actionBarMessage);
    }

    public static void sendActionBar(Player player, String message) {
        // Create a runnable to send the action bar message to the player
        new BukkitRunnable() {
            @Override
            public void run() {
                player.sendActionBar(message);
            }
        }.runTask(LegendsRebornV2.getPlugin());
    }
}