package me.Stormm.AspectOfTheEnd;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this,this);
		Bukkit.addRecipe(getRecipe());
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("aspectoftheend")|| label.equalsIgnoreCase("aote")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("Sorry console, you can't use this! LOLXDXD");
				return true;
			}
			
			Player player = (Player) sender;
			if(player.getInventory().firstEmpty()==-1) {
			Location loc = player.getLocation();
				World world = player.getWorld();
				world.dropItemNaturally(loc, getItem());
				return true;
			}
			player.getInventory().addItem(getItem());
			return true;
		}
		return false;
	}
	
	public ShapedRecipe getRecipe() {
		ItemStack item = getItem();
		NamespacedKey key = new NamespacedKey(this, "aote");
		ShapedRecipe recipe = new ShapedRecipe(key, getItem());
		recipe.shape("PEP", "PEP", "PSP");
		recipe.setIngredient('E', Material.ENDER_EYE);
		recipe.setIngredient('S', Material.STICK);
		recipe.setIngredient('P', Material.ENDER_PEARL);
		return recipe;
	}
	
	public ItemStack getItem() {
		ItemStack aote = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = aote.getItemMeta();
		meta.setDisplayName(ChatColor.BLUE + "Aspect of The End");
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attackDamage", 100, Operation.ADD_NUMBER));
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+100");
		lore.add("");
		lore.add(ChatColor.GOLD + "Item Ability: Instant Transmission" + ChatColor.YELLOW+ ""+ ChatColor.BOLD + " RIGHT CLICK");
		lore.add(ChatColor.GRAY + "Teleport" + ChatColor.GREEN + " 8 blocks" + ChatColor.GRAY + " ahead of you");
		lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE SWORD");
		meta.setLore(lore);
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
		aote.setItemMeta(meta);
		return aote;
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_SWORD))
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					Location loc = player.getLocation();
					Vector dir = loc.getDirection();
					dir.normalize();
					dir.multiply(8); 
					loc.add(dir);
					if (loc.getBlock().getType() == Material.AIR || loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.LAVA){
						player.teleport(loc);
						player.playSound(player.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT, 5, 5);
					}
					else {
						player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "There are blocks in the way!");
					}
					return;
				}
			}
	}
	
}
