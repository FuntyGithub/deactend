package org.funty.deactend;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.funty.deactend.command.endCommand;
import org.funty.deactend.listener.endListener;

public final class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        loadConfig();
        //commands
        getCommand("end").setExecutor(new endCommand());
        getCommand("end").setTabCompleter(new TabComplete());
        //listener
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new endListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void loadConfig(){
        saveDefaultConfig();
    }
    public static Main getPlugin(){
        return plugin;
    }
}
