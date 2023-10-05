package pine.toast.toastart;

import org.bukkit.plugin.java.JavaPlugin;
import pine.toast.toastart.Classes.Skills.CharacterSkills;
import pine.toast.toastart.Classes.Skills.CharacterSkillsInventory;
import pine.toast.toastart.Commands.AddLevelCMD;
import pine.toast.toastart.Commands.Items.GiveTheEchoingFury;
import pine.toast.toastart.Commands.Items.GiveTheFurnace;
import pine.toast.toastart.Commands.SkillsCMD;
import pine.toast.toastart.LevelSystem.Experience;
import pine.toast.toastart.PluginUtilities.Mana;
import pine.toast.toastart.RPG_WORLD.Restrictions;
import pine.toast.toastart.RebornMobs.*;
import pine.toast.toastart.SelectionMenus.SelectClass;
import pine.toast.toastart.init.PlayerJoin;

public final class LegendsRebornV2 extends JavaPlugin {

    private static LegendsRebornV2 plugin;


    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        getCommand("skills").setExecutor(new SkillsCMD());
        getCommand("addLevel").setExecutor(new AddLevelCMD());
        getCommand("giveTheFurnace").setExecutor(new GiveTheFurnace());
        getCommand("giveTheFury").setExecutor(new GiveTheEchoingFury());

        getServer().getPluginManager().registerEvents(new SelectClass(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new Restrictions(), this);
        getServer().getPluginManager().registerEvents(new Mana(), this);
        getServer().getPluginManager().registerEvents(new CharacterSkillsInventory(), this);
        getServer().getPluginManager().registerEvents(new CharacterSkills(), this);
        getServer().getPluginManager().registerEvents(new Experience(), this);

        getServer().getPluginManager().registerEvents(new Enderdragon(), this);
        getServer().getPluginManager().registerEvents(new Jackal(), this);
        getServer().getPluginManager().registerEvents(new Magma(), this);
        getServer().getPluginManager().registerEvents(new Tesla(), this);

        Mana.startManaRegen();



    }

    public static LegendsRebornV2 getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
