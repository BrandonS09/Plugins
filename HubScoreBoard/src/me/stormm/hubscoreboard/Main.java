package me.stormm.hubscoreboard;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	private int taskID;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		
		if(Bukkit.getOnlinePlayers().isEmpty())
			for (Player online : Bukkit.getOnlinePlayers()) {
				createBoard(online);
				start(online);
			}
	}
	@Override
	public void onDisable() {
		
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		createBoard(event.getPlayer());
		start(event.getPlayer());
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		LobbyBoard board = new LobbyBoard(event.getPlayer().getUniqueId());
		if (board.hasID())
			board.stop();
	}
	
	public void start(Player player) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			int count=0;
			LobbyBoard board = new LobbyBoard(player.getUniqueId());
			
			@Override
			public void run() {
				if(!board.hasID())
					board.setID(taskID);
				if (count == 13)
					count = 0;
				switch(count) {
				case 0:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&l5tormm &a&1>>"));
					
					break;
				case 1:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&15&2&ltormm &a&1>>"));
					createBoard(player);
					break;
				case 2:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&l5t&2&lormm &a&1>>"));
					createBoard(player);
					break;
				case 3:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&l5to&2&lrmm &a&1>>"));
					createBoard(player);
					break;
				case 4:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&15tor&2&lmm &a&1>>"));
					createBoard(player);
					break;
				case 5:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&15torm&2&lm &a&1>>"));
					createBoard(player);
					break;
				case 6:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&15tormm &a&1>>"));
					createBoard(player);
					break;
				case 7:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&15torm&2&lm &a&1>>"));
					createBoard(player);
					break;
				case 8:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&15tor&2&lmm &a&1>>"));
					createBoard(player);
					break;
				case 9:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&15to&2&lrmm &a&1>>"));
					createBoard(player);
					break;
				case 10:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&15t&2&lormm &a&1>>"));
					createBoard(player);
					break;
				case 11:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &d&15&2&ltormm &a&1>>"));
					createBoard(player);
					break;
				case 12:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&l5tormm &a&1>>"));
					createBoard(player);
					break;
				}count++;
			}
			
		}, 0, 10);
	}
	
	public void createBoard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective obj = board.registerNewObjective("HubScoreBoard","dummy",ChatColor.translateAlternateColorCodes('&', "&a&1<< &2&l5tormm &a&1>>"));
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score score = obj.getScore(ChatColor.BLUE + "=-=-=-=-=-=-=-=-=");
		score.setScore(3);
		Score score2 = obj.getScore(ChatColor.AQUA + "Online Players: " + ChatColor.DARK_AQUA + Bukkit.getOnlinePlayers().size());
		score2.setScore(2);
		Score score3 = obj.getScore(ChatColor.AQUA + "Total Mob Kills: " + ChatColor.DARK_AQUA + player.getStatistic(Statistic.MOB_KILLS));
		score3.setScore(1);
		Score score4 = obj.getScore(ChatColor.BLUE + "Rank:" + ChatColor.DARK_AQUA + "Owner");
		score4.setScore(0);
		player.setScoreboard(board);
		
	}
}
