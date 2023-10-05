package pine.toast.toastart.DamageManager;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class DamageManager {


  public static void setDamage(Player player, double amount) {
    // Set the damage attribute of the player to the amount specified

    player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(amount);

  }

  public static void addDamage(Player player, double amount) {
    // Add the amount specified to the damage attribute of the player

    player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue() + amount);

  }

  public static void removeDamage(Player player, double amount) {
    // Remove the amount specified from the damage attribute of the player

    player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue() - amount);

  }

  public static void getDamage(Player player) {
    // Get the damage attribute of the player

    player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue();

  }


}
