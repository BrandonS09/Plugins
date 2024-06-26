package me.storm.trailsgui.models;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;

public class ParticleData {
	private static Map<UUID, Integer> TRAILS = new HashMap<UUID, Integer>();
	private final UUID uuid;
	
	public ParticleData(UUID uuid) {
		this.uuid = uuid;
	}
	
	public void setID(int id) {
		TRAILS.put(uuid, id);
	}
	
	public int getID() {
		return TRAILS.get(uuid);
	}
	
	public boolean hasID() {
		if(TRAILS.containsKey(uuid))
			return true;
		return false;
	}
	
	public void removeID() {
		TRAILS.remove(uuid);
	}
	
	public void endTask() {
		if(getID() == 1)
			return;
		Bukkit.getScheduler().cancelTask(getID());
	}
	
	public static boolean hasFakeId(UUID uuid) {
		if (TRAILS.containsKey(uuid))
			if(TRAILS.get(uuid) == 1)
				return true;
		return false;
	}
}
