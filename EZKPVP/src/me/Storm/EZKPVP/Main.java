package me.Storm.EZKPVP;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	public static Inventory kits;
    
    @Override
    public void onEnable() {
        this.registerConfig();
    }
    @Override
    public void onDisable() {
    	
    }
    
    private void createInventory() {
    	Inventory inv = Bukkit.createInventory(null, 36, ChatColor.GOLD + "Kits");
    }
    
    private void registerConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("kits")) {
        	if(!(sender instanceof Player)) {
        		return true;
        	}
            Player p = (Player)sender;
            p.openInventory(kits);
            FileConfiguration config = this.getConfig();
            if (args.length >= 1 && config.contains(args[0])) {
                final String kit = args[0];
                final PlayerInventory i = p.getInventory();
                if (config.contains(kit)) {
                    final ConfigurationSection section = config.getConfigurationSection(kit);
                    if (section.contains("items")) {
                        i.clear();
                        for (final String items : section.getStringList("items")) {
                            final List<String> itemIDs = new ArrayList<String>();
                            String[] split;
                            for (int length = (split = items.split(" ")).length, j = 0; j < length; ++j) {
                                final String s = split[j];
                                itemIDs.add(s);
                            }
                            Material mat = Material.matchMaterial(itemIDs.get(0).toUpperCase());
                            if (mat == null) {
                                mat = Material.WOOD;
                            }
                            int amount;
                            if (this.isInt(itemIDs.get(1))) {
                                amount = Integer.parseInt(itemIDs.get(1));
                            }
                            else {
                                amount = 0;
                            }
                            Short data;
                            if (this.isInt(itemIDs.get(2))) {
                                data = (short)Integer.parseInt(itemIDs.get(2));
                            }
                            else {
                                data = 0;
                            }
                            final ItemStack item = new ItemStack(mat, amount, (short)data);
                            i.addItem(new ItemStack[] { item });
                        }
                    }
                    if (section.contains("armor")) {
                        for (final String armors : section.getStringList("armor")) {
                            final List<String> armorIDs = new ArrayList<String>();
                            String[] split2;
                            for (int length2 = (split2 = armors.split(" ")).length, k = 0; k < length2; ++k) {
                                final String s = split2[k];
                                armorIDs.add(s);
                            }
                            Material mat = Material.matchMaterial(armorIDs.get(0).toUpperCase());
                            if (mat == null) {
                                mat = Material.WOOD;
                            }
                            int amount;
                            if (this.isInt(armorIDs.get(1))) {
                                amount = Integer.parseInt(armorIDs.get(1));
                            }
                            else {
                                amount = 0;
                            }
                            Short data;
                            if (this.isInt(armorIDs.get(2))) {
                                data = (short)Integer.parseInt(armorIDs.get(2));
                            }
                            else {
                                data = 0;
                            }
                            final ItemStack item = new ItemStack(mat, amount, (short)data);
                            if (i.getHelmet() == null) {
                                i.setHelmet(item);
                            }
                            else if (i.getChestplate() == null) {
                                i.setChestplate(item);
                            }
                            else if (i.getLeggings() == null) {
                                i.setLeggings(item);
                            }
                            else {
                                if (i.getBoots() != null) {
                                    continue;
                                }
                                i.setBoots(item);
                            }
                        }
                    }
                    p.sendMessage(ChatColor.AQUA + "You now have the " + args[0] + " kit!");
                    return false;
                }
            }
        }
        return false;
    }
    
    private boolean isInt(final String s) {
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
}
