package com.github.Jwoolley;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DiamondHunter extends JavaPlugin{
	
    private BroadcastHandler bh = new BroadcastHandler();

    public void onEnable()
    {
        initCommands();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new BlockBreakListener(this, bh), this);
        saveDefaultConfig();
    }

    public void initCommands()
    {
        getCommand("dh").setExecutor(new DhCommands(this,bh));
    }
}
