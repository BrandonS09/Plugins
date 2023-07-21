package me.storm.joinquitmessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if(player.hasPlayedBefore()){
            player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.GREEN + "Welcome back to the server!!!");
        }
        else{
            player.sendMessage(ChatColor.BLUE + "Everybody say hi to " + ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ", "+ ChatColor.BLUE + "for joining for the first time!!!");
        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.RED + " has left the server!");
    }
}
