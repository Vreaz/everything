package me.vreaz.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.vreaz.doublejump.DoubleJump;
import me.vreaz.inventories.HidePlayers;
import me.vreaz.inventories.Navigation;
import me.vreaz.listener.JoinListener;
import me.vreaz.listener.RunListener;
import me.vreaz.listener.ScoreboardListener;
import me.vreaz.listener.SneakListener;
import me.vreaz.lottery.Lottery;
import me.vreaz.lottery.LotteryAgainPlay;
import me.vreaz.lottery.LotteryPlay;
import me.vreaz.manager.ConfigManager;
import me.vreaz.manager.ScoreboardLobby;


public class Main extends JavaPlugin {
	
	private ScoreboardLobby manager;
	public static Plugin plugin;
	public static String prefix = "§3§lDG §7» ";
	
	@Override
	public void onEnable() {	
		System.out.print("§aDas Plugin wurde erfolgreich gestartet!");		
		
		fetchClasses();		
	
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new SneakListener(), this); 
		pm.registerEvents(new RunListener(), this); 
		pm.registerEvents(new Lottery(), this);
		pm.registerEvents(new LotteryPlay(), this);
		pm.registerEvents(new LotteryAgainPlay(), this);
		pm.registerEvents(new DoubleJump(), this);
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new HidePlayers(), this);
		pm.registerEvents(new Navigation(), this);		
		pm.registerEvents(new ScoreboardListener(this), this);
		getManager().startScoreboardTimer();
		
		//CONFIG
		getConfig().options().copyDefaults();
        saveDefaultConfig();
 
        ConfigManager.setup();
        
        ConfigManager.get().options().copyDefaults(true);
        ConfigManager.save();       
	}
	public void onDisable() {		
		System.out.print("§4Das Plugin wurde erfolgreich gestartet!");
		
	}
	public void fetchClasses() {
		manager = new ScoreboardLobby(this);		
	}	
	public ScoreboardLobby getManager() {
		return manager;
	}
	

}
