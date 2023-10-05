package pine.toast.toastart.Classes.Skills.Necromancer;

import org.bukkit.Material;
import pine.toast.toastart.Classes.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class DarkSummonerSkill implements Skill {
    @Override
    public String getName() {
        return "Summoner";
    }

    @Override
    public Material getIcon() {
        return Material.SKELETON_SKULL;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add("Summon 4 zombies to fight for you until death.");
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
