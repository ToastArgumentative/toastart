package pine.toast.toastart.Classes.Skills.Bomber;

import org.bukkit.Material;
import pine.toast.toastart.Classes.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class BombSkill implements Skill {
    @Override
    public String getName() {
        return "Bomb";
    }

    @Override
    public Material getIcon() {
        return Material.TNT;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add("Throw a bomb out in front of you.");
        description.add("3 Second Fuse");
        return description;
    }

    @Override
    public List<String> getStats() {
        List<String> stats = new ArrayList<>();
        stats.add("Blast Radius: 3");
        stats.add("Mana Cost: 10");
        return stats;
    }
}
