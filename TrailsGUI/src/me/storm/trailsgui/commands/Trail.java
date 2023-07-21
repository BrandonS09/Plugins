package me.storm.trailsgui.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.storm.trailsgui.models.GUI;

public class Trail implements CommandExecutor{

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
