package pine.toast.toastart.Classes.Skills.Barbarian;

import org.bukkit.Material;
import pine.toast.toastart.Classes.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class BeserkerSkill implements Skill {
    @Override
    public String getName() {
        return "Beserker";
    }

    @Override
    public Material getIcon() {
        return Material.IRON_AXE;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add("Go Berserk for 30 seconds. Strength, Resistance, and Speed are increased by 2");
        return description;
    }

    @Override
    public List<String> getStats() {
        List<String> stats = new ArrayList<>();
        stats.add("Strength: +2");
        stats.add("Resistance: +2");
        stats.add("Speed: +2");
        stats.add("Mana Cost: 25");
        return stats;
    }
}
