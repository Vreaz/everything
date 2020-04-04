package me.vreaz.lottery;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;
import me.vreaz.main.Main;
import me.vreaz.manager.ConfigManager;

public class LotteryPlay implements Listener{
	@EventHandler 
	public void einlösen(InventoryClickEvent e) {	
		Player p = (Player) e.getWhoClicked();
		Inventory coinsneu = Bukkit.createInventory(null, 6*9, "§5§lLotterie");
		
		
		
		if(e.getCurrentItem() == null){
			
			return;
			
		}else if(!e.getCurrentItem().hasItemMeta()) {
			return;
		}
		if(e.getInventory().getName().equals("§d§lLose")) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§eEinlösen")) {
					
				int Lose = ConfigManager.get().getInt(p.getName()+ ".lose");
				if(Lose >= 1) {
					int loseafter = Lose - 1;
					
				ConfigManager.get().set(p.getName() + ".lose", loseafter);
				
	p.closeInventory();
	
	
	
	ItemStack placeholder = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
    ItemMeta placeholder01 = placeholder.getItemMeta();
    placeholder01.setDisplayName(" ");
    placeholder.setItemMeta(placeholder01);
    
    //Lila
    ItemStack side1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)2);
    ItemMeta side01 = side1.getItemMeta();
    side01.setDisplayName(" ");
    side1.setItemMeta(side01);
    
    //orange
    ItemStack side2 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)1);
    ItemMeta side02 = side2.getItemMeta();
    side02.setDisplayName(" ");
    side2.setItemMeta(side02);
    //Hellblau
    ItemStack side3 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)9);
    ItemMeta side03 = side3.getItemMeta();
    side03.setDisplayName(" ");
    side3.setItemMeta(side03);
    //yellow
    ItemStack side4 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)4);
    ItemMeta side04 = side4.getItemMeta();
    side04.setDisplayName(" ");
    side4.setItemMeta(side04);
    //grün
    ItemStack side5 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)5);
    ItemMeta side05 = side5.getItemMeta();
    side05.setDisplayName(" ");
    side5.setItemMeta(side05);
    //pink
    ItemStack side6 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)6);
    ItemMeta side06 = side6.getItemMeta();
    side06.setDisplayName(" ");
    side6.setItemMeta(side06);
    
    ItemStack deingewinn1 = new ItemStack(Material.HOPPER);
    ItemMeta deingewinn01 = deingewinn1.getItemMeta();
    deingewinn01.setDisplayName("§7§lDein Gewinn");
    deingewinn1.setItemMeta(deingewinn01);
    
    ItemStack back1 = new ItemStack(Material.REDSTONE_BLOCK);
    ItemMeta back01 = back1.getItemMeta();
    back01.setDisplayName("§cZurück ✘");
    back1.setItemMeta(back01);
    
    ItemStack again1 = new ItemStack(Material.PAPER);
    ItemMeta again01 = again1.getItemMeta();
    again01.setDisplayName("§aNochmal spielen");
    again01.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
    again01.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    ArrayList<String> againlore1 = new ArrayList<>();
    
    int deinelose = ConfigManager.get().getInt(p.getName() + ".lose");
    
    againlore1.add("§7Du hast noch");
    againlore1.add("§8➥ §e"+ deinelose +" §7Lose");
    again01.setLore(againlore1);
    again1.setItemMeta(again01);
    
    ItemStack normal1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)8);
    ItemMeta normal01 = normal1.getItemMeta();
    normal01.setDisplayName("§f§lGEWÖHNLICH");
    normal01.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
    normal01.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    ArrayList<String> normallore = new ArrayList<>();
    normallore.add("§8100-1250 Coins");
    normallore.add("§7Chance: §c§o90%");
    normal01.setLore(normallore);
    normal1.setItemMeta(normal01);
    
    ItemStack selten2 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)11);
    ItemMeta selten02 = selten2.getItemMeta();
    selten02.setDisplayName("§9§lSELTEN");
    selten02.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
    selten02.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    ArrayList<String> seltenlore2 = new ArrayList<>();
    seltenlore2.add("§81250-12500 Coins");
    seltenlore2.add("§7Chance: §c§o10%");
    selten02.setLore(seltenlore2);
    selten2.setItemMeta(selten02);
    
    ItemStack legy3 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)1);
    ItemMeta legy03 = legy3.getItemMeta();
    legy03.setDisplayName("§e§kO§6§lLEGENDÄR§e§kO");
    legy03.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
    legy03.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    ArrayList<String> legylore3 = new ArrayList<>();
    legylore3.add("§812500-50000 Coins");
    legylore3.add("§7Chance: §c§o1%");
    legy03.setLore(legylore3);
    legy3.setItemMeta(legy03);
    

    
    
    Random r = new Random();
	
	int ergebnis = r.nextInt(100) + 1;
	
	int lowreward01 = 100;
	int highreward01 = 1250;
	int coinsreward01 = r.nextInt(highreward01-lowreward01) + lowreward01;
	
	int lowreward02 = 1250;
	int highreward02 = 12500;
	int coinsreward02 = r.nextInt(highreward02-lowreward02) + lowreward02;
	
	int lowreward03 = 12500;
	int highreward03 = 50000;
	int coinsreward03 = r.nextInt(highreward03-lowreward03) + lowreward03;
    
	ItemStack reward1 = new ItemStack(Material.GOLD_NUGGET);
    ItemMeta reward01 = reward1.getItemMeta();
    reward01.setDisplayName("§7➥§e "+ coinsreward01+ " §6Coins");
    reward01.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
    reward01.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    ArrayList<String> rewardlore = new ArrayList<>();
    rewardlore.add("§7§lSTUFE §B§lI");
    rewardlore.add("§8100-1250 Coins");
    rewardlore.add("§7Chance: §c§o90%");
    reward01.setLore(rewardlore);
    reward1.setItemMeta(reward01);
    
    ItemStack reward2 = new ItemStack(Material.GOLD_INGOT);
    ItemMeta reward02 = reward1.getItemMeta();
    reward02.setDisplayName("§7➥§e "+ coinsreward02+ " §6Coins");
    reward02.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
    reward02.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    ArrayList<String> rewardlore2 = new ArrayList<>();
    rewardlore2.add("§7§lSTUFE §B§lII");
    rewardlore2.add("§81250-12500 Coins");
    rewardlore2.add("§7Chance: §c§o10%");
    reward02.setLore(rewardlore2);
    reward2.setItemMeta(reward02);
    
    ItemStack reward3 = new ItemStack(Material.GOLD_BLOCK);
    ItemMeta reward03 = reward1.getItemMeta();
    reward03.setDisplayName("§7➥§e "+ coinsreward03 + " §6Coins");
    reward03.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
    reward03.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    ArrayList<String> rewardlore3 = new ArrayList<>();
    rewardlore3.add("§7§lSTUFE §B§lIII");
    rewardlore3.add("§812500-50000 Coins");
    rewardlore3.add("§7Chance: §c§o1%");
    reward03.setLore(rewardlore3);
    reward3.setItemMeta(reward03);
    
    

    for (int counter = 0; counter <= 53; counter++) {
    	coinsneu.setItem(counter, placeholder);
    }   
    
    coinsneu.setItem(22, deingewinn1);
    
    p.openInventory(coinsneu);
    
    //29,30,31,32,33
    
    int a = 29;
    int s = 30;
    int d = 31;
    int f = 32;
    int g = 33;
    
    
    int spingewöhnlich = r.nextInt(3)+ 1;
	
	
    if(ergebnis < 90) {
    	if(spingewöhnlich < 2) {
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {			
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.529732F);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(32, selten2);
				coinsneu.setItem(29, selten2);
				
			}	            	
        }, 1);

    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {	
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.594604F);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(33, selten2);
				coinsneu.setItem(30, selten2);
				
			}	            	
        }, 3);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.667420F);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(29, selten2);
				coinsneu.setItem(31, selten2);
				
			}	            	
        }, 6);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.707107F);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(30, selten2);
				coinsneu.setItem(32, selten2);
				
			}	            	
        }, 10);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.793701F);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(31, selten2);
				coinsneu.setItem(33, selten2);
				
			}	            	
        }, 15);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.890899F);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(32, selten2);
				coinsneu.setItem(29, selten2);
				
			}	            	
        }, 20);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.943874F);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(33, selten2);
				coinsneu.setItem(30, selten2);
				
			}	            	
        }, 25);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.059463F);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(29, selten2);
				coinsneu.setItem(31, selten2);
				
			}	            	
        }, 30);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.189207F);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(30, selten2);
				coinsneu.setItem(32, selten2);
				
			}	            	
        }, 35);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.334840F);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(31, selten2);
				coinsneu.setItem(33, selten2);
				
			}	            	
        }, 40);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.414214F);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(32, selten2);
				coinsneu.setItem(29, selten2);
				
			}	            	
        }, 50);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.587401F);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(33, selten2);
				coinsneu.setItem(30, selten2);
				
			}	            	
        }, 70);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.781797F);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(29, selten2);
				coinsneu.setItem(31, selten2);
				
			}	            	
        }, 85);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.887749F);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(30, selten2);
				coinsneu.setItem(32, selten2);
				
			}	            	
        }, 105);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				
				coinsneu.setItem(4, normal1);
				coinsneu.setItem(13, normal1);
				coinsneu.setItem(40, normal1);
				coinsneu.setItem(49, normal1);
				
				
				coinsneu.setItem(31, reward1);
				coinsneu.setItem(32, placeholder);
				coinsneu.setItem(33, placeholder);
				coinsneu.setItem(29, placeholder);
				coinsneu.setItem(30, placeholder);
				coinsneu.setItem(52, back1);
				coinsneu.setItem(46, again1);
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1f, 1f);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
				
				p.sendMessage("§3§lDG §7» §7Du hast §e"+ coinsreward01 +" §6Coins§7 gewonnen!");
				CoinsAPI.addCoins(p.getUniqueId().toString(), coinsreward01);
			}	            	
        }, 126);
    	
    	
    	
    	
    	
    	
    	
    	} else if (spingewöhnlich <3){
    		
    		Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {			
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.529732F);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(a, normal1);
    				
    			}	            	
            }, 1);

        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {	
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.594604F);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(s, normal1);
    				
    			}	            	
            }, 3);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.667420F);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(d, normal1);
    				
    			}	            	
            }, 6);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.707107F);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(f, normal1);
    				
    			}	            	
            }, 10);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.793701F);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(g, normal1);
    				
    			}	            	
            }, 15);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.890899F);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(a, normal1);
    				
    			}	            	
            }, 20);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.943874F);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(s, normal1);
    				
    			}	            	
            }, 25);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.059463F);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(d, normal1);
    				
    			}	            	
            }, 30);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.189207F);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(f, normal1);
    				
    			}	            	
            }, 35);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.334840F);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(g, normal1);
    				
    			}	            	
            }, 40);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.414214F);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(a, normal1);
    				
    			}	            	
            }, 50);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.587401F);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(s, normal1);
    				
    			}	            	
            }, 70);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.781797F);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(d, normal1);
    				
    			}	            	
            }, 85);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.887749F);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(f, normal1);
    				
    			}	            	
            }, 105);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				
    				coinsneu.setItem(4, normal1);
    				coinsneu.setItem(13, normal1);
    				coinsneu.setItem(40, normal1);
    				coinsneu.setItem(49, normal1);
    				
    				
    				coinsneu.setItem(31, reward1);
    				coinsneu.setItem(32, placeholder);
    				coinsneu.setItem(33, placeholder);
    				coinsneu.setItem(29, placeholder);
    				coinsneu.setItem(30, placeholder);
    				coinsneu.setItem(52, back1);
    				coinsneu.setItem(46, again1);
    				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1f, 1f);
    				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
    				
    				p.sendMessage("§3§lDG §7» §7Du hast §e"+ coinsreward01 +" §6Coins§7 gewonnen!");
    				CoinsAPI.addCoins(p.getUniqueId().toString(), coinsreward01);
    			}	            	
            }, 126);
    		
    	} else {
    		Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {			
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.529732F);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(a, legy3);
    				
    			}	            	
            }, 1);

        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {	
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.594604F);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(s, legy3);
    				
    			}	            	
            }, 3);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.667420F);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(d, legy3);
    				
    			}	            	
            }, 6);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.707107F);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(f, legy3);
    				
    			}	            	
            }, 10);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.793701F);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(g, legy3);
    				
    			}	            	
            }, 15);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.890899F);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(a, legy3);
    				
    			}	            	
            }, 20);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.943874F);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(s, legy3);
    				
    			}	            	
            }, 25);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.059463F);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(d, legy3);
    				
    			}	            	
            }, 30);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.189207F);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(f, legy3);
    				
    			}	            	
            }, 35);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.334840F);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(g, legy3);
    				
    			}	            	
            }, 40);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.414214F);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(a, legy3);
    				
    			}	            	
            }, 50);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.587401F);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(s, legy3);
    				
    			}	            	
            }, 70);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.781797F);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(d, legy3);
    				
    			}	            	
            }, 85);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.887749F);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(f, legy3);
    				
    			}	            	
            }, 105);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				
    				coinsneu.setItem(4, normal1);
    				coinsneu.setItem(13, normal1);
    				coinsneu.setItem(40, normal1);
    				coinsneu.setItem(49, normal1);
    				
    				
    				coinsneu.setItem(31, reward1);
    				coinsneu.setItem(32, placeholder);
    				coinsneu.setItem(33, placeholder);
    				coinsneu.setItem(29, placeholder);
    				coinsneu.setItem(30, placeholder);
    				coinsneu.setItem(52, back1);
    				coinsneu.setItem(46, again1);
    				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1f, 1f);
    				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
    				
    				p.sendMessage("§3§lDG §7» §7Du hast §e"+ coinsreward01 +" §6Coins§7 gewonnen!");
    				CoinsAPI.addCoins(p.getUniqueId().toString(), coinsreward01);
    			}	            	
            }, 126);
    	}
    	
    	
    	
    	///////////////////////////////////////////////////////
    	///   REWARD 3
    	///
    	//////////////////////////////////////////////////////
    	
    	
    	
    	
    	
    	
    }else if (ergebnis < 91){
    	
    	int spinlegendary = r.nextInt(3)+ 1;
    	if (spinlegendary <2) {
    		
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(32, selten2);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(30, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.529732F);
			}	            	
        }, 1);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(33, selten2);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(31, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.594604F);
			}	            	
        }, 3);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(29, selten2);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(32, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.667420F);
			}	            	
        }, 6);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(30, selten2);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(33, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.707107F);
			}	            	
        }, 10);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(31, selten2);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(29, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.793701F);
			}	            	
        }, 15);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(32, selten2);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(30, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.890899F);
			}	            	
        }, 20);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(33, selten2);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(31, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.943874F);
			}	            	
        }, 25);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(29, selten2);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(32, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.059463F);
			}	            	
        }, 30);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(30, selten2);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(33, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.189207F);
			}	            	
        }, 35);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(31, selten2);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(29, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.334840F);
			}	            	
        }, 40);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(32, selten2);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(30, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.414214F);
			}	            	
        }, 50);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(33, selten2);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(31, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.587401F);
			}	            	
        }, 70);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(29, selten2);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(32, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.781797F);
			}	            	
        }, 85);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(30, selten2);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(33, selten2);
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.887749F);
			}	            	
        }, 105);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(4, legy3);
				coinsneu.setItem(13, legy3);
				coinsneu.setItem(40, legy3);
				coinsneu.setItem(49, legy3);
				
				
				coinsneu.setItem(31, reward3);
				coinsneu.setItem(32, placeholder);
				coinsneu.setItem(33, placeholder);
				coinsneu.setItem(29, placeholder);
				coinsneu.setItem(30, placeholder);
				coinsneu.setItem(52, back1);
				coinsneu.setItem(46, again1);
				Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
		        FireworkMeta fwm = fw.getFireworkMeta();
		       
		        fwm.setPower(2);
		        fwm.addEffect(FireworkEffect.builder().withColor(Color.AQUA).withColor(Color.RED).withColor(Color.YELLOW).withColor(Color.ORANGE).flicker(true).build());							       
		        fw.setFireworkMeta(fwm);
		        fw.detonate();
		        
			
			p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1f, 1f);
			p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
			p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 1f, 1f);		
			p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1f, 1f);
			
			p.sendMessage("§3§lDG §7» §7Du hast §e"+ coinsreward03 +" §6Coins§7 gewonnen!");
			CoinsAPI.addCoins(p.getUniqueId().toString(), coinsreward03);
				
			}	            	
        }, 126);
    	} else if (spinlegendary <3) {
    		Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {			
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.529732F);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(a, selten2);
    				
    			}	            	
            }, 1);

        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {	
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.594604F);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(s, selten2);
    				
    			}	            	
            }, 3);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.667420F);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(d, selten2);
    				
    			}	            	
            }, 6);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.707107F);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(f, selten2);
    				
    			}	            	
            }, 10);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.793701F);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(g, selten2);
    				
    			}	            	
            }, 15);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.890899F);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(a, selten2);
    				
    			}	            	
            }, 20);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.943874F);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(s, selten2);
    				
    			}	            	
            }, 25);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.059463F);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(d, selten2);
    				
    			}	            	
            }, 30);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.189207F);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(f, selten2);
    				
    			}	            	
            }, 35);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.334840F);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(g, selten2);
    				
    			}	            	
            }, 40);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.414214F);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(a, selten2);
    				
    			}	            	
            }, 50);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.587401F);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(s, selten2);
    				
    			}	            	
            }, 70);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.781797F);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(d, selten2);
    				
    			}	            	
            }, 85);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.887749F);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(f, selten2);
    				
    			}	            	
            }, 105);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				
    				coinsneu.setItem(4, legy3);
					coinsneu.setItem(13, legy3);
					coinsneu.setItem(40, legy3);
					coinsneu.setItem(49, legy3);
					
					
					coinsneu.setItem(31, reward3);
					coinsneu.setItem(32, placeholder);
					coinsneu.setItem(33, placeholder);
					coinsneu.setItem(29, placeholder);
					coinsneu.setItem(30, placeholder);
					coinsneu.setItem(52, back1);
					coinsneu.setItem(46, again1);
					Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
			        FireworkMeta fwm = fw.getFireworkMeta();
			       
			        fwm.setPower(2);
			        fwm.addEffect(FireworkEffect.builder().withColor(Color.AQUA).withColor(Color.RED).withColor(Color.YELLOW).withColor(Color.ORANGE).flicker(true).build());							       
			        fw.setFireworkMeta(fwm);
			        fw.detonate();
			        
				
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1f, 1f);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 1f, 1f);		
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1f, 1f);
				
				p.sendMessage("§3§lDG §7» §7Du hast §e"+ coinsreward03 +" §6Coins§7 gewonnen!");
				CoinsAPI.addCoins(p.getUniqueId().toString(), coinsreward03);
    			}	            	
            }, 126);
    	} else {
    		
    		Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {			
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.529732F);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(a, normal1);
    				
    			}	            	
            }, 1);

        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {	
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.594604F);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(s, normal1);
    				
    			}	            	
            }, 3);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.667420F);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(d, normal1);
    				
    			}	            	
            }, 6);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.707107F);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(f, normal1);
    				
    			}	            	
            }, 10);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.793701F);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(g, selten2);
    				
    			}	            	
            }, 15);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.890899F);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(a, normal1);
    				
    			}	            	
            }, 20);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.943874F);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(s, normal1);
    				
    			}	            	
            }, 25);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.059463F);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(d, normal1);
    				
    			}	            	
            }, 30);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.189207F);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(f, normal1);
    				
    			}	            	
            }, 35);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.334840F);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(g, normal1);
    				
    			}	            	
            }, 40);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.414214F);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(a, normal1);
    				
    			}	            	
            }, 50);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.587401F);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(s, normal1);
    				
    			}	            	
            }, 70);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.781797F);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(d, normal1);
    				
    			}	            	
            }, 85);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.887749F);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(f, normal1);
    				
    			}	            	
            }, 105);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				
    				coinsneu.setItem(4, legy3);
					coinsneu.setItem(13, legy3);
					coinsneu.setItem(40, legy3);
					coinsneu.setItem(49, legy3);
					
					
					coinsneu.setItem(31, reward3);
					coinsneu.setItem(32, placeholder);
					coinsneu.setItem(33, placeholder);
					coinsneu.setItem(29, placeholder);
					coinsneu.setItem(30, placeholder);
					coinsneu.setItem(52, back1);
					coinsneu.setItem(46, again1);
					Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
			        FireworkMeta fwm = fw.getFireworkMeta();
			       
			        fwm.setPower(2);
			        fwm.addEffect(FireworkEffect.builder().withColor(Color.AQUA).withColor(Color.RED).withColor(Color.YELLOW).withColor(Color.ORANGE).flicker(true).build());							       
			        fw.setFireworkMeta(fwm);
			        fw.detonate();
			        
				
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1f, 1f);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 1f, 1f);		
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1f, 1f);
				
				p.sendMessage("§3§lDG §7» §7Du hast §e"+ coinsreward03 +" §6Coins§7 gewonnen!");
				CoinsAPI.addCoins(p.getUniqueId().toString(), coinsreward03);
    			}	            	
            }, 126);
    		
    	}
    	
    	
    	
    	
    	///////////////////////////////////////////////////////
    	///   REWARD 2
    	///
    	//////////////////////////////////////////////////////
    	
    	

    	
    	
    	
    }else {
    	
    	int spinselten = r.nextInt(3)+1;
    	
    	if(spinselten <2) {
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {					
				
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.529732F);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(33, selten2);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(31, selten2);
			}	            	
        }, 1);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {														
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.594604F);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(29, selten2);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(32, selten2);
			}	            	
        }, 3);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.667420F);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(30, selten2);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(33, selten2);
			}	            	
        }, 6);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.707107F);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(31, selten2);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(29, selten2);
			}	            	
        }, 10);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.793701F);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(32, selten2);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(30, selten2);
			}	            	
        }, 15);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.890899F);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(33, selten2);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(31, selten2);
			}	            	
        }, 20);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.943874F);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(29, selten2);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(32, selten2);
			}	            	
        }, 25);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.059463F);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(30, selten2);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(33, selten2);
			}	            	
        }, 30);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.189207F);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(31, selten2);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(29, selten2);
			}	            	
        }, 35);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.334840F);
				coinsneu.setItem(29, normal1);
				coinsneu.setItem(32, selten2);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(30, selten2);
			}	            	
        }, 40);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.414214F);
				coinsneu.setItem(30, normal1);
				coinsneu.setItem(33, selten2);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(31, selten2);
			}	            	
        }, 50);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.587401F);
				coinsneu.setItem(31, normal1);
				coinsneu.setItem(29, selten2);
				coinsneu.setItem(33, legy3);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(32, selten2);
			}	            	
        }, 70);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.781797F);
				coinsneu.setItem(32, normal1);
				coinsneu.setItem(30, selten2);
				coinsneu.setItem(29, legy3);
				coinsneu.setItem(31, legy3);
				coinsneu.setItem(33, selten2);
			}	            	
        }, 85);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.887749F);
				coinsneu.setItem(33, normal1);
				coinsneu.setItem(31, selten2);
				coinsneu.setItem(30, legy3);
				coinsneu.setItem(32, legy3);
				coinsneu.setItem(29, selten2);
			}	            	
        }, 105);
    	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				coinsneu.setItem(4, selten2);
				coinsneu.setItem(13, selten2);
				coinsneu.setItem(40, selten2);
				coinsneu.setItem(49, selten2);
				
				coinsneu.setItem(31, reward2);
				coinsneu.setItem(32, placeholder);
				coinsneu.setItem(33, placeholder);
				coinsneu.setItem(29, placeholder);
				coinsneu.setItem(30, placeholder);
				coinsneu.setItem(52, back1);
				coinsneu.setItem(46, again1);
				p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1f, 1f);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 1f, 1f);
				p.playSound(p.getLocation(), Sound.WITHER_DEATH, 1f, 1f);
				
				p.sendMessage("§3§lDG §7» §7Du hast §e"+ coinsreward02 +" §6Coins§7 gewonnen!");
				CoinsAPI.addCoins(p.getUniqueId().toString(), coinsreward02);
			}	            	
        }, 126);
    	
    	
    	} else if(spinselten <3) {
    		Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {			
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.529732F);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(a, normal1);
    				
    			}	            	
            }, 1);

        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {	
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.594604F);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(s, normal1);
    				
    			}	            	
            }, 3);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.667420F);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(d, normal1);
    				
    			}	            	
            }, 6);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.707107F);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(f, normal1);
    				
    			}	            	
            }, 10);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.793701F);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(g, normal1);
    				
    			}	            	
            }, 15);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.890899F);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(a, normal1);
    				
    			}	            	
            }, 20);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.943874F);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(s, normal1);
    				
    			}	            	
            }, 25);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.059463F);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(d, normal1);
    				
    			}	            	
            }, 30);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.189207F);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(f, normal1);
    				
    			}	            	
            }, 35);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.334840F);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(g, normal1);
    				
    			}	            	
            }, 40);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.414214F);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(a, normal1);
    				
    			}	            	
            }, 50);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.587401F);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(s, normal1);
    				
    			}	            	
            }, 70);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.781797F);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(d, normal1);
    				
    			}	            	
            }, 85);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.887749F);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(f, normal1);
    				
    			}	            	
            }, 105);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				
    				coinsneu.setItem(4, selten2);
					coinsneu.setItem(13, selten2);
					coinsneu.setItem(40, selten2);
					coinsneu.setItem(49, selten2);
					
					
					coinsneu.setItem(31, reward3);
					coinsneu.setItem(32, placeholder);
					coinsneu.setItem(33, placeholder);
					coinsneu.setItem(29, placeholder);
					coinsneu.setItem(30, placeholder);
					coinsneu.setItem(52, back1);
					coinsneu.setItem(46, again1);
				
			        p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1f, 1f);
					p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
					p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 1f, 1f);
					p.playSound(p.getLocation(), Sound.WITHER_DEATH, 1f, 1f);
					
				
				p.sendMessage("§3§lDG §7» §7Du hast §e"+ coinsreward02 +" §6Coins§7 gewonnen!");
				CoinsAPI.addCoins(p.getUniqueId().toString(), coinsreward02);
    			}	            	
            }, 126);
        	
        	
    	}else {
    		Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {			
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.529732F);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(a, selten2);
    				
    			}	            	
            }, 1);

        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {	
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.594604F);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(s, selten2);
    				
    			}	            	
            }, 3);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.667420F);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(d, selten2);
    				
    			}	            	
            }, 6);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.707107F);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(f, selten2);
    				
    			}	            	
            }, 10);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.793701F);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(g, selten2);
    				
    			}	            	
            }, 15);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.890899F);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(a, selten2);
    				
    			}	            	
            }, 20);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 0.943874F);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(s, selten2);
    				
    			}	            	
            }, 25);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.059463F);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(d, selten2);
    				
    			}	            	
            }, 30);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.189207F);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(f, selten2);
    				
    			}	            	
            }, 35);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.334840F);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(f, selten2);
    				coinsneu.setItem(s, legy3);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(g, selten2);
    				
    			}	            	
            }, 40);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.414214F);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(g, selten2);
    				coinsneu.setItem(d, legy3);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(a, selten2);
    				
    			}	            	
            }, 50);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.587401F);
    				coinsneu.setItem(d, normal1);
    				coinsneu.setItem(a, selten2);
    				coinsneu.setItem(f, legy3);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(s, selten2);
    				
    			}	            	
            }, 70);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.781797F);
    				coinsneu.setItem(f, normal1);
    				coinsneu.setItem(s, selten2);
    				coinsneu.setItem(g, legy3);
    				coinsneu.setItem(a, normal1);
    				coinsneu.setItem(d, selten2);
    				
    			}	            	
            }, 85);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				p.playSound(p.getLocation(), Sound.NOTE_PIANO, (float) 1, 1.887749F);
    				coinsneu.setItem(g, normal1);
    				coinsneu.setItem(d, selten2);
    				coinsneu.setItem(a, legy3);
    				coinsneu.setItem(s, normal1);
    				coinsneu.setItem(f, selten2);
    				
    			}	            	
            }, 105);
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
    			@Override
    			public void run() {
    				
    				coinsneu.setItem(4, selten2);
					coinsneu.setItem(13, selten2);
					coinsneu.setItem(40, selten2);
					coinsneu.setItem(49, selten2);
					
					
					coinsneu.setItem(31, reward3);
					coinsneu.setItem(32, placeholder);
					coinsneu.setItem(33, placeholder);
					coinsneu.setItem(29, placeholder);
					coinsneu.setItem(30, placeholder);
					coinsneu.setItem(52, back1);
					coinsneu.setItem(46, again1);
				
			        p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1f, 1f);
					p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1f, 1f);
					p.playSound(p.getLocation(), Sound.FIREWORK_BLAST2, 1f, 1f);
					p.playSound(p.getLocation(), Sound.WITHER_DEATH, 1f, 1f);
					
				
				p.sendMessage("§3§lDG §7» §7Du hast §e"+ coinsreward02 +" §6Coins§7 gewonnen!");
				CoinsAPI.addCoins(p.getUniqueId().toString(), coinsreward02);
    			}	            	
            }, 126);
    	}
    	
    	
    	
    	
    	
    	
    	
    } 
    
    
    
    
    ///////////////////////////
    //Animation an der Seite //
    //////////////////////////
    
    
    
    
    
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(0, side1);
			coinsneu.setItem(9, side2);
			coinsneu.setItem(18, side3);
			coinsneu.setItem(27, side4);
			coinsneu.setItem(36, side5);
			coinsneu.setItem(45, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(53, side1);
			coinsneu.setItem(44, side2);
			coinsneu.setItem(35, side3);
			coinsneu.setItem(26, side4);
			coinsneu.setItem(17, side5);
			coinsneu.setItem(8, side6);
		}	            	
    }, 10);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(45, side1);
			coinsneu.setItem(0, side2);
			coinsneu.setItem(9, side3);
			coinsneu.setItem(18, side4);
			coinsneu.setItem(27, side5);
			coinsneu.setItem(36, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(44, side1);
			coinsneu.setItem(35 ,side2);
			coinsneu.setItem(26, side3);
			coinsneu.setItem(17, side4);
			coinsneu.setItem(8, side5);
			coinsneu.setItem(53, side6);
		}	            	
    }, 20);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(36, side1);
			coinsneu.setItem(45, side2);
			coinsneu.setItem(0, side3);
			coinsneu.setItem(9, side4);
			coinsneu.setItem(18, side5);
			coinsneu.setItem(27, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(35, side1);
			coinsneu.setItem(26, side2);
			coinsneu.setItem(17, side3);
			coinsneu.setItem(8, side4);
			coinsneu.setItem(53, side5);
			coinsneu.setItem(44, side6);
		}	            	
    }, 30);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(27, side1);
			coinsneu.setItem(36, side2);
			coinsneu.setItem(45, side3);
			coinsneu.setItem(0, side4);
			coinsneu.setItem(9, side5);
			coinsneu.setItem(18, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(26, side1);
			coinsneu.setItem(17, side2);
			coinsneu.setItem(8, side3);
			coinsneu.setItem(53, side4);
			coinsneu.setItem(44, side5);
			coinsneu.setItem(35, side6);
		}	            	
    }, 40);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(18, side1);
			coinsneu.setItem(27, side2);
			coinsneu.setItem(36, side3);
			coinsneu.setItem(45, side4);
			coinsneu.setItem(0, side5);
			coinsneu.setItem(9, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(17, side1);
			coinsneu.setItem(8, side2);
			coinsneu.setItem(53, side3);
			coinsneu.setItem(44, side4);
			coinsneu.setItem(35, side5);
			coinsneu.setItem(26, side6);
		}	            	
    }, 50);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(9, side1);
			coinsneu.setItem(18, side2);
			coinsneu.setItem(27, side3);
			coinsneu.setItem(36, side4);
			coinsneu.setItem(45, side5);
			coinsneu.setItem(0, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(8, side1);
			coinsneu.setItem(53, side2);
			coinsneu.setItem(44, side3);
			coinsneu.setItem(35, side4);
			coinsneu.setItem(26, side5);
			coinsneu.setItem(17, side6);
		}	            	
    }, 60);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(0, side1);
			coinsneu.setItem(9, side2);
			coinsneu.setItem(18, side3);
			coinsneu.setItem(27, side4);
			coinsneu.setItem(36, side5);
			coinsneu.setItem(45, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(53, side1);
			coinsneu.setItem(44, side2);
			coinsneu.setItem(35, side3);
			coinsneu.setItem(26, side4);
			coinsneu.setItem(17, side5);
			coinsneu.setItem(8, side6);
		}	            	
    }, 70);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(0, side1);
			coinsneu.setItem(9, side2);
			coinsneu.setItem(18, side3);
			coinsneu.setItem(27, side4);
			coinsneu.setItem(36, side5);
			coinsneu.setItem(45, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(53, side1);
			coinsneu.setItem(44, side2);
			coinsneu.setItem(35, side3);
			coinsneu.setItem(26, side4);
			coinsneu.setItem(17, side5);
			coinsneu.setItem(8, side6);
		}	            	
    }, 80);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(45, side1);
			coinsneu.setItem(0, side2);
			coinsneu.setItem(9, side3);
			coinsneu.setItem(18, side4);
			coinsneu.setItem(27, side5);
			coinsneu.setItem(36, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(44, side1);
			coinsneu.setItem(35 ,side2);
			coinsneu.setItem(26, side3);
			coinsneu.setItem(17, side4);
			coinsneu.setItem(8, side5);
			coinsneu.setItem(53, side6);
		}	            	
    }, 90);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(36, side1);
			coinsneu.setItem(45, side2);
			coinsneu.setItem(0, side3);
			coinsneu.setItem(9, side4);
			coinsneu.setItem(18, side5);
			coinsneu.setItem(27, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(35, side1);
			coinsneu.setItem(26, side2);
			coinsneu.setItem(17, side3);
			coinsneu.setItem(8, side4);
			coinsneu.setItem(53, side5);
			coinsneu.setItem(44, side6);
		}	            	
    }, 100);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(27, side1);
			coinsneu.setItem(36, side2);
			coinsneu.setItem(45, side3);
			coinsneu.setItem(0, side4);
			coinsneu.setItem(9, side5);
			coinsneu.setItem(18, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(26, side1);
			coinsneu.setItem(17, side2);
			coinsneu.setItem(8, side3);
			coinsneu.setItem(53, side4);
			coinsneu.setItem(44, side5);
			coinsneu.setItem(35, side6);
		}	            	
    }, 110);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(18, side1);
			coinsneu.setItem(27, side2);
			coinsneu.setItem(36, side3);
			coinsneu.setItem(45, side4);
			coinsneu.setItem(0, side5);
			coinsneu.setItem(9, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(17, side1);
			coinsneu.setItem(8, side2);
			coinsneu.setItem(53, side3);
			coinsneu.setItem(44, side4);
			coinsneu.setItem(35, side5);
			coinsneu.setItem(26, side6);
		}	            	
    }, 120);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(9, side1);
			coinsneu.setItem(18, side2);
			coinsneu.setItem(27, side3);
			coinsneu.setItem(36, side4);
			coinsneu.setItem(45, side5);
			coinsneu.setItem(0, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(8, side1);
			coinsneu.setItem(53, side2);
			coinsneu.setItem(44, side3);
			coinsneu.setItem(35, side4);
			coinsneu.setItem(26, side5);
			coinsneu.setItem(17, side6);
		}	            	
    }, 130);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(0, side1);
			coinsneu.setItem(9, side2);
			coinsneu.setItem(18, side3);
			coinsneu.setItem(27, side4);
			coinsneu.setItem(36, side5);
			coinsneu.setItem(45, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(53, side1);
			coinsneu.setItem(44, side2);
			coinsneu.setItem(35, side3);
			coinsneu.setItem(26, side4);
			coinsneu.setItem(17, side5);
			coinsneu.setItem(8, side6);
		}	            	
    }, 140);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(0, side1);
			coinsneu.setItem(9, side2);
			coinsneu.setItem(18, side3);
			coinsneu.setItem(27, side4);
			coinsneu.setItem(36, side5);
			coinsneu.setItem(45, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(53, side1);
			coinsneu.setItem(44, side2);
			coinsneu.setItem(35, side3);
			coinsneu.setItem(26, side4);
			coinsneu.setItem(17, side5);
			coinsneu.setItem(8, side6);
		}	            	
    }, 150);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(45, side1);
			coinsneu.setItem(0, side2);
			coinsneu.setItem(9, side3);
			coinsneu.setItem(18, side4);
			coinsneu.setItem(27, side5);
			coinsneu.setItem(36, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(44, side1);
			coinsneu.setItem(35 ,side2);
			coinsneu.setItem(26, side3);
			coinsneu.setItem(17, side4);
			coinsneu.setItem(8, side5);
			coinsneu.setItem(53, side6);
		}	            	
    }, 160);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(36, side1);
			coinsneu.setItem(45, side2);
			coinsneu.setItem(0, side3);
			coinsneu.setItem(9, side4);
			coinsneu.setItem(18, side5);
			coinsneu.setItem(27, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(35, side1);
			coinsneu.setItem(26, side2);
			coinsneu.setItem(17, side3);
			coinsneu.setItem(8, side4);
			coinsneu.setItem(53, side5);
			coinsneu.setItem(44, side6);
		}	            	
    }, 170);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(27, side1);
			coinsneu.setItem(36, side2);
			coinsneu.setItem(45, side3);
			coinsneu.setItem(0, side4);
			coinsneu.setItem(9, side5);
			coinsneu.setItem(18, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(26, side1);
			coinsneu.setItem(17, side2);
			coinsneu.setItem(8, side3);
			coinsneu.setItem(53, side4);
			coinsneu.setItem(44, side5);
			coinsneu.setItem(35, side6);
		}	            	
    }, 180);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(18, side1);
			coinsneu.setItem(27, side2);
			coinsneu.setItem(36, side3);
			coinsneu.setItem(45, side4);
			coinsneu.setItem(0, side5);
			coinsneu.setItem(9, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(17, side1);
			coinsneu.setItem(8, side2);
			coinsneu.setItem(53, side3);
			coinsneu.setItem(44, side4);
			coinsneu.setItem(35, side5);
			coinsneu.setItem(26, side6);
		}	            	
    }, 190);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(9, side1);
			coinsneu.setItem(18, side2);
			coinsneu.setItem(27, side3);
			coinsneu.setItem(36, side4);
			coinsneu.setItem(45, side5);
			coinsneu.setItem(0, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(8, side1);
			coinsneu.setItem(53, side2);
			coinsneu.setItem(44, side3);
			coinsneu.setItem(35, side4);
			coinsneu.setItem(26, side5);
			coinsneu.setItem(17, side6);
		}	            	
    }, 200);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(0, side1);
			coinsneu.setItem(9, side2);
			coinsneu.setItem(18, side3);
			coinsneu.setItem(27, side4);
			coinsneu.setItem(36, side5);
			coinsneu.setItem(45, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(53, side1);
			coinsneu.setItem(44, side2);
			coinsneu.setItem(35, side3);
			coinsneu.setItem(26, side4);
			coinsneu.setItem(17, side5);
			coinsneu.setItem(8, side6);
		}	            	
    }, 210);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(0, side1);
			coinsneu.setItem(9, side2);
			coinsneu.setItem(18, side3);
			coinsneu.setItem(27, side4);
			coinsneu.setItem(36, side5);
			coinsneu.setItem(45, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(53, side1);
			coinsneu.setItem(44, side2);
			coinsneu.setItem(35, side3);
			coinsneu.setItem(26, side4);
			coinsneu.setItem(17, side5);
			coinsneu.setItem(8, side6);
		}	            	
    }, 220);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(45, side1);
			coinsneu.setItem(0, side2);
			coinsneu.setItem(9, side3);
			coinsneu.setItem(18, side4);
			coinsneu.setItem(27, side5);
			coinsneu.setItem(36, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(44, side1);
			coinsneu.setItem(35 ,side2);
			coinsneu.setItem(26, side3);
			coinsneu.setItem(17, side4);
			coinsneu.setItem(8, side5);
			coinsneu.setItem(53, side6);
		}	            	
    }, 230);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(36, side1);
			coinsneu.setItem(45, side2);
			coinsneu.setItem(0, side3);
			coinsneu.setItem(9, side4);
			coinsneu.setItem(18, side5);
			coinsneu.setItem(27, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(35, side1);
			coinsneu.setItem(26, side2);
			coinsneu.setItem(17, side3);
			coinsneu.setItem(8, side4);
			coinsneu.setItem(53, side5);
			coinsneu.setItem(44, side6);
		}	            	
    }, 240);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(27, side1);
			coinsneu.setItem(36, side2);
			coinsneu.setItem(45, side3);
			coinsneu.setItem(0, side4);
			coinsneu.setItem(9, side5);
			coinsneu.setItem(18, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(26, side1);
			coinsneu.setItem(17, side2);
			coinsneu.setItem(8, side3);
			coinsneu.setItem(53, side4);
			coinsneu.setItem(44, side5);
			coinsneu.setItem(35, side6);
		}	            	
    }, 250);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(18, side1);
			coinsneu.setItem(27, side2);
			coinsneu.setItem(36, side3);
			coinsneu.setItem(45, side4);
			coinsneu.setItem(0, side5);
			coinsneu.setItem(9, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(17, side1);
			coinsneu.setItem(8, side2);
			coinsneu.setItem(53, side3);
			coinsneu.setItem(44, side4);
			coinsneu.setItem(35, side5);
			coinsneu.setItem(26, side6);
		}	            	
    }, 260);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(9, side1);
			coinsneu.setItem(18, side2);
			coinsneu.setItem(27, side3);
			coinsneu.setItem(36, side4);
			coinsneu.setItem(45, side5);
			coinsneu.setItem(0, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(8, side1);
			coinsneu.setItem(53, side2);
			coinsneu.setItem(44, side3);
			coinsneu.setItem(35, side4);
			coinsneu.setItem(26, side5);
			coinsneu.setItem(17, side6);
		}	            	
    }, 270);
    Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
		@Override
		public void run() {
			coinsneu.setItem(0, side1);
			coinsneu.setItem(9, side2);
			coinsneu.setItem(18, side3);
			coinsneu.setItem(27, side4);
			coinsneu.setItem(36, side5);
			coinsneu.setItem(45, side6);
			//LILA1 ORANGE2 HELLBLAU3 YELLOW4 GRÜN5 PINK6
			coinsneu.setItem(53, side1);
			coinsneu.setItem(44, side2);
			coinsneu.setItem(35, side3);
			coinsneu.setItem(26, side4);
			coinsneu.setItem(17, side5);
			coinsneu.setItem(8, side6);
		}	            	
    }, 280);
    
    
    
}else {
	p.sendMessage("§3§lDG §7» §cDu hast §c§lnicht §cgenügend Lose!");
	p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1f, 1f);
}
}
		}
} 
}
