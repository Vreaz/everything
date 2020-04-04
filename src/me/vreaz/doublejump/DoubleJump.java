package me.vreaz.doublejump;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import net.minecraft.server.v1_8_R3.Material;

public class DoubleJump implements Listener {
	
	@EventHandler
	public void onPlayJoin(PlayerJoinEvent e) {
		e.getPlayer().setAllowFlight(true);
	}
	
	@EventHandler
	public void onPlayerDoubleJump(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
		if(p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
			Block b = p.getWorld().getBlockAt(p.getLocation().subtract(0,2,0));
			if(!b.getType().equals(Material.AIR)) {
				Vector v = p.getLocation().getDirection().multiply(1).setY(1);
				p.setVelocity(v);
			}
		}
	}
	

}
