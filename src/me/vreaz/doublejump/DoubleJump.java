package me.vreaz.doublejump;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

public class DoubleJump implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.setAllowFlight(true);
		p.setFlying(false);
	}
	
	@EventHandler
	public void onFly(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.SURVIVAL) {
			e.setCancelled(true);
			p.setAllowFlight(false);
			p.setFlying(false);
		    p.setVelocity(p.getLocation().getDirection().multiply(1.5).add(new Vector(0,1.5,0)));
			if(p.getEyeLocation().getBlock().getType() == Material.AIR) {
			ParticleEffect.FLAME.send(Bukkit.getOnlinePlayers(), p.getLocation(), 1, 1, 1, 0, 10);
			}
			p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1f, 1f);
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getGameMode() == GameMode.SURVIVAL) {
			if(p.getLocation().add(0,-1,0).getBlock().getType() != Material.AIR) {
				p.setAllowFlight(true);
				p.setFlying(false);
			}
		}
		
	}
	@EventHandler
	public void onFly2(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getLocation().add(0,-1,0).getBlock().getType() == Material.AIR) {
			ParticleEffect.FLAME.send(Bukkit.getOnlinePlayers(), p.getLocation(), 0.5, 0.5, 0.5, 0, 5);
		
	}
}
}
