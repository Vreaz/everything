package me.vreaz.inventories;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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
import org.bukkit.util.Vector;

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
			if(e.getItem() == null){		
				return;
				
			}else if(!e.getItem().hasItemMeta()) {		
				return;
			}
			{
			if(e.getItem().getItemMeta().getDisplayName().equals("§cNavigation")) {
				
				Inventory inv = Bukkit.createInventory(null, 5*9, "§d§lNavigation");
				
				ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
				ItemMeta placeholderMeta = placeholder.getItemMeta();
				placeholderMeta.setDisplayName(" ");
				placeholder.setItemMeta(placeholderMeta);
				
				ItemStack placeholder2 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)15);
				ItemMeta placeholderMeta2 = placeholder2.getItemMeta();
				placeholderMeta2.setDisplayName(" ");
				placeholder2.setItemMeta(placeholderMeta2);
				
				ItemStack head = new ItemStack(Material.SKULL_ITEM,1,(short)3);
				SkullMeta skull = (SkullMeta) head.getItemMeta();
				skull.setDisplayName("§cProfil");
				ArrayList<String> headLore = new ArrayList<String>();
				headLore.add("Custom head");
				skull.setLore(headLore);
				skull.setOwner(p.getName());
				head.setItemMeta(skull);
				
				ItemStack spawn = new ItemStack(Material.SLIME_BALL);
				ItemMeta spawnMeta = spawn.getItemMeta();
				spawnMeta.setDisplayName("§7» §a§lSpawn §7«");
				ArrayList<String> spawnLore = new ArrayList<String>();
				spawnLore.add("§7§oRechtsklick zum teleportieren.");
				spawnMeta.setLore(spawnLore);
				spawn.setItemMeta(spawnMeta);
				
				ItemStack bed = new ItemStack(Material.BED);
				ItemMeta bedMeta = bed.getItemMeta();
				bedMeta.setDisplayName("§7» §fBed§cWars §7«");
				ArrayList<String> bedLore = new ArrayList<String>();
				bedLore.add("§7§oRechtsklick zum teleportieren.");
				bedMeta.setLore(bedLore);
				bed.setItemMeta(bedMeta);
				
				ItemStack ttt = new ItemStack(Material.STICK);
				ItemMeta tttmeta = bed.getItemMeta();
				tttmeta.setDisplayName("§7» §cTTT §7«");
				ArrayList<String> tttlore = new ArrayList<String>();
				tttlore.add("§7§oRechtsklick zum teleportieren.");
				tttmeta.setLore(tttlore);
				ttt.setItemMeta(tttmeta);
				
				ItemStack tnt = new ItemStack(Material.TNT);
				ItemMeta tntMeta = tnt.getItemMeta();
				tntMeta.setDisplayName("§7» §4TNT§7-§cRun §7«");
				ArrayList<String> tntlore = new ArrayList<String>();
				tntlore.add("§7§oRechtsklick zum teleportieren.");
				tntMeta.setLore(tntlore);
				tnt.setItemMeta(tntMeta);
				
				ItemStack sword = new ItemStack(Material.IRON_SWORD);
				ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName("§7» §bSurvival§3Games §7«");
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
						inv.setItem(18, placeholder2);
						inv.setItem(26, placeholder2);
						
					}
			
			}, 1);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						inv.setItem(9, placeholder2);
						inv.setItem(27, placeholder2);
						inv.setItem(17, placeholder2);
						inv.setItem(35, placeholder2);
						
					}
			
			}, 2);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						inv.setItem(16, placeholder2);
						inv.setItem(34, placeholder2);
						inv.setItem(10, placeholder2);
						inv.setItem(28, placeholder2);
						
					}
			
			}, 3);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						inv.setItem(1, placeholder2);
						inv.setItem(37, placeholder2);
						inv.setItem(43, placeholder2);
						inv.setItem(7, placeholder2);
						
					}
			
			}, 4);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						inv.setItem(2, placeholder2);
						inv.setItem(6, placeholder2);
						inv.setItem(38, placeholder2);
						inv.setItem(42, placeholder2);
						
					}
			
			}, 5);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						inv.setItem(3, placeholder);
						inv.setItem(5, placeholder);
						inv.setItem(39, placeholder);
						inv.setItem(41, placeholder);
						
					}
			
			}, 6);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						inv.setItem(0, placeholder);
						inv.setItem(8, placeholder);
						inv.setItem(36, placeholder);
						inv.setItem(44, placeholder);
						
					}
			
			}, 7);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
						inv.setItem(22, spawn);
						
					}
			
			}, 9);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
						inv.setItem(20, bed);
						
					}
			
			}, 12);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
						inv.setItem(24, sword);
						
					}
			
			}, 14);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
						
						inv.setItem(40, ttt);
						
					}
			
			}, 16);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {
						p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
						inv.setItem(4, tnt);
						
					}
			
			}, 18);
        }
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
		if(e.getInventory().getName().equals("§d§lNavigation")) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7» §fBed§cWars §7«")) {
				Player p = (Player)e.getWhoClicked();
				p.setVelocity(new Vector(0, 0.5, 0));
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 1f);
				Location xyz = new Location(p.getWorld(),88,151,27, (float)-97.3 , (float) -1.6);
				p.teleport(xyz);
						
				
			}if(e.getInventory().getName().equals("§d§lNavigation")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7» §a§lSpawn §7«")) {
					Player p = (Player)e.getWhoClicked();
					p.setVelocity(new Vector(0, 0.5, 0));
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 1f);
					Location xyz = new Location(p.getWorld(),63.506, 157.0000, 65.514, (float)-179.9 , (float) 2.8);
					p.teleport(xyz);
							
					
				}
			}if(e.getInventory().getName().equals("§d§lNavigation")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7» §cTTT §7«")) {
					Player p = (Player)e.getWhoClicked();
					p.setVelocity(new Vector(0, 0.5, 0));
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 1f);
					Location xyz = new Location(p.getWorld(),55,149,8, (float)-171.6 , (float) -2.7);
					p.teleport(xyz);
					
							
					
				}
			}if(e.getInventory().getName().equals("§d§lNavigation")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7» §bSurvival§3Games §7«")) {
					Player p = (Player)e.getWhoClicked();
					p.setVelocity(new Vector(0, 0.5, 0));
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 1f);
					Location xyz = new Location(p.getWorld(),28.615,152,51.897, (float)94.2 , (float) -6.8);
					p.teleport(xyz);
							
					
				}
			}if(e.getInventory().getName().equals("§d§lNavigation")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7» §4TNT§7-§cRun §7«")) {
					Player p = (Player)e.getWhoClicked();
					p.setVelocity(new Vector(0, 0.5, 0));
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 1f);
					Location xyz = new Location(p.getWorld(),37,154,36, (float)93.8 , (float) -4.0);
					p.teleport(xyz);
					
							
					
				}
			}
		}
		
	}

}
