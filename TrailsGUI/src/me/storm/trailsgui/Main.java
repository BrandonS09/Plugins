package me.storm.trailsgui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.storm.trailsgui.commands.Trail;
import me.storm.trailsgui.events.ClickEvent;
import me.storm.trailsgui.events.Movement;
import me.storm.trailsgui.events.Quit;
import me.storm.trailsgui.models.GUI;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		GUI menu = new GUI();
		menu.register();
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new ClickEvent(), this);
		pm.registerEvents(new Quit(), this);
		pm.registerEvents(new Movement(), this);
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] array) {
		if (label.equalsIgnoreCase("Trails")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("Nice Try");
				return true;	
			}
			Player player = (Player) sender;
			GUI menu = new GUI();
			menu.openInventory(player);
			return true;
		}
		return false;
	}
	
}
