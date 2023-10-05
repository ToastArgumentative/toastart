package pine.toast.toastart.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import pine.toast.toastart.Classes.CharacterClass;
import pine.toast.toastart.Classes.Skills.CharacterSkills;
import pine.toast.toastart.Classes.Skills.CharacterSkillsInventory;
import pine.toast.toastart.PluginUtilities.Keys;

public class SkillsCMD implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)) commandSender.sendMessage(ChatColor.RED + "Only players can use this command!");

        Player player = (Player) commandSender;
        String playerClass = player.getPersistentDataContainer().get(Keys.characterClass, PersistentDataType.STRING);

        if(playerClass == null) player.sendMessage(ChatColor.RED + "You have not chosen a class yet!");

        player.sendMessage(ChatColor.GREEN + "Opening skills menu...");
        CharacterSkillsInventory.openClassSkillInventory(player, playerClass);

        return true;
    }
}
