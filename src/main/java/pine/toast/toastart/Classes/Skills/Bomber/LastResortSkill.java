package pine.toast.toastart.Classes.Skills.Bomber;

import org.bukkit.Material;
import pine.toast.toastart.Classes.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class LastResortSkill implements Skill {
    @Override
    public String getName() {
        return "LastResort";
    }

    @Override
    public Material getIcon() {
        return Material.WITHER_SKELETON_SKULL;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add("On the brink of death, you explode, dealing damage to all entities around you.");
        return description;
    }

    @Override
    public List<String> getStats() {
        List<String> stats = new ArrayList<>();
        stats.add("Blast Radius: 3");
        stats.add("Explosion Damage: 10");
        stats.add("Mana Cost: 30");
        return stats;
    }
}
