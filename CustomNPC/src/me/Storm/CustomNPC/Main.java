package me.Storm.CustomNPC;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.Storm.CustomNPC.Events.ClickNPC;
import me.Storm.CustomNPC.Events.Join;

public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Join(), this);
		this.getServer().getPluginManager().registerEvents(new ClickNPC(), this);
		
		if(!Bukkit.getOnlinePlayers().isEmpty()) {
			for(Player player :Bukkit.getOnlinePlayers()) {
				PacketReader reader = new PacketReader();
				reader.inject(player);
			}
		}
	}
	@Override
	public void onDisable() {
		for(Player player :Bukkit.getOnlinePlayers()) {
			PacketReader reader = new PacketReader();
			reader.uninject(player);
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("createnpc")) {
			if (!(sender instanceof Player)) {
				return true;
			}
			Player player = (Player) sender;
			if (args.length ==0) {
				NPC.createNPC(player, player.getName());
				return true;
			}
			NPC.createNPC(player, args[0]);
		}
		return false;
	}
}
