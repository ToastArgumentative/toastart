package pine.toast.toastart.Classes.Skills.Mage;

import org.bukkit.Material;
import pine.toast.toastart.Classes.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class ShieldSkill implements Skill {
    @Override
    public String getName() {
        return "Shield";
    }

    @Override
    public Material getIcon() {
        return Material.GOLDEN_APPLE;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add("Grant your self level 4 absorption armor for 15 seconds.");
        description.add("Absorption power is varied by your level.");
        return description;
    }

    @Override
    public List<String> getStats() {
        List<String> stats = new ArrayList<>();
        stats.add("Absorption: 4");
        stats.add("Mana Cost: 25");
        return stats;
    }
}
