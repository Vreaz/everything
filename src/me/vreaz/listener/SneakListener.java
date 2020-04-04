package me.vreaz.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.inventivetalent.particle.ParticleEffect;


public class SneakListener implements Listener{
	

	
	@EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		
		if(p.isSneaking()) {
			ParticleEffect.HEART.send(Bukkit.getOnlinePlayers(), p.getLocation(), 1, 1, 1, 1, 5);
		}
	}
	

}
