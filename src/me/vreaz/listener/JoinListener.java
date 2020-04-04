package me.vreaz.listener;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
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

import me.vreaz.main.Main;
import me.vreaz.manager.ScoreboardLobby;

public class JoinListener implements Listener{
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		for (int x = 0; x < 50; x++) {
		p.sendMessage(" ");
		p.setMaxHealth(6);
		}
		new ScoreboardLobby().setScoreboard(p);
		
		TitleAPI.sendTitle(p, 20, 60, 15, "§3Willkommen auf", "§bDrainGang");
		
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
	@EventHandler
    public void onPickupItem(PlayerPickupItemEvent e) {
    	 if (e.getItem().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("coins1"))
    		        e.setCancelled(true); 
    		      if (e.getItem().getItemStack().getItemMeta().getDisplayName().startsWith("coins1")) {
    		        e.setCancelled(true);
}

}

	
	    @EventHandler
	    public void joinAnimation(PlayerJoinEvent e){
	        Player p = e.getPlayer();
	        Location loc = p.getLocation().add(0, 1.0, 0);
	       
	        
	        Vector direction = new Vector();
            direction.setX(45D);
            direction.setZ(45D);
            direction.setY(0.5D);
            
            Vector direction2 = new Vector();
            direction2.setX(90D);
            direction2.setZ(90D);
            direction2.setY(0.5D);
            
            Vector direction3 = new Vector();
            direction3.setX(135D);
            direction3.setZ(135D);
            direction3.setY(0.5D);
            
            Vector direction4 = new Vector();
            direction4.setX(180D);
            direction4.setZ(180D);
            direction4.setY(0.5D);
            
            Vector direction5 = new Vector();
            direction5.setX(225D);
            direction5.setZ(225D);
            direction5.setY(0.5D);
            
            Vector direction6 = new Vector();
            direction6.setX(270D);
            direction6.setZ(270D);
            direction6.setY(0.5D);
            
            Vector direction7 = new Vector();
            direction7.setX(315D);
            direction7.setZ(315D);
            direction7.setY(0.5D);
            
            Vector direction8 = new Vector();
            direction8.setX(360D);
            direction8.setZ(360D);
            direction8.setY(0.5D);
            
	        ItemStack item1 = new ItemStack(Material.GOLD_INGOT);
            ItemMeta item101 = item1.getItemMeta();
            item101.setDisplayName("coins1");
            item1.setItemMeta(item101);
            
            ItemStack item2 = new ItemStack(Material.GOLD_INGOT);
            ItemMeta item02 = item2.getItemMeta();
            item02.setDisplayName("coins2");
            item2.setItemMeta(item02);
            
            ItemStack item3 = new ItemStack(Material.GOLD_INGOT);
            ItemMeta item03 = item3.getItemMeta();
            item03.setDisplayName("coins3");
            item3.setItemMeta(item03);
            
            ItemStack item4 = new ItemStack(Material.GOLD_INGOT);
            ItemMeta item04 = item4.getItemMeta();
            item04.setDisplayName("coins4");
            item4.setItemMeta(item04);
            
            ItemStack item5 = new ItemStack(Material.GOLD_INGOT);
            ItemMeta item05 = item5.getItemMeta();
            item05.setDisplayName("coins5");
            item5.setItemMeta(item05);
            
            ItemStack item6 = new ItemStack(Material.GOLD_INGOT);
            ItemMeta item06 = item6.getItemMeta();
            item06.setDisplayName("coins6");
            item6.setItemMeta(item06);
            
            ItemStack item7 = new ItemStack(Material.GOLD_INGOT);
            ItemMeta item07 = item7.getItemMeta();
            item07.setDisplayName("coins7");
            item7.setItemMeta(item07);
            
            ItemStack item8 = new ItemStack(Material.GOLD_INGOT);
            ItemMeta item08 = item8.getItemMeta();
            item08.setDisplayName("coins8");
            item8.setItemMeta(item08);
            
	       
	       Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
   			@Override
   			public void run() {
   				Entity drop = loc.getWorld().dropItem(loc, item1);
   				drop.setVelocity(direction);
   			}	            	
           }, 1);
	       Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
   			@Override
   			public void run() {
   				Entity drop2 = loc.getWorld().dropItem(loc, item2);
   				drop2.setVelocity(direction2);
   			}	            	
           }, 2);
	       Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
	   			@Override
	   			public void run() {
	   				Entity drop3 = loc.getWorld().dropItem(loc, item3);
	   				drop3.setVelocity(direction3);
	   			}	            	
	           }, 3);
		       Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
	   			@Override
	   			public void run() {
	   				Entity drop4 = loc.getWorld().dropItem(loc, item4);
	   				drop4.setVelocity(direction4);
	   			}	            	
	           }, 4);
		       Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		   			@Override
		   			public void run() {
		   				Entity drop5 = loc.getWorld().dropItem(loc, item5);
		   				drop5.setVelocity(direction5);
		   			}	            	
		           }, 5);
			       Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		   			@Override
		   			public void run() {
		   				Entity drop6 = loc.getWorld().dropItem(loc, item6);
		   				drop6.setVelocity(direction6);
		   			}	            	
		           }, 6);
			       Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			   			@Override
			   			public void run() {
			   				Entity drop7 = loc.getWorld().dropItem(loc, item7);
			   				drop7.setVelocity(direction7);
			   			}	            	
			           }, 7);
				       Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			   			@Override
			   			public void run() {
			   				Entity drop8 = loc.getWorld().dropItem(loc, item8);
			   				drop8.setVelocity(direction8);
			   			}	            	
			           }, 8);
	       
	    		   
	    }
	    
	    
}

	  


	
	
