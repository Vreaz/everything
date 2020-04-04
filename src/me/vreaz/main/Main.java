package me.vreaz.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import me.vreaz.listener.JoinListener;
import me.vreaz.listener.Lottery;
import me.vreaz.listener.LotteryAgainPlay;
import me.vreaz.listener.LotteryPlay;
import me.vreaz.listener.RunListener;
import me.vreaz.listener.SneakListener;
import me.vreaz.manager.ConfigManager;
import me.vreaz.manager.ScoreboardLobby;


public class Main extends JavaPlugin {
	

	@Override
	public void onEnable() {
		System.out.print("�aDas Plugin wurde erfolgreich gestartet!");
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new SneakListener(), this); 
		pm.registerEvents(new RunListener(), this); 
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new ScoreboardLobby(), this);
		pm.registerEvents(new Lottery(), this);
		pm.registerEvents(new LotteryPlay(), this);
		pm.registerEvents(new LotteryAgainPlay(), this);
		new ScoreboardLobby().startAnimation();
		new ScoreboardLobby().updateCoins();
	
		
		getConfig().options().copyDefaults();
        saveDefaultConfig();
 
        ConfigManager.setup();
        
        ConfigManager.get().options().copyDefaults(true);
        ConfigManager.save();
        
	}

	
	public void onDisable() {
		
		System.out.print("�4Das Plugin wurde NICHT erfolgreich gestartet!");
		
	}
	
	

}
