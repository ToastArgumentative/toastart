package pine.toast.toastart.SelectionMenus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pine.toast.toastart.Classes.*;

public class SelectClass implements Listener {

    private static CharacterClass Barbarian = new BarbarianClass();
    private static CharacterClass Mage = new MageClass();
    private static CharacterClass Bomber = new BomberClass();
    private static CharacterClass Necromancer = new NecromancerClass();

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getHolder() == null && event.getView().getTitle().equals("Class Selection")) {
            // Prevent players from moving items around in this inventory
            event.setCancelled(true);
            HumanEntity player = event.getWhoClicked();
            // if item slot 0 is clicked
            if (event.getSlot() == 0) {
                CharacterClass.enforceClass((Player) player, Barbarian);
                player.sendMessage(ChatColor.GREEN + "You have selected the Barbarian class!");
            } else if (event.getSlot() == 1) {
                CharacterClass.enforceClass((Player) player, Mage);
                player.sendMessage(ChatColor.GREEN + "You have selected the Mage class!");
            } else if (event.getSlot() == 2) {
                CharacterClass.enforceClass((Player) player, Bomber);
                player.sendMessage(ChatColor.GREEN + "You have selected the Bomber class!");
            } else if (event.getSlot() == 3) {
                CharacterClass.enforceClass((Player) player, Necromancer);
                player.sendMessage(ChatColor.GREEN + "You have selected the Necromancer class!");
            }

        }
    }


    public static void openClassSelectGUI(Player player) {
        // Create the inventory with one row (9 slots)
        Inventory inventory = Bukkit.createInventory(null, 9, "Class Selection");

        // Add items to the inventory
        // For example, you can add a placeholder item to each slot
        inventory.setItem(0, CharacterClass.getClassItem(Barbarian));
        inventory.setItem(1, CharacterClass.getClassItem(Mage));
        inventory.setItem(2, CharacterClass.getClassItem(Bomber));
        inventory.setItem(3, CharacterClass.getClassItem(Necromancer));

        // Open the inventory for the player
        player.openInventory(inventory);
    }



}
