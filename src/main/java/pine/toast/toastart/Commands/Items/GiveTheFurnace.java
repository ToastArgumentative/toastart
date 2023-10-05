package pine.toast.toastart.Commands.Items;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pine.toast.toastart.Classes.Items.BarbarianItems;
import pine.toast.toastart.PluginUtilities.Rarity;

public class GiveTheFurnace implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 2) {
            sender.sendMessage("Usage: /giveTheFurnace [playerName] <rarity>");
            return true;
        }

        // Capitalize the rarity argument
        String rarityArg = args[1].toUpperCase(); // Convert to uppercase

        Rarity rarity;
        try {
            rarity = Rarity.valueOf(rarityArg); // Parse as an enum
        } catch (IllegalArgumentException e) {
            sender.sendMessage("Invalid rarity specified.");
            return true;
        }

        // Debug message to check if the command is being executed
        sender.sendMessage("Command executed.");
        // Debug message to check the parsed rarity
        sender.sendMessage("Parsed rarity: " + rarity);

        if (args.length == 2) {
            // Handle giving the item to the command sender
            try {
                switch (rarity) {
                    case COMMON:
                        player.getInventory().addItem(BarbarianItems.getTheFurnaceCommon());
                        break;
                    case UNCOMMON:
                        player.getInventory().addItem(BarbarianItems.getTheFurnaceUncommon());
                        break;
                    case RARE:
                        player.getInventory().addItem(BarbarianItems.getTheFurnaceRare());
                        break;
                    case EPIC:
                        player.getInventory().addItem(BarbarianItems.getTheFurnaceEpic());
                        break;
                    case LEGENDARY:
                        player.getInventory().addItem(BarbarianItems.getTheFurnaceLegendary());
                        break;
                }
            } catch (Exception e) {
                // Handle any exceptions that may occur when giving the item to the player
                sender.sendMessage("An error occurred while giving the item to you.");
                e.printStackTrace();
            }
        } else if (args.length == 3) {
            try {
                Player targetPlayer = player.getServer().getPlayer(args[2]);
                if (targetPlayer != null) {
                    // Handle giving the item to the specified player
                    switch (rarity) {
                        case COMMON:
                            targetPlayer.getInventory().addItem(BarbarianItems.getTheFurnaceCommon());
                            break;
                        case UNCOMMON:
                            targetPlayer.getInventory().addItem(BarbarianItems.getTheFurnaceUncommon());
                            break;
                        case RARE:
                            targetPlayer.getInventory().addItem(BarbarianItems.getTheFurnaceRare());
                            break;
                        case EPIC:
                            targetPlayer.getInventory().addItem(BarbarianItems.getTheFurnaceEpic());
                            break;
                        case LEGENDARY:
                            targetPlayer.getInventory().addItem(BarbarianItems.getTheFurnaceLegendary());
                            break;
                    }
                } else {
                    // Handle the case where the specified player is not online or doesn't exist
                    sender.sendMessage("Player " + args[2] + " not found or offline.");
                }
            } catch (Exception e) {
                // Handle any exceptions that may occur when accessing the player's inventory
                sender.sendMessage("An error occurred while giving the item to the player.");
                e.printStackTrace();
            }
        }

        return true;
    }
}

