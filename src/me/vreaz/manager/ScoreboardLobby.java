package me.vreaz.manager;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;
import me.vreaz.main.Main;
import net.md_5.bungee.api.ChatColor;

public class ScoreboardLobby implements Listener{

	private static HashMap<Scoreboard, Player> boards = new HashMap<>();
	
	private static Integer animationcount;
	
	private static String[] animation = new String[] {
			"§8◆ §3§lDrainGang §8◆","§8● §3§lDrainGang §8●","§8■ §3§lDrainGang §8■"
	};
	

	public void setScoreboard(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("scoreboard-main", "dummy");
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(animation[animationcount]);

		
		Team strich2 = board.registerNewTeam("strich2");
		strich2.setPrefix("§8§m---------");
		strich2.setSuffix("§8§m---------- ");
		strich2.addEntry(ChatColor.GRAY.toString());		
		obj.getScore(ChatColor.GRAY.toString()).setScore(13);
		
		obj.getScore(" §8• §7Rang").setScore(12);
		obj.getScore("  §8➽ §aSpieler").setScore(11);
    	
    	obj.getScore("§a").setScore(10);
		obj.getScore(" §8• §7Spieler").setScore(9);
		
		Team user0 = board.registerNewTeam("user0");
		user0.setPrefix("  §8➽ §d" + Bukkit.getServer().getOnlinePlayers().size()+ "/"+Bukkit.getServer().getMaxPlayers());
		user0.setSuffix(" ");
		user0.addEntry(ChatColor.LIGHT_PURPLE.toString());		
		obj.getScore(ChatColor.LIGHT_PURPLE.toString()).setScore(8);
		
		obj.getScore("§b").setScore(7);
		obj.getScore(" §8• §7Coins").setScore(6);
		
		Team coins = board.registerNewTeam("coins");
		coins.setPrefix("  §8➽ §e");
		coins.setSuffix(" ");
		coins.addEntry(ChatColor.YELLOW.toString());		
		obj.getScore(ChatColor.YELLOW.toString()).setScore(5);
			
		obj.getScore("§5 ").setScore(4);
		obj.getScore(" §8• §7Server").setScore(3);
		
		Team server = board.registerNewTeam("server");
		server.setPrefix("  §8➽ §b"+ Bukkit.getServer().getName());
		server.setSuffix(" ");
		server.addEntry(ChatColor.BLUE.toString());		
		obj.getScore(ChatColor.BLUE.toString()).setScore(2);
		Team strich1 = board.registerNewTeam("strich1");
		
		strich1.setPrefix("§8§m---------");
    	strich1.setSuffix("§8§m---------- ");
		strich1.addEntry(ChatColor.BLACK.toString());		
		obj.getScore(ChatColor.BLACK.toString()).setScore(1);
		
		boards.put(board, p);
	p.setScoreboard(board);
	
}
	
	public void startAnimation() {
		animationcount = 0;
		Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {

			
			@Override
			public void run() {
				Bukkit.getOnlinePlayers().forEach(current -> {
					if(current.getScoreboard() == null)
						setScoreboard(current);
						current.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(animation[animationcount]);

					});
				for(Scoreboard board : boards.keySet()) {
					Player p2 = boards.get(board);
					board.getTeam("coins").setPrefix("  §8➽ §e"+ CoinsAPI.getCoins(p2.getUniqueId().toString()));
					board.getTeam("user0").setPrefix("  §8➽ §d" + Bukkit.getServer().getOnlinePlayers().size()+ "/"+Bukkit.getServer().getMaxPlayers());
				}

					animationcount++;
					
					if(animationcount == animation.length)
						animationcount = 0;
					
				}
			}, 0, 120);
			
		}

	public void updateCoins() {
		animationcount = 0;
		Bukkit.getScheduler().runTaskTimer(Main.getPlugin(Main.class), new Runnable() {

			
			@Override
			public void run() {
				for(Scoreboard board : boards.keySet()) {
					Player p2 = boards.get(board);
					board.getTeam("coins").setPrefix("  §8➽ §e"+ CoinsAPI.getCoins(p2.getUniqueId().toString()));
				}			
				}
			}, 0, 60);
			
		}

}
	
