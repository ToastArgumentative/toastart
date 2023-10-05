package pine.toast.toastart.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;
import pine.toast.toastart.LevelSystem.LevelManager;

public class AddLevelCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) sender.sendMessage("Only players can use this command!");
        if(!(sender.isOp())) sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");

        Player player = (Player) sender;
        PersistentDataContainer playerData = player.getPersistentDataContainer();

        // Create a for loop using the number from the first argument
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            LevelManager.addExperience(player, 105);
        }
        player.sendMessage(ChatColor.GREEN + "Added " + ChatColor.GOLD + args[0] + ChatColor.GREEN + " levels!");
        return true;
    }
}
