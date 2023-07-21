package me.storm.trailsgui.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import me.storm.trailsgui.models.Effects;
import me.storm.trailsgui.models.GUI;
import me.storm.trailsgui.models.ParticleData;

public class ClickEvent implements Listener{
	private GUI menu;
	public ClickEvent() {
		menu = new GUI();
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (!event.getClickedInventory().equals(menu.getInventory()))
			return;
		
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getView().getType() == InventoryType.PLAYER)
			return;
		
		ParticleData particle = new ParticleData(player.getUniqueId());
		
		if(particle.hasID()) {
			particle.endTask();
			particle.removeID();
		}
		
		Effects trails = new Effects(player);
		
		switch(event.getSlot()) {
		case 1:
			trails.startFireWork();
			player.closeInventory();
			player.updateInventory();
			break;
		case 2:
			trails.startTNT();
			player.closeInventory();
			player.updateInventory();
			break;
		case 3:
			trails.startTotem();
			player.closeInventory();
			player.updateInventory();
			break;
		case 4:
			trails.startFire();
			player.closeInventory();
			player.updateInventory();
			break;
		case 5:
			particle.setID(1);
			player.closeInventory();
			player.updateInventory();
			break;
		case 6:
			trails.startDragon();
			player.closeInventory();
			player.updateInventory();
			break;
		case 7:
			trails.startCrit();
			player.closeInventory();
			player.updateInventory();
			break;
		default:
			break;
		}
	}
}
