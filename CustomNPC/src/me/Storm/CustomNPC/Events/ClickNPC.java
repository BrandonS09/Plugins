package me.Storm.CustomNPC.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ClickNPC implements Listener{
	@EventHandler
	public void onClick(RightClickNPC event) {
		Player player = (Player )event.getPlayer();
		player.sendMessage("HI!");
		}
	
}
