package me.vreaz.inventories;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.NeonnBukkit.CoinsAPI.Main;

public class Navigation implements Listener{
	
	@EventHandler
	public ItemStack navigation(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		ItemStack navigation = new ItemStack(Material.COMPASS,1,(short)1);
		ItemMeta navigationMeta = navigation.getItemMeta();
		ArrayList <String> navigationLore = new ArrayList<>();
		navigationLore.add("§7Rechtsklick um die Navigation zu öffnen");
		navigationMeta.setDisplayName("§cNavigation");
		navigationMeta.setLore(navigationLore);
		navigation.setItemMeta(navigationMeta);
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getItem().getItemMeta().getDisplayName().equals("§cNavigation")) {
				e.setCancelled(true);
				
				Inventory inv = Bukkit.createInventory(null, 3*9, "§d§lNavigation");
				
				ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
				ItemMeta placeholderMeta = placeholder.getItemMeta();
				placeholderMeta.setDisplayName("");
				placeholder.setItemMeta(placeholderMeta);
				
				ItemStack head = new ItemStack(Material.SKULL_ITEM,1,(short)3);
				SkullMeta skull = (SkullMeta) head.getItemMeta();
				skull.setDisplayName("§cProfil");
				ArrayList<String> headLore = new ArrayList<String>();
				headLore.add("Custom head");
				skull.setLore(headLore);
				skull.setOwner(p.getName());
				head.setItemMeta(skull);
				
				ItemStack bed = new ItemStack(Material.BED,1,(short)0);
				ItemMeta bedMeta = bed.getItemMeta();
				bedMeta.setDisplayName("§cBedWars");
				bed.setItemMeta(bedMeta);
				
				ItemStack tnt = new ItemStack(Material.TNT,1,(short)0);
				ItemMeta tntMeta = tnt.getItemMeta();
				tntMeta.setDisplayName("§cTNT-Run");
				tnt.setItemMeta(tntMeta);
				
				ItemStack sword = new ItemStack(Material.IRON_SWORD,1,(short)0);
				ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName("§cSurvivalGames");
				sword.setItemMeta(swordMeta);
				
				ItemStack close = new ItemStack(Material.BARRIER,1,(short)0);
				ItemMeta closeMeta = close.getItemMeta();
				closeMeta.setDisplayName("§cSchließen");
				close.setItemMeta(closeMeta);
				
				ItemStack air = new ItemStack(Material.AIR);
	            ItemMeta airmeta = air.getItemMeta();
	            air.setItemMeta(airmeta);
				
				p.openInventory(inv);
				
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						
						for (int counter0 = 0; counter0 <= 8; counter0++) {
							inv.setItem(counter0, placeholder);
						}
					}
				}, 1);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						for (int counter1 = 9; counter1 <= 17; counter1++) {
			            	inv.setItem(counter1, placeholder);
			            }
					}	            	
	            }, 2);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						for (int counter2 = 18; counter2 <= 26; counter2++) {
			            	inv.setItem(counter2, placeholder);
			            	 inv.setItem(12, air);
			            	 inv.setItem(13, air);
			            	 inv.setItem(14, air);
			            	 inv.setItem(18, air);
			            	 inv.setItem(26, air);
			            }
					}	            	
	            }, 3);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						for (int counter3 = 27; counter3 <= 35; counter3++) {
			            	inv.setItem(counter3, placeholder);
			            }
					}	            	
	            }, 4);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						for (int counter4 = 36; counter4 <= 44; counter4++) {
			            	inv.setItem(counter4, placeholder);
			            }
					}	            	
	            }, 7);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						inv.setItem(12, bed);
					}	            	
	            }, 11);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 1f);
			            
			            inv.setItem(13, tnt);
					}	            	
	            }, 13);
				 Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
						@Override
						public void run() {			
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 1f);
				            
				            inv.setItem(14, sword);
						}	            	
		           }, 15);
				 Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
						@Override
						public void run() {			
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 1f);
				            
				            inv.setItem(18, head);
						}	            	
		           }, 9);
				 Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
						@Override
						public void run() {			
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 1f);
				            
				            inv.setItem(26, close);
						}	            	
		           }, 17);
				
			}
		}
		return navigation;
		
	}

}
