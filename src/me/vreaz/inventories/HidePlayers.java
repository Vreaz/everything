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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.inventivetalent.particle.ParticleEffect;

import me.vreaz.main.Main;
import me.vreaz.manager.ActionBar;
import me.vreaz.manager.ConfigManager;

public class HidePlayers implements Listener {
	
	@EventHandler
	public void hidePlayers(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack shownPlayers = new ItemStack(Material.INK_SACK,1,(short)5);
		ItemMeta shownPlayersMeta = shownPlayers.getItemMeta();		
		ArrayList <String> shownPlayersLore = new ArrayList<>();
		shownPlayersLore.add("§7Rechtsklick um alle Spieler zu verstecken");
		shownPlayersMeta.setDisplayName("§cSpieler verstecken");
		shownPlayersMeta.setLore(shownPlayersLore);
		shownPlayers.setItemMeta(shownPlayersMeta);
		
		ItemStack hiddenPlayers = new ItemStack(Material.INK_SACK,1,(short)7);
		ItemMeta hiddenPlayersMeta = hiddenPlayers.getItemMeta();		
		ArrayList <String> hiddenPlayersLore = new ArrayList<>();
		hiddenPlayersLore.add("§7Rechtsklick um alle Spieler anzuzeigen");
		hiddenPlayersMeta.setLore(hiddenPlayersLore);
		hiddenPlayersMeta.setDisplayName("§aSpieler anzeigen");
		hiddenPlayers.setItemMeta(hiddenPlayersMeta);
		
		ItemStack warten = new ItemStack(Material.BARRIER);
		ItemMeta warten01 = hiddenPlayers.getItemMeta();	
		ArrayList <String> wartenlore = new ArrayList<>();
		wartenlore.add("§7Cooldown Item");
		warten01.setLore(wartenlore);
		warten01.setDisplayName("§cBitte warte...");
		warten.setItemMeta(warten01);

			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getItem() == null){		
					return;
					
				}else if(!e.getItem().hasItemMeta()) {		
					return;
				}
				{
				if(e.getItem().getItemMeta().getDisplayName().equals("§cSpieler verstecken")) {
					
									
						for(Player all : Bukkit.getOnlinePlayers()) {	
							p.hidePlayer(all);
							p.getInventory().setItem(8, null);							
							p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 99999));
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
							ActionBar.sendActionBar(p.getPlayer(), "§7Du zeigst nun §ckeinen §7Spieler an!");
							ParticleEffect.LAVA.send(Bukkit.getOnlinePlayers(), all.getLocation(), 1, 1, 1, 0, 10);	
							p.getInventory().setItem(8, warten);
							ConfigManager.get().set(p.getName() + ".hideplayer", "versteckt");
							ConfigManager.save();
							Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
								@Override
								public void run() {			
									p.getInventory().setItem(8, hiddenPlayers);
						            
								}	            	
				            }, 100);
						}
					}
				}
				
					} else if(e.getItem() == null){		
						return;
						
					}else if(!e.getItem().hasItemMeta()) {		
						return;
					}
					{
						
						if(e.getItem().getItemMeta().getDisplayName().equals("§aSpieler anzeigen")) {

					
							for(Player all : Bukkit.getOnlinePlayers()) {
								p.showPlayer(all);
								p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 9999));
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
								ActionBar.sendActionBar(p.getPlayer(), "§7Du zeigst nun §aalle §7Spieler an!");
								ParticleEffect.LAVA.send(Bukkit.getOnlinePlayers(), all.getLocation(), 1, 1, 1, 0, 10);
								p.getInventory().setItem(8, warten);
								ConfigManager.get().set(p.getName() + ".hideplayer", "angezeigt");
								ConfigManager.save();
								Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {									
									@Override
									public void run() {			
										p.getInventory().setItem(8, shownPlayers);
							            
									}	            	
					            }, 100);
							
							}
							
							}
						
					}
					
					
				}
			}
			
	
					



