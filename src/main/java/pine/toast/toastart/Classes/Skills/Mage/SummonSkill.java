package pine.toast.toastart.Classes.Skills.Mage;

import org.bukkit.Material;
import pine.toast.toastart.Classes.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class SummonSkill implements Skill {
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
        description.add("Summon friendly holy creatures to help battle with you.");
        description.add("Your summons will not attack you.");
        return description;
    }

    @Override
    public List<String> getStats() {
        List<String> stats = new ArrayList<>();
        stats.add("Resistance: +2 ( 30 seconds )");
        stats.add("Mana Cost: 40");
        return stats;
    }
}
