package me.storm.trailsgui.events;

import java.util.Random;

import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.storm.trailsgui.models.ParticleData;

public class Movement implements Listener{
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if (!ParticleData.hasFakeId(event.getPlayer().getUniqueId()))
			return;
		
		Random r = new Random();
		for(int i = 0; i<5; i++)
			event.getPlayer().getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, event.getPlayer().getLocation().add(-1*(r.nextDouble()*0.5),r.nextDouble() * 0.5, (r.nextDouble() * 0.5)*-1),0);
	}
}
