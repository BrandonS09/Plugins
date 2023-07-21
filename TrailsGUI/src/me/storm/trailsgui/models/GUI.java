package me.storm.trailsgui.models;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class GUI {
	
	private static Inventory INV;
	
	public void register() {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.AQUA +""+ ChatColor.BOLD + "Trails GUI");
		
		ItemStack item = new ItemStack(Material.FIREWORK_ROCKET);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_RED + "Firework Trial");
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		item = new ItemStack(Material.TNT);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.WHITE+ "Explosion Trial");
		item.setItemMeta(meta);
		inv.setItem(2, item);
		
		item = new ItemStack(Material.TOTEM_OF_UNDYING);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + "Totem Trial");
		item.setItemMeta(meta);
		inv.setItem(3, item);
		
		item = new ItemStack(Material.FLINT_AND_STEEL);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Fire Trail");
		item.setItemMeta(meta);
		inv.setItem(4, item);
		
		item = new ItemStack(Material.CAMPFIRE);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Campfire Trail");
		item.setItemMeta(meta);
		inv.setItem(5, item);
		
		item = new ItemStack(Material.DRAGON_EGG);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Dragon Trail");
		item.setItemMeta(meta);
		inv.setItem(6, item);
		
		item = new ItemStack(Material.DIAMOND_SWORD);
		meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "Crit Trail");
		item.setItemMeta(meta);
		inv.setItem(7, item);
		
		setInventory(inv);
	}
	
	public Inventory getInventory() {
		return INV;
	}
	
	private void setInventory(Inventory inv) {
		INV = inv;
	}
	
	public void openInventory(Player player) {
		player.openInventory(INV);
	}
}
