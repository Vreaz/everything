package me.vreaz.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.vreaz.main.Main;

public class ScoreboardListener implements Listener{

	Main main;
	 
	 public ScoreboardListener(Main main) {
		 this.main = main;
	 }
	 
	@EventHandler
    public void scoreboardJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		main.getManager().setScoreboard(p);
	}
}
