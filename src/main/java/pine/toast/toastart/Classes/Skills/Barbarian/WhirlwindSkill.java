package pine.toast.toastart.Classes.Skills.Barbarian;

import org.bukkit.Material;
import pine.toast.toastart.Classes.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class WhirlwindSkill implements Skill {
    @Override
    public String getName() {
        return "Whirlwind";
    }

    @Override
    public Material getIcon() {
        return Material.DIAMOND_AXE; // Example icon
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add("Deal damage to entities within a 4 block circular radius around you.");
        description.add("Damage and Range are varied by your level.");
        return description;
    }

    @Override
    public List<String> getStats() {
        List<String> stats = new ArrayList<>();
        stats.add("Damage Bonus: +10");
        stats.add("Mana Cost: 20");
        return stats;
    }
}

// Create similar classes for MageSkill and KnightSkill

