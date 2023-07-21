package me.storm.joinquitmessage;

import org.bukkit.plugin.java.JavaPlugin;

public final class JoinQuitMessage extends JavaPlugin{

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
