package me.vreaz.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;
import me.vreaz.main.Main;
import net.md_5.bungee.api.ChatColor;


public class ScoreboardLobby implements Listener{


	Main main;
	
	public ScoreboardLobby(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void setScoreboard(Player p) {

		    ScoreboardManager scm = Bukkit.getScoreboardManager();
	        Scoreboard board = scm.getNewScoreboard();
	        
	        
	        Objective obj = board.registerNewObjective("test", "dummy");
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
            obj.setDisplayName("§7▪ §3§lDrainGang §7▪");

            
            Team strich = board.registerNewTeam("strich");
            strich.addEntry(ChatColor.BLACK.toString());
            strich.setSuffix("§8§m---------");
            strich.setPrefix("§8§m┠---------");
            obj.getScore(ChatColor.BLACK.toString()).setScore(13);
            
            Team rang = board.registerNewTeam("rang");
            rang.addEntry(ChatColor.YELLOW.toString());
            rang.setPrefix(" §8•");
            rang.setSuffix(" §7Rang"); 
            obj.getScore(ChatColor.YELLOW.toString()).setScore(12);
            
            Team deinrang = board.registerNewTeam("deinrang");
            deinrang.addEntry(ChatColor.BLUE.toString());
            deinrang.setPrefix("  §8➽");
            deinrang.setSuffix(" §aSpieler");
            obj.getScore(ChatColor.BLUE.toString()).setScore(11);
            
            obj.getScore("§5 ").setScore(10);

            Team coins = board.registerNewTeam("coins");
            coins.setPrefix(" §8•");
            coins.setSuffix(" §7Coins"); 
            coins.addEntry(ChatColor.DARK_RED.toString());
            obj.getScore(ChatColor.DARK_RED.toString()).setScore(9);
 
            Team deinecoins = board.getTeam("deinecoins");           
            if(deinecoins == null) {
            	deinecoins = board.registerNewTeam("deinecoins");
            }
            
           deinecoins.setPrefix("  §8➽");
           deinecoins.setSuffix(" §f"+CoinsAPI.getCoins(p.getUniqueId().toString()));         
           deinecoins.addEntry(ChatColor.LIGHT_PURPLE.toString());            
           obj.getScore(ChatColor.LIGHT_PURPLE.toString()).setScore(8);   
           
            obj.getScore("§c ").setScore(7);			
            
            Team lose = board.registerNewTeam("lose");
            lose.setPrefix(" §8•");
            lose.setSuffix(" §7Lose"); 
            lose.addEntry(ChatColor.DARK_GREEN.toString());
            obj.getScore(ChatColor.DARK_GREEN.toString()).setScore(6);
            
            Team deinelose = board.getTeam("deinelose");           
            if(deinelose == null) {
            	deinelose = board.registerNewTeam("deinelose");
            }
            deinelose.setPrefix("  §8➽");
            int Lose = ConfigManager.get().getInt(p.getName() + ".lose");
            deinelose.setSuffix(" §f" + Lose); 
            deinelose.addEntry(ChatColor.WHITE.toString());
            obj.getScore(ChatColor.WHITE.toString()).setScore(5);
            
            obj.getScore("§0 ").setScore(4);		
            
            Team spieler = board.registerNewTeam("spieler");
            spieler.setPrefix(" §8•");
            spieler.setSuffix(" §7Spieler"); 
            spieler.addEntry(ChatColor.DARK_AQUA.toString());
            obj.getScore(ChatColor.DARK_AQUA.toString()).setScore(3);
            
            Team onspieler = board.getTeam("onspieler");           
            if(onspieler == null) {
            	onspieler = board.registerNewTeam("onspieler");
            }
            
            onspieler.setPrefix("  §8➽");
            onspieler.setSuffix(" §f" + Bukkit.getOnlinePlayers().size()+"§7/§f"+Bukkit.getServer().getMaxPlayers()); 
            onspieler.addEntry(ChatColor.AQUA.toString());
            obj.getScore(ChatColor.AQUA.toString()).setScore(2);
            
            Team strich2 = board.registerNewTeam("strich2");
            strich2.addEntry(ChatColor.GOLD.toString());
            strich2.setSuffix("§8§m---------");
            strich2.setPrefix("§8§m┠---------");
            obj.getScore(ChatColor.GOLD.toString()).setScore(1);
            
           p.setScoreboard(board);

	}
	@EventHandler
	public void updateScoreboard(Player p) {
		
		if(p.getScoreboard() == null) {
			setScoreboard(p);
		}
		Scoreboard board = p.getScoreboard();
        Objective obj = board.getObjective("test");
		
        Team deinecoins = board.getTeam("deinecoins");
        if(deinecoins == null) {
        	board.registerNewTeam("deinecoins");
        }
        
       
        deinecoins.setPrefix("  §8➽");
        deinecoins.setSuffix(" §f"+CoinsAPI.getCoins(p.getUniqueId().toString()));         
        deinecoins.addEntry(ChatColor.LIGHT_PURPLE.toString());            
        obj.getScore(ChatColor.LIGHT_PURPLE.toString()).setScore(8);  
        
        Team deinelose = board.getTeam("deinelose");           
        if(deinelose == null) {
        	deinelose = board.registerNewTeam("deinelose");
        }
        deinelose.setPrefix("  §8➽");
        int Lose = ConfigManager.get().getInt(p.getName() + ".lose");
        deinelose.setSuffix(" §f" + Lose); 
        deinelose.addEntry(ChatColor.WHITE.toString());
        obj.getScore(ChatColor.WHITE.toString()).setScore(5);
		
        Team onspieler = board.getTeam("onspieler");           
        if(onspieler == null) {
        	onspieler = board.registerNewTeam("onspieler");
        }
        
        onspieler.setPrefix("  §8➽");
        onspieler.setSuffix(" §f" + Bukkit.getOnlinePlayers().size()+"§7/§f"+Bukkit.getServer().getMaxPlayers()); 
        onspieler.addEntry(ChatColor.AQUA.toString());
        obj.getScore(ChatColor.AQUA.toString()).setScore(2);
	}
	public void startScoreboardTimer() {
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
				for(Player p : Bukkit.getOnlinePlayers()) {
					updateScoreboard(p);
				}
				
			}
		}.runTaskTimer(main, 0, 70);
		
	}
}
