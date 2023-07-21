package me.Stormm.KitPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public static Inventory kits;
	//Check all kits to see if it works, if not, change it back.
	Map<String, Long> cooldowns = new HashMap<String, Long>();
	Map<String, Long> cooldown = new HashMap<String, Long>();
	Map<String, Long> coldowns = new HashMap<String, Long>();
	Map<String, Long> coldown = new HashMap<String, Long>();
	Map<String, Long> cold = new HashMap<String, Long>();
	Map<String, Long> down = new HashMap<String, Long>();
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this,this);
		createInventory();
	}
	@Override
	public void onDisable() {
		
	}
	private void createInventory() {
		Inventory inv = Bukkit.createInventory(null, 36, ChatColor.BLUE + "Kit Selector");
		ItemStack item = new ItemStack(Material.IRON_SWORD);
		ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		ItemMeta meta2 = item.getItemMeta();
		ItemMeta meta3 = item.getItemMeta();
		ItemMeta meta4 = item.getItemMeta();
		ItemMeta meta5 = item.getItemMeta();
		ItemMeta meta6 = item.getItemMeta();
		ItemMeta meta7 = item.getItemMeta();
		ItemMeta meta8 = item.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "PvP Kit");
		List<String> lore= new ArrayList<>();
		lore.add(ChatColor.GRAY + "The most basic pvp kit");
		lore.add(ChatColor.RED + "Can be used anytime");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setLore(lore);
		item.setItemMeta(meta);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		inv.setItem(11,item);
		List<String> lore2= new ArrayList<>();
		item.setType(Material.BOW);
		meta2.setDisplayName(ChatColor.GOLD + "Archer Kit");
		lore2.add(ChatColor.GRAY + "The basic kit for archers");
		lore2.add(ChatColor.RED + "Can be used anytime");
		meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta2.setLore(lore2);
		item.setItemMeta(meta2);
		inv.setItem(12, item);
		List<String> lore3= new ArrayList<>();
		item.setType(Material.IRON_SWORD);
		meta.setDisplayName(ChatColor.GOLD + "Elite Pvp Kit");
		lore3.add(ChatColor.GRAY + "The elite pvp kit");
		lore3.add(ChatColor.RED + "Can be used once every 20 minutes");
		meta3.addEnchant(Enchantment.DURABILITY, 0, true);
		meta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta3.setLore(lore3);
		item.setItemMeta(meta3);
		inv.setItem(13, item);
		List<String> lore4= new ArrayList<>();
		item.setType(Material.BOW);
		meta = item.getItemMeta();
		meta4.setDisplayName(ChatColor.GOLD + "Elite Archer Kit");
		lore4.add(ChatColor.GRAY + "The elite kit for archers");
		lore4.add(ChatColor.RED + "Can be used once every 20 minutes");
		meta4.addEnchant(Enchantment.DURABILITY, 0, true);
		meta4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta4.setLore(lore4);
		item.setItemMeta(meta4);
		inv.setItem(14, item);
		List<String> lore5= new ArrayList<>();
		item.setType(Material.DIAMOND_SWORD);
		meta = item.getItemMeta();
		meta5.setDisplayName(ChatColor.GOLD + "God Kit");
		lore5.add(ChatColor.GRAY + "The best pvp kit");
		lore5.add(ChatColor.RED + "Can be used once every 36 hours");
		meta5.addEnchant(Enchantment.DURABILITY, 0, true);
		meta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta5.setLore(lore5);
		item.setItemMeta(meta5);
		inv.setItem(15, item);
		List<String> lore6= new ArrayList<>();
		item.setType(Material.GOLDEN_APPLE);
		meta6 = item.getItemMeta();
		meta6.setDisplayName(ChatColor.GOLD + "Daily Pvp Kit");
		lore6.add(ChatColor.GRAY + "The intermediate pvp kit");
		lore6.add(ChatColor.RED + "Can be used once a day");
		meta6.addEnchant(Enchantment.DURABILITY, 0, true);
		meta6.setLore(lore6);
		meta6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta6);
		inv.setItem(21, item);
		List<String> lore7= new ArrayList<>();
		item.setType(Material.BOW);
		meta = item.getItemMeta();
		meta7.setDisplayName(ChatColor.GOLD + "Daily Archer Kit");
		lore7.add(ChatColor.GRAY + "The default daily kit");
		lore7.add(ChatColor.RED + "Can be used once every day");
		meta7.addEnchant(Enchantment.DURABILITY, 0, true);
		meta7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta7.setLore(lore7);
		item.setItemMeta(meta7);
		inv.setItem(22, item);
		List<String> lore8= new ArrayList<>();
		item.setType(Material.DIAMOND_CHESTPLATE);
		meta = item.getItemMeta();
		meta8.setDisplayName(ChatColor.GOLD + "Tank Kit");
		lore8.add(ChatColor.GRAY + "The tankiest pvp kit");
		lore8.add(ChatColor.RED + "Can be used once every 2 days");
		meta8.addEnchant(Enchantment.DURABILITY, 0, true);
		meta8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta8.setLore(lore8);
		item.setItemMeta(meta8);
		inv.setItem(23, item);
		List<String> lore9= new ArrayList<>();
		ItemMeta glassmeta = glass.getItemMeta();
		glass.setType(Material.BLACK_STAINED_GLASS_PANE);
		glassmeta.setDisplayName(" ");
		glassmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		glassmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		glassmeta.setLore(lore9);
		glass.setItemMeta(glassmeta);
		inv.setItem(0, glass);
		inv.setItem(1, glass);
		inv.setItem(2, glass);
		inv.setItem(3, glass);
		inv.setItem(4, glass);
		inv.setItem(5, glass);
		inv.setItem(6, glass);
		inv.setItem(7, glass);
		inv.setItem(8, glass);
		inv.setItem(9, glass);
		inv.setItem(10, glass);
		inv.setItem(16, glass);
		inv.setItem(17, glass);
		inv.setItem(18, glass);
		inv.setItem(19, glass);
		inv.setItem(20, glass);
		inv.setItem(24, glass);
		inv.setItem(25, glass);
		inv.setItem(26, glass);
		inv.setItem(27, glass);
		inv.setItem(28, glass);
		inv.setItem(29, glass);
		inv.setItem(30, glass);
		inv.setItem(31, glass);
		inv.setItem(32, glass);
		inv.setItem(33, glass);
		inv.setItem(34, glass);
		inv.setItem(35, glass);
		kits = inv;
	}
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("kit")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("dumb");
				return true;
			}
			Player player = (Player) sender;
			player.openInventory(kits);
			return true;
		}
		return false;
	}
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if(!event.getView().getTitle().contains("Kit Selector"))
			return;
		if(event.getCurrentItem() == null)
			return;
		if(event.getCurrentItem().getItemMeta() == null)
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		if(event.getClickedInventory().getType() == InventoryType.PLAYER);
		if(event.getSlot() == 11) {
			this.addItems(player, this.getPvpKit());
			player.closeInventory();
			player.updateInventory();
			return;
		}
		if(event.getSlot() == 12) {
			this.addItems(player, this.getArcherKit());
			player.closeInventory();
			player.updateInventory();
			return;
		}
		if(event.getSlot() == 13) {
			if(cooldowns.containsKey(player.getName())) {
				if(cooldowns.get(player.getName()) > System.currentTimeMillis()) {
					long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 60000;
					player.sendMessage(ChatColor.RED + "Kit will be avalible again in " + timeleft + "m");
					return;
				}
			}
			cooldowns.put(player.getName(), System.currentTimeMillis() + (20 * 60000));
			this.addItems(player, this.getElitePvpKit());
			player.closeInventory();
			player.updateInventory();
			return;
		}
		if(event.getSlot() == 14) {
			if(cooldown.containsKey(player.getName())) {
				if(cooldown.get(player.getName()) > System.currentTimeMillis()) {
					long timeleft = (cooldown.get(player.getName()) - System.currentTimeMillis()) / 60000;
					player.sendMessage(ChatColor.RED + "Kit will be avalible again in " + timeleft + "m");
					return;
				}
			}
			cooldown.put(player.getName(), System.currentTimeMillis() + (20 * 60000));
			this.addItems(player, this.getEliteArcherKit());
			player.closeInventory();
			player.updateInventory();
			return;
		}
		if(event.getSlot() == 15) {
			if(coldowns.containsKey(player.getName())) {
				if(coldowns.get(player.getName()) > System.currentTimeMillis()) {
					long timeleft = (coldowns.get(player.getName()) - System.currentTimeMillis()) / 3600000;
					player.sendMessage(ChatColor.RED + "Kit will be avalible again in " + timeleft + "h");
					return;
				}
			}
			coldowns.put(player.getName(), System.currentTimeMillis() + (36* 3600000));
			this.addItems(player, this.getGodKit());
			player.closeInventory();
			player.updateInventory();
			return;
		}
		if(event.getSlot() == 21) {
			if(coldown.containsKey(player.getName())) {
				if(coldown.get(player.getName()) > System.currentTimeMillis()) {
					long timeleft = (coldown.get(player.getName()) - System.currentTimeMillis()) / 3600000;
					player.sendMessage(ChatColor.RED + "Kit will be avalible again in " + timeleft + "h");
					return;
				}
			}
			coldown.put(player.getName(), System.currentTimeMillis() + (24 * 3600000));
			this.addItems(player, this.getDailyPvpKit());
			player.closeInventory();
			player.updateInventory();
			return;
		}
		if(event.getSlot() == 22) {
			if(cold.containsKey(player.getName())) {
				if(cold.get(player.getName()) > System.currentTimeMillis()) {
					long timeleft = (cold.get(player.getName()) - System.currentTimeMillis()) / 3600000;
					player.sendMessage(ChatColor.RED + "Kit will be avalible again in " + timeleft + "h");
					return;
				}
			}
			cold.put(player.getName(), System.currentTimeMillis() + (24* 3600000));
			this.addItems(player, this.getDailyArcherKit());
			player.closeInventory();
			player.updateInventory();
			return;
		}
		if(event.getSlot() == 23) {
			if(down.containsKey(player.getName())) {
				if(down.get(player.getName()) > System.currentTimeMillis()) {
					long timeleft = (down.get(player.getName()) - System.currentTimeMillis()) / 3600000;
					player.sendMessage(ChatColor.RED + "Kit will be avalible again in " + timeleft + "h");
					return;
				}
			}
			down.put(player.getName(), System.currentTimeMillis() + (48 * 3600000));
			this.addItems(player, this.getArmorKit());
			player.closeInventory();
			player.updateInventory();
			return;
		}
	}
	private void addItems(Player player, ItemStack[] items) {
		player.getInventory().addItem(items);
	}
	private ItemStack[] getPvpKit() {
		ItemStack item = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		ItemStack item2 = new ItemStack(Material.IRON_HELMET);
		ItemMeta meta2 = item.getItemMeta();
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		ItemStack item3 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta3 = item.getItemMeta();
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		ItemStack item4 = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta meta4 = item.getItemMeta();
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		ItemStack item5 = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta5 = item.getItemMeta();
		meta5.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		ItemStack item6 = new ItemStack(Material.BOW);
		ItemMeta meta6 = item.getItemMeta();
		meta6.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		meta.setUnbreakable(true);
		meta2.setUnbreakable(true);
		meta3.setUnbreakable(true);
		meta4.setUnbreakable(true);
		meta5.setUnbreakable(true);
		meta6.setUnbreakable(true);
		item.setItemMeta(meta);
		item2.setItemMeta(meta2);
		item3.setItemMeta(meta3);
		item4.setItemMeta(meta4);
		item5.setItemMeta(meta5);
		item6.setItemMeta(meta6);
		ItemStack[] items = {item5, item6, item, item2, item3, item4 , new ItemStack(Material.GOLDEN_APPLE, 10), new ItemStack(Material.ARROW, 16), new ItemStack(Material.COOKED_BEEF, 16)};
		return items;
	}
	private ItemStack[] getArcherKit() {
		ItemStack item = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2,true);
		ItemStack item2 = new ItemStack(Material.IRON_HELMET);
		ItemMeta meta2 = item.getItemMeta();
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2,true);
		ItemStack item3 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta3 = item.getItemMeta();
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2,true);
		ItemStack item4 = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta meta4 = item.getItemMeta();
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2,true);
		ItemStack item5 = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta meta5 = item.getItemMeta();
		meta5.addEnchant(Enchantment.DAMAGE_ALL, 1 , true);
		ItemStack item6 = new ItemStack(Material.BOW);
		ItemMeta meta6 = item.getItemMeta();
		meta6.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
		meta6.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		meta.setUnbreakable(true);
		meta2.setUnbreakable(true);
		meta3.setUnbreakable(true);
		meta4.setUnbreakable(true);
		meta5.setUnbreakable(true);
		meta6.setUnbreakable(true);
		item.setItemMeta(meta);
		item2.setItemMeta(meta2);
		item3.setItemMeta(meta3);
		item4.setItemMeta(meta4);
		item5.setItemMeta(meta5);
		item6.setItemMeta(meta6);
		ItemStack[] items = {item5, item6, item, item2, item3, item4 , new ItemStack(Material.GOLDEN_APPLE, 10), new ItemStack(Material.ARROW, 64), new ItemStack(Material.COOKED_BEEF, 16)};
		return items;
	}
	private ItemStack[] getElitePvpKit() {
		ItemStack item = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item2 = new ItemStack(Material.IRON_HELMET);
		ItemMeta meta2 = item.getItemMeta();
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item3 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta3 = item.getItemMeta();
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item4 = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta meta4 = item.getItemMeta();
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item5 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta5 = item.getItemMeta();
		meta5.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
		ItemStack item6 = new ItemStack(Material.BOW);
		ItemMeta meta6 = item.getItemMeta();
		meta6.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		meta.setUnbreakable(true);
		meta2.setUnbreakable(true);
		meta3.setUnbreakable(true);
		meta4.setUnbreakable(true);
		meta5.setUnbreakable(true);
		meta6.setUnbreakable(true);
		item.setItemMeta(meta);
		item2.setItemMeta(meta2);
		item3.setItemMeta(meta3);
		item4.setItemMeta(meta4);
		item5.setItemMeta(meta5);
		item6.setItemMeta(meta6);
		ItemStack[] items = {item5, item6, item, item2, item3, item4 , new ItemStack(Material.GOLDEN_APPLE, 10), new ItemStack(Material.ARROW, 16), new ItemStack(Material.COOKED_BEEF, 16), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1)};
		return items;
	}
	private ItemStack[] getEliteArcherKit() {
		ItemStack item = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3,true);
		ItemStack item2 = new ItemStack(Material.IRON_HELMET);
		ItemMeta meta2 = item.getItemMeta();
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3,true);
		ItemStack item3 = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta3 = item.getItemMeta();
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3,true);
		ItemStack item4 = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta meta4 = item.getItemMeta();
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3,true);
		ItemStack item5 = new ItemStack(Material.STONE_SWORD);
		ItemMeta meta5 = item.getItemMeta();
		meta5.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		ItemStack item6 = new ItemStack(Material.BOW);
		ItemMeta meta6 = item.getItemMeta();
		meta6.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
		meta6.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		meta6.addEnchant(Enchantment.ARROW_FIRE, 2, true);
		meta.setUnbreakable(true);
		meta2.setUnbreakable(true);
		meta3.setUnbreakable(true);
		meta4.setUnbreakable(true);
		meta5.setUnbreakable(true);
		meta6.setUnbreakable(true);
		item.setItemMeta(meta);
		item2.setItemMeta(meta2);
		item3.setItemMeta(meta3);
		item4.setItemMeta(meta4);
		item5.setItemMeta(meta5);
		item6.setItemMeta(meta6);
		ItemStack[] items = {item5, item6, item, item2, item3, item4 , new ItemStack(Material.GOLDEN_APPLE, 10), new ItemStack(Material.ARROW, 64), new ItemStack(Material.COOKED_BEEF, 16), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1)};
		return items;
	}
	private ItemStack[] getGodKit() {
		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4,true);
		ItemStack item2 = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta meta2 = item.getItemMeta();
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		meta2.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4,true);
		ItemStack item3 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta3 = item.getItemMeta();
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		meta3.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4,true);
		ItemStack item4 = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta meta4 = item.getItemMeta();
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		meta4.addEnchant(Enchantment.PROTECTION_PROJECTILE,4,true);
		ItemStack item5 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta5 = item.getItemMeta();
		meta5.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		meta5.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		ItemStack item6 = new ItemStack(Material.BOW);
		ItemMeta meta6 = item.getItemMeta();
		meta6.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
		meta6.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		meta6.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		meta.setUnbreakable(true);
		meta2.setUnbreakable(true);
		meta3.setUnbreakable(true);
		meta4.setUnbreakable(true);
		meta5.setUnbreakable(true);
		meta6.setUnbreakable(true);
		meta.setUnbreakable(true);
		meta2.setUnbreakable(true);
		meta3.setUnbreakable(true);
		meta4.setUnbreakable(true);
		meta5.setUnbreakable(true);
		meta6.setUnbreakable(true);
		item.setItemMeta(meta);
		item2.setItemMeta(meta2);
		item3.setItemMeta(meta3);
		item4.setItemMeta(meta4);
		item5.setItemMeta(meta5);
		item6.setItemMeta(meta6);
		ItemStack[] items = {item5, item6, item, item2, item3, item4 , new ItemStack(Material.GOLDEN_APPLE, 20), new ItemStack(Material.ARROW, 32), new ItemStack(Material.COOKED_BEEF, 16), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 10)};
		return items;
	}
	private ItemStack[] getDailyPvpKit() {
		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item2 = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta meta2 = item.getItemMeta();
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item3 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta3 = item.getItemMeta();
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item4 = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta meta4 = item.getItemMeta();
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item5 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta5 = item.getItemMeta();
		meta5.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		meta5.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		ItemStack item6 = new ItemStack(Material.BOW);
		ItemMeta meta6 = item.getItemMeta();
		meta6.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
		meta6.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		meta6.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		meta.setUnbreakable(true);
		meta2.setUnbreakable(true);
		meta3.setUnbreakable(true);
		meta4.setUnbreakable(true);
		meta5.setUnbreakable(true);
		meta6.setUnbreakable(true);
		item.setItemMeta(meta);
		item2.setItemMeta(meta2);
		item3.setItemMeta(meta3);
		item4.setItemMeta(meta4);
		item5.setItemMeta(meta5);
		item6.setItemMeta(meta6);
		ItemStack[] items = {item5, item6, item, item2, item3, item4 , new ItemStack(Material.GOLDEN_APPLE, 10), new ItemStack(Material.ARROW, 32), new ItemStack(Material.COOKED_BEEF, 16), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 5)};
		return items;
	}
	private ItemStack[] getDailyArcherKit() {
		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item2 = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta meta2 = item.getItemMeta();
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item3 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta3 = item.getItemMeta();
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item4 = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta meta4 = item.getItemMeta();
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		ItemStack item5 = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta5 = item.getItemMeta();
		meta5.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		meta5.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		ItemStack item6 = new ItemStack(Material.BOW);
		ItemMeta meta6 = item.getItemMeta();
		meta6.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
		meta6.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		meta6.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		meta6.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		meta.setUnbreakable(true);
		meta2.setUnbreakable(true);
		meta3.setUnbreakable(true);
		meta4.setUnbreakable(true);
		meta5.setUnbreakable(true);
		meta6.setUnbreakable(true);
		item.setItemMeta(meta);
		item2.setItemMeta(meta2);
		item3.setItemMeta(meta3);
		item4.setItemMeta(meta4);
		item5.setItemMeta(meta5);
		item6.setItemMeta(meta6);
		ItemStack[] items = {item5, item6, item, item2, item3, item4 , new ItemStack(Material.GOLDEN_APPLE, 10), new ItemStack(Material.ARROW, 32), new ItemStack(Material.COOKED_BEEF, 16), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 5)};
		return items;
	}
	private ItemStack[] getArmorKit() {
		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10,true);
		ItemStack item2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta2 = item.getItemMeta();
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		meta2.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10,true);
		ItemStack item3 = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta meta3 = item.getItemMeta();
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		meta3.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10,true);
		ItemStack item4 = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta meta4 = item.getItemMeta();
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		meta4.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10,true);
		ItemStack item5 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta5 = item.getItemMeta();
		meta5.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
		meta5.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
		ItemStack item6 = new ItemStack(Material.BOW);
		ItemMeta meta6 = item.getItemMeta();
		meta6.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
		meta6.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		meta6.addEnchant(Enchantment.ARROW_FIRE, 3, true);
		meta.setUnbreakable(true);
		meta2.setUnbreakable(true);
		meta3.setUnbreakable(true);
		meta4.setUnbreakable(true);
		meta5.setUnbreakable(true);
		meta6.setUnbreakable(true);
		item.setItemMeta(meta);
		item2.setItemMeta(meta2);
		item3.setItemMeta(meta3);
		item4.setItemMeta(meta4);
		item5.setItemMeta(meta5);
		item6.setItemMeta(meta6);
		ItemStack[] items = {item5, item6, item, item2, item3, item4 , new ItemStack(Material.GOLDEN_APPLE, 20), new ItemStack(Material.ARROW, 32), new ItemStack(Material.COOKED_BEEF, 16), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 10)};
		return items;
	}
}