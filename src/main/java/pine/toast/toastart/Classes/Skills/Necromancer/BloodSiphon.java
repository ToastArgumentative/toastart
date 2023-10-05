package pine.toast.toastart.Classes.Skills.Necromancer;

import org.bukkit.Material;
import pine.toast.toastart.Classes.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class BloodSiphon implements Skill {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Material getIcon() {
        return null;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add("On attacking you receive a small percentage of the damage dealt as health.");
        description.add("This does increase with level.");
        return description;
    }

    @Override
    public List<String> getStats() {
        List<String> stats = new ArrayList<>();
        stats.add("Resistance: +2 ( 30 seconds )");
        stats.add("Mana Cost: 3");
        return stats;
    }
}
