package me.vreaz.inventories;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.NeonnBukkit.CoinsAPI.Main;

public class Navigation implements Listener{
	
	@EventHandler
	public void navigation(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		ItemStack navigation = new ItemStack(Material.COMPASS);
		ItemMeta navigationMeta = navigation.getItemMeta();
		ArrayList <String> navigationLore = new ArrayList<>();
		navigationLore.add("§7Rechtsklick um die Navigation zu öffnen");
		navigationMeta.setDisplayName("§cNavigation");
		navigationMeta.setLore(navigationLore);
		navigation.setItemMeta(navigationMeta);
		
			
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getItem().getItemMeta().getDisplayName().equals("§cNavigation")) {
				
				Inventory inv = Bukkit.createInventory(null, 3*9, "§d§lNavigation");
				
				ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
				ItemMeta placeholderMeta = placeholder.getItemMeta();
				placeholderMeta.setDisplayName(" ");
				placeholder.setItemMeta(placeholderMeta);
				
				ItemStack head = new ItemStack(Material.SKULL_ITEM,1,(short)3);
				SkullMeta skull = (SkullMeta) head.getItemMeta();
				skull.setDisplayName("§cProfil");
				ArrayList<String> headLore = new ArrayList<String>();
				headLore.add("Custom head");
				skull.setLore(headLore);
				skull.setOwner(p.getName());
				head.setItemMeta(skull);
				
				ItemStack bed = new ItemStack(Material.BED);
				ItemMeta bedMeta = bed.getItemMeta();
				bedMeta.setDisplayName("§cBedWars");
				bed.setItemMeta(bedMeta);
				
				ItemStack tnt = new ItemStack(Material.TNT);
				ItemMeta tntMeta = tnt.getItemMeta();
				tntMeta.setDisplayName("§cTNT-Run");
				tnt.setItemMeta(tntMeta);
				
				ItemStack sword = new ItemStack(Material.IRON_SWORD);
				ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName("§cSurvivalGames");
				sword.setItemMeta(swordMeta);
				
				ItemStack close = new ItemStack(Material.BARRIER);
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
						inv.setItem(12, bed);
					}	            	
	            }, 4);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 1f);
			            
			            inv.setItem(13, tnt);
					}	            	
	            }, 7);
				 Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
						@Override
						public void run() {			
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 1f);
				            
				            inv.setItem(14, sword);
						}	            	
		           }, 11);
				 Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
						@Override
						public void run() {			
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 1f);
				            
				            inv.setItem(18, head);
						}	            	
		           }, 14);
				 Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
						@Override
						public void run() {			
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 1f, 1f);
				            
				            inv.setItem(26, close);
						}	            	
		           }, 17);
				
			}
			
		}
		
	
		
	}
	@EventHandler 	public void onClick(InventoryClickEvent e) {	
		
		//Cancel console error when clicking outside the inventory "§d§lNavigation" or clicking your own inventoryslots
		if(e.getCurrentItem() == null){			
			return;			
		}else if(!e.getCurrentItem().hasItemMeta()) {
			return;
		}
		
		//When you try to get item out of the inventory "§d§lNavigation" cancel this action
			if(e.getInventory().getName().equals("§d§lNavigation")) { 
				   e.setCancelled(true);	
			}
	}

}
