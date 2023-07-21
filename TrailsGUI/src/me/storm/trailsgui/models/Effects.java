package me.storm.trailsgui.models;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import me.storm.trailsgui.Main;

public class Effects {
	private int taskID;
	private final Player player;
	
	public Effects(Player player) {
		this.player = player;
	}
	
	public void startTotem() {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable(){

			double var = 0;
			Location loc, first, second;
			ParticleData particle = new ParticleData(player.getUniqueId());
			
			@Override
			public void run() {
				if(!particle.hasID()) {
					particle.setID(taskID);
				}
				
				var += Math.PI/16;
				
				loc = player.getLocation();
				first = loc.clone().add(Math.cos(var),Math.sin(var) + 1, Math.sin(var));
				second = loc.clone().add(Math.cos(var+ Math.PI), Math.sin(var) + 1, Math.sin(var + Math.PI));
				
				player.getWorld().spawnParticle(Particle.TOTEM, first, 0);
				player.getWorld().spawnParticle(Particle.TOTEM, second, 0);
			}
			
		},0,1);
	}
		
	public void startFire() {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable(){

			double var = 0;
			Location loc, first, second;
			ParticleData particle = new ParticleData(player.getUniqueId());
			
			@Override
			public void run() {
				if(!particle.hasID()) {
					particle.setID(taskID);
				}
				
				var += Math.PI/16;
				
				loc = player.getLocation();
				second = loc.clone().add(Math.cos(var  -1 ), Math.cos(var +.5),Math.sin(var  -1));
				first = loc.clone().add(Math.cos(var + 1), Math.cos(var + .5),Math.sin(var +1));
				player.getWorld().spawnParticle(Particle.FLAME, first, 0);
				player.getWorld().spawnParticle(Particle.FLAME, second, 0);
			}
				
		},0,1);
	}
	public void startFireWork() {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable(){

			double var = 0;
			Location loc, first, second;
			ParticleData particle = new ParticleData(player.getUniqueId());
			
			@Override
			public void run() {
				if(!particle.hasID()) {
					particle.setID(taskID);
				}
				
				var += Math.PI/16;
				
				loc = player.getLocation();
				second = loc.clone().add(Math.cos(var - 2), Math.cos(var +.5),Math.sin(var - 2));
				first = loc.clone().add(Math.cos(var + 2), Math.cos(var + .5),Math.sin(var + 2));
				player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, first, 0);
				player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, second, 0);
			}
				
		},0,1);
	}
	public void startTNT() {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable(){

			double var = 0;
			Location loc, first, second;
			ParticleData particle = new ParticleData(player.getUniqueId());
			
			@Override
			public void run() {
				if(!particle.hasID()) {
					particle.setID(taskID);
				}
				
				var += Math.PI/16;
				
				loc = player.getLocation();
				first = loc.clone();
				player.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, first, 0);
			}
				
		},0,1);
	}
	public void startDragon() {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable(){

			double var = 0;
			Location loc, first, second;
			ParticleData particle = new ParticleData(player.getUniqueId());
			
			@Override
			public void run() {
				if(!particle.hasID()) {
					particle.setID(taskID);
				}
				
				var += Math.PI/16;
				
				loc = player.getLocation();
				first = loc.clone().add(Math.cos(var),Math.sin(var) + 1, Math.sin(var));
				second = loc.clone().add(Math.cos(var+ Math.PI), Math.sin(var) + 1, Math.sin(var + Math.PI));
				
				player.getWorld().spawnParticle(Particle.DRAGON_BREATH, first, 0);
				player.getWorld().spawnParticle(Particle.DRAGON_BREATH, second, 0);
			}
			
		},0,1);
	}
	public void startCrit() {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable(){

			double var = 0;
			Location loc, first, second;
			ParticleData particle = new ParticleData(player.getUniqueId());
			
			@Override
			public void run() {
				if(!particle.hasID()) {
					particle.setID(taskID);
				}
				
				
				loc = player.getLocation();
				first = loc.clone().add(Math.sin(var - 0.5), Math.sin(var - 0.5), Math.sin(var - 0.5));
				second = loc.clone().add(Math.sin(var + 0.5), Math.sin(var + 0.5), Math.sin(var + 0.5));
				
				player.getWorld().spawnParticle(Particle.CRIT, first, 0);
				player.getWorld().spawnParticle(Particle.CRIT, second, 0);
			}
			
		},0,1);
	}
}
