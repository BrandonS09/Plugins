package me.Storm.CustomNPC.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.Storm.CustomNPC.NPC;
import me.Storm.CustomNPC.PacketReader;

public class Join implements Listener{
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		PacketReader reader = new PacketReader();
		reader.inject(event.getPlayer());
		if(NPC.getNPCs() == null)
			return;
		if(NPC.getNPCs().isEmpty())
			return;
		NPC.addJoinPacket(event.getPlayer());

	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		PacketReader reader = new PacketReader();
		reader.uninject(event.getPlayer());
	}
}
