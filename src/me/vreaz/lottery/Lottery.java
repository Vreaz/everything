package me.vreaz.lottery;

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

import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;
import me.vreaz.main.Main;
import me.vreaz.manager.ConfigManager;





public class Lottery implements Listener{
	
	
	
	
	@EventHandler
	public void lotteryRightclick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if((e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK) && (e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.ENDER_CHEST)) {
	            e.setCancelled(true);
	            
	            Inventory inv = Bukkit.createInventory(null, 5*9, "§d§lLose");

	            
	            
	            ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE,1, (short)7);
	            ItemMeta placeholder01 = placeholder.getItemMeta();
	            placeholder01.setDisplayName(" ");
	            placeholder.setItemMeta(placeholder01);
	           
	            
	            ItemStack ticket = new ItemStack(Material.PAPER);
	            ItemMeta ticket01 = ticket.getItemMeta();
	            ticket01.setDisplayName("§7Deine Lose");
	            ArrayList<String> ticketlore = new ArrayList<>();
	            int deinelose = ConfigManager.get().getInt(p.getName() + ".lose");
	            
	            ticketlore.add("§8➥ §e" + deinelose);
	            ticket01.setLore(ticketlore);
	            ticket.setItemMeta(ticket01);
	            
	            ItemStack air = new ItemStack(Material.AIR);
	            ItemMeta airmeta = air.getItemMeta();
	            air.setItemMeta(airmeta);
	            
	            ItemStack losekaufen = new ItemStack(Material.CHEST);
	            ItemMeta losekaufenmeta = losekaufen.getItemMeta();
	            losekaufenmeta.setDisplayName("§dLose kaufen");
	            losekaufen.setItemMeta(losekaufenmeta);
	            
	            ItemStack einlösen = new ItemStack(Material.NETHER_STAR);
	            ItemMeta einlösenmeta = einlösen.getItemMeta();
	            einlösenmeta.setDisplayName("§eEinlösen");
	            einlösen.setItemMeta(einlösenmeta);
	           	            
	            
	           
	            
	            
	            
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
			            	 inv.setItem(20, air);
			            	 inv.setItem(22, air);
			            	 inv.setItem(24, air);
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
	            }, 5);
	            
	            
	            
	            
	            
	            Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
						inv.setItem(20, ticket);
					}	            	
	            }, 8);
	            Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
			            
			            inv.setItem(22, einlösen);
					}	            	
	            }, 11);
	            Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
			            
			            inv.setItem(24, losekaufen);
					}	            	
	            }, 14);
	            
		}

		}


	@EventHandler 
	public void losekaufen(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();			
		Inventory shop = Bukkit.createInventory(null, 9, "§a§lLose kaufen");			
		if(e.getCurrentItem() == null){
		
			return;
			
		}else if(!e.getCurrentItem().hasItemMeta()) {
			return;
		}
		{
			
			
			if(e.getInventory().getName().equals("§d§lLose")) {
				if(e.getInventory().getName().equals("Reparatur")) {
				e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§dLose kaufen" )) {
				e.setCancelled(true);


				
					
				ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE,1, (short)7);
	            ItemMeta placeholder01 = placeholder.getItemMeta();
	            placeholder01.setDisplayName(" ");
	            placeholder.setItemMeta(placeholder01);
	            
				ItemStack los1 = new ItemStack(Material.PAPER);
	            ItemMeta losmeta1 = los1.getItemMeta();
	            losmeta1.setDisplayName("§e1x §7Los kaufen");
	            ArrayList<String> los1lore = new ArrayList<>();
	            los1lore.add("§7Preis: §61000 Coins");
	            losmeta1.setLore(los1lore);
	            los1.setItemMeta(losmeta1);
	            
	            ItemStack los2 = new ItemStack(Material.PAPER, 3);
	            ItemMeta losmeta2 = los2.getItemMeta();
	            losmeta2.setDisplayName("§e3x §7Lose kaufen");
	            ArrayList<String> los2lore = new ArrayList<>();
	            los2lore.add("§7Preis: §63000 Coins");
	            losmeta2.setLore(los2lore);
	            los2.setItemMeta(losmeta2);
	            
	            ItemStack los3 = new ItemStack(Material.PAPER, 5);
	            ItemMeta losmeta3 = los3.getItemMeta();
	            losmeta3.setDisplayName("§e5x §7Lose kaufen");
	            ArrayList<String> los3lore = new ArrayList<>();
	            los3lore.add("§7Preis: §65000 Coins");
	            losmeta3.setLore(los3lore);
	            los3.setItemMeta(losmeta3);
	            
	            ItemStack air = new ItemStack(Material.AIR);
	            ItemMeta airmeta = air.getItemMeta();
	            air.setItemMeta(airmeta);	           
				
	            for (int counter0 = 0; counter0 <= 8; counter0++) {
	            	shop.setItem(counter0, placeholder);
	            }
	            shop.setItem(2, air);
	            shop.setItem(4, air);
	            shop.setItem(6, air);
	            
				p.openInventory(shop);
				
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
			            
			            shop.setItem(2, los1);
					}	            	
	            }, 3);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
			            
			            shop.setItem(4, los2);
					}	            	
	            }, 6);
				Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
					@Override
					public void run() {			
						p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
			            
			            shop.setItem(6, los3);
					}	            	
	            }, 9);
				
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
					
					
					
					
		}
				}
			}
		}
	
	}		
					
					

					@EventHandler 
					public void onClick(InventoryClickEvent e) {	
						Player p = (Player) e.getWhoClicked();
						if(e.getCurrentItem() == null){
							
							return;
							
						}else if(!e.getCurrentItem().hasItemMeta()) {
							return;
						}

							
							if(e.getInventory().getName().equals("§d§lLose")) {
								   e.setCancelled(true);		
						}if(e.getInventory().getName().equals("§5§lLotterie")) {
							e.setCancelled(true);
						}if(e.getInventory().getName().equals("§a§lLose kaufen")) {
							e.setCancelled(true);
						} if(e.getInventory().getName().equals("§5§lLotterie")) {
							if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cZurück ✘")) {
								p.closeInventory();
								
							
					
						} 
						}
						
									}
					@EventHandler 
					public void loseClick(InventoryClickEvent e) {								
							Player p = (Player) e.getWhoClicked();		

							if(e.getCurrentItem() == null){
								
								return;
								
							}else if(!e.getCurrentItem().hasItemMeta()) {
								return;
							}
							if(e.getInventory().getName().equals("§a§lLose kaufen")) {				
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§e1x §7Los kaufen")) {
									e.setCancelled(true);
									if(CoinsAPI.getCoins(p.getUniqueId().toString()) >= 1000){							
									CoinsAPI.removeCoins(p.getUniqueId().toString(), 1000);
									
									int Lose = ConfigManager.get().getInt(p.getName() + ".lose");
									int add = 1;
									int auszahlung = Lose + add;
									
									ConfigManager.get().set(p.getName() + ".lose", auszahlung);
									ConfigManager.save();
									p.sendMessage("§3§lDG §7» Du hast §a1x Los gekauft!");
									p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
									
									} else {
										p.sendMessage("§3§lDG §7» §cDu hast nicht genügend Coins!");
										p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1f, 1f);
									}
									
								}
							
							
            }
									
							}
							
							
					@EventHandler 
					public void loseClick2(InventoryClickEvent e) {								
							Player p = (Player) e.getWhoClicked();			
							if(e.getCurrentItem() == null){
								
								return;
								
							}else if(!e.getCurrentItem().hasItemMeta()) {
								return;
							}
							if(e.getInventory().getName().equals("§a§lLose kaufen")) {				
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§e3x §7Lose kaufen")) {
									e.setCancelled(true);
									if(CoinsAPI.getCoins(p.getUniqueId().toString()) >= 3000){							
									CoinsAPI.removeCoins(p.getUniqueId().toString(), 3000);
									
									int Lose = ConfigManager.get().getInt(p.getName() + ".lose");
									int add = 3;
									int auszahlung = Lose + add;
									
									ConfigManager.get().set(p.getName() + ".lose", auszahlung);
									ConfigManager.save();
									p.sendMessage("§3§lDG §7» Du hast §a3x Los gekauft!");
									p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
									
									} else {
										p.sendMessage("§3§lDG §7» §cDu hast nicht genügend Coins!");
										p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1f, 1f);
									}
								}
							
					
            }
									
		}
					@EventHandler 
					public void loseClick3(InventoryClickEvent e) {								
							Player p = (Player) e.getWhoClicked();		
							if(e.getCurrentItem() == null){
								
								return;
								
							}else if(!e.getCurrentItem().hasItemMeta()) {
								return;
							}
							if(e.getInventory().getName().equals("§a§lLose kaufen")) {				
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§e5x §7Lose kaufen")) {
									e.setCancelled(true);
									if(CoinsAPI.getCoins(p.getUniqueId().toString()) >= 5000){							
									CoinsAPI.removeCoins(p.getUniqueId().toString(), 5000);
									
									int Lose = ConfigManager.get().getInt(p.getName() + ".lose");
									int add = 5;
									int auszahlung = Lose + add;
									
									ConfigManager.get().set(p.getName() + ".lose", auszahlung);
									ConfigManager.save();
									p.sendMessage("§3§lDG §7» Du hast §a5x Los gekauft!");
									p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
									
									} else {
										p.sendMessage("§3§lDG §7» §cDu hast nicht genügend Coins!");
										p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1f, 1f);
									}
								}
							
					
            }
									
		}
}
