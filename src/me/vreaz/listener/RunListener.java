package me.vreaz.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.inventivetalent.particle.ParticleEffect;

public class RunListener implements Listener{
	
	@EventHandler
    public void onPlayerRunEvent(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.isSprinting()) {
			if(!p.isFlying()) {
				if(p.getLocation().add(0,-1.5,0).getBlock().getType() != Material.AIR) {
					ParticleEffect.CLOUD.send(Bukkit.getOnlinePlayers(), p.getLocation(), 0, 0, 0, 0, 1);
				}
			}
		}
		
	}
	

}