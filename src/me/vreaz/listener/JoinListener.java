package me.vreaz.listener;


import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import com.connorlinfoot.titleapi.TitleAPI;



public class JoinListener implements Listener{
	
	 
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		for (int x = 0; x < 50; x++) {
		p.sendMessage(" ");
		p.setMaxHealth(6);
		}
		
		TitleAPI.sendTitle(p, 20, 60, 15, "§3Willkommen auf", "§bDrainGang");
		
		ItemStack shownPlayers = new ItemStack(Material.INK_SACK,1,(short)5);
		ItemMeta shownPlayersMeta = shownPlayers.getItemMeta();		
		ArrayList <String> shownPlayersLore = new ArrayList<>();
		shownPlayersLore.add("§7Rechtsklick um alle Spieler zu verstecken");
		shownPlayersMeta.setDisplayName("§cSpieler verstecken");
		shownPlayersMeta.setLore(shownPlayersLore);
		shownPlayers.setItemMeta(shownPlayersMeta);
		
		ItemStack navigation = new ItemStack(Material.COMPASS,1,(short)0);
		ItemMeta navigationMeta = navigation.getItemMeta();
		ArrayList <String> navigationLore = new ArrayList<>();
		navigationLore.add("§7Rechtsklick um die Navigation zu öffnen");
		navigationMeta.setDisplayName("§cNavigation");
		navigationMeta.setLore(navigationLore);
		navigation.setItemMeta(navigationMeta);
		
		
		p.getInventory().setItem(8, shownPlayers);
		p.getInventory().setItem(0, navigation);

		
	}
	
	@EventHandler
    public void ouit(PlayerQuitEvent e) {
		e.setQuitMessage(" ");
			
		}
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e){
	  e.setCancelled(e.toWeatherState());
	}	
	@EventHandler
	  public void onBreak(BlockBreakEvent e) {
		Player p = (Player)e.getPlayer();
		if(p.getGameMode() == GameMode.SURVIVAL){  	 	 
	    	 e.setCancelled(true); 
	     } else {
	    	 e.setCancelled(false); 
	     }
	    		 
	  }
	@EventHandler
	  public void onPlace(BlockPlaceEvent e) {
		Player p = (Player)e.getPlayer();
		if(p.getGameMode() == GameMode.SURVIVAL){  	 	 
	    	 e.setCancelled(true); 
	     } else {
	    	 e.setCancelled(false); 
	     }
	  }
	@EventHandler
	  public void onDamage(EntityDamageEvent e) {
	    if (e.getEntity() instanceof Player) {
	      @SuppressWarnings("unused")
		Player p = (Player)e.getEntity();
	        e.setCancelled(true); 
	    }
	}
	@EventHandler
	  public void onPickup(PlayerPickupItemEvent e) {
		Player p = (Player)e.getPlayer();
		if(p.getGameMode() == GameMode.SURVIVAL){  	 	 
	    	 e.setCancelled(true); 
	     } else {
	    	 e.setCancelled(false); 
	     }
	  }
	@EventHandler
	  public void onFood(FoodLevelChangeEvent e) {
	    if (e.getEntity() instanceof Player) {
	      @SuppressWarnings("unused")
		Player p = (Player)e.getEntity();
	        e.setCancelled(true); 
	    } 
	  }
	@EventHandler
	  public void onFall(PlayerMoveEvent e) {
	    if (e.getFrom().getY() < 0) {
	      Vector velocity = e.getPlayer().getVelocity();
	      e.setCancelled(true);     
	      e.getPlayer().teleport(e.getFrom().add(0.0D, 300.0D, 0.0D));
	      e.getPlayer().setVelocity(velocity);
	     
	    }
	 }   
}

	  


	
	
