package fr.death.saofrance;

import fr.death.saofrance.command.SpawnCMD;
import fr.death.saofrance.listener.PlayerGUIListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public void onEnable() {
        instance = this;
        getCommand("spawn").setExecutor(new SpawnCMD());
        PluginManager pluginmanager = Bukkit.getPluginManager();
        pluginmanager.registerEvents(new PlayerGUIListener(), this);
        saveDefaultConfig();
        super.onEnable();
    }

    public void onDisable() {
        Bukkit.broadcastMessage("[SAO Spawn Menu] OFF");
        super.onDisable();
    }

    public static Main getInstance() {
        return instance;
    }
}
