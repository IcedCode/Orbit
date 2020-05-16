package me.icycode.orbit.match;

import me.icycode.orbit.utils.player.armor.Boots;
import me.icycode.orbit.utils.player.armor.Chestplate;
import me.icycode.orbit.utils.player.armor.Helmet;
import me.icycode.orbit.utils.player.armor.Leggings;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Loadout {
	
	
	
	public static void giveLoadout(Player player) {
		if (MapInfo.gameMode.equalsIgnoreCase("TDM") || MapInfo.gameMode.equalsIgnoreCase("FFA")) {
			//Item Creation
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 3);
			ItemStack food = new ItemStack(Material.COOKED_BEEF, 8);
			ItemStack arrow = new ItemStack(Material.ARROW, 16);
			
			//Item set
			player.getInventory().setItem(0, sword);
			player.getInventory().setItem(1, bow);
			player.getInventory().setItem(2, gapple);
			player.getInventory().setItem(3, food);
			player.getInventory().setItem(8, arrow);
		} else if (MapInfo.gameMode.equalsIgnoreCase("CTF")) {
			//Item Creation
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemStack bow = new ItemStack(Material.BOW, 1);
			bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 3);
			ItemStack food = new ItemStack(Material.COOKED_BEEF, 8);
			ItemStack arrow = new ItemStack(Material.ARROW, 1);
			
			//Item set
			player.getInventory().setItem(0, sword);
			player.getInventory().setItem(1, bow);
			player.getInventory().setItem(2, gapple);
			player.getInventory().setItem(3, food);
			player.getInventory().setItem(9, arrow);
		} else if (MapInfo.gameMode.equalsIgnoreCase("DTM")) {
			if (MapInfo.mapName.equals("Senex 1")) {
				//Item Creation
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
				ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 3);
				ItemStack food = new ItemStack(Material.COOKED_BEEF, 8);
				ItemStack glass = new ItemStack(Material.GLASS, 32);
				ItemStack sandstone = new ItemStack(Material.SANDSTONE, 64);
				ItemStack log = new ItemStack(Material.LOG, 64);
				ItemStack arrow = new ItemStack(Material.ARROW, 64);
				
				//Item set
				player.getInventory().setItem(0, sword);
				player.getInventory().setItem(1, bow);
				player.getInventory().setItem(2, pick);
				player.getInventory().setItem(3, gapple);
				player.getInventory().setItem(4, food);
				player.getInventory().setItem(5, glass);
				player.getInventory().setItem(6, sandstone);
				player.getInventory().setItem(7, log);
				player.getInventory().setItem(9, arrow);
			} else if (MapInfo.mapName.equals("Halcyon") || MapInfo.mapName.equalsIgnoreCase("BerrylandMC DTM")) {
				//Item Creation
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
				pick.addEnchantment(Enchantment.DIG_SPEED, 1);
				ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 3);
				ItemStack food = new ItemStack(Material.COOKED_BEEF, 8);
				ItemStack glass = new ItemStack(Material.GLASS, 64);
				ItemStack log = new ItemStack(Material.LOG, 32);
				ItemStack arrow = new ItemStack(Material.ARROW, 64);
				
				//Item set
				player.getInventory().setItem(0, sword);
				player.getInventory().setItem(1, bow);
				player.getInventory().setItem(2, pick);
				player.getInventory().setItem(3, gapple);
				player.getInventory().setItem(4, food);
				player.getInventory().setItem(5, glass);
				player.getInventory().setItem(6, log);
				player.getInventory().setItem(9, arrow);
			} else if (MapInfo.mapName.equalsIgnoreCase("Quintlet") || MapInfo.mapName.equalsIgnoreCase("Rendezvous")) {
				//Item Creation
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
				pick.addEnchantment(Enchantment.DIG_SPEED, 1);
				ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 3);
				ItemStack food = new ItemStack(Material.COOKED_BEEF, 8);
				ItemStack glass = new ItemStack(Material.GLASS, 32);
				ItemStack log = new ItemStack(Material.LOG, 64);
				ItemStack stone = new ItemStack(Material.SMOOTH_BRICK, 64);
				ItemStack arrow = new ItemStack(Material.ARROW, 64);
				
				//Item set
				player.getInventory().setItem(0, sword);
				player.getInventory().setItem(1, bow);
				player.getInventory().setItem(2, pick);
				player.getInventory().setItem(3, gapple);
				player.getInventory().setItem(4, food);
				player.getInventory().setItem(5, glass);
				player.getInventory().setItem(6, log);
				player.getInventory().setItem(9, arrow);
			} else if (MapInfo.mapName.equalsIgnoreCase("Kingdom")) {
				//Item Creation
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
				ItemStack spade = new ItemStack(Material.IRON_SPADE, 1);
				ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);
				ItemStack food = new ItemStack(Material.COOKED_BEEF, 8);
				ItemStack glass = new ItemStack(Material.GLASS, 32);
				ItemStack log = new ItemStack(Material.LOG, 64);
				ItemStack stone = new ItemStack(Material.SMOOTH_BRICK, 64);
				ItemStack arrow = new ItemStack(Material.ARROW, 64);
				
				//Item set
				player.getInventory().setItem(0, sword);
				player.getInventory().setItem(1, bow);
				player.getInventory().setItem(2, pick);
				player.getInventory().setItem(3, spade);
				player.getInventory().setItem(4, gapple);
				player.getInventory().setItem(5, food);
				player.getInventory().setItem(6, glass);
				player.getInventory().setItem(7, log);
				player.getInventory().setItem(9, arrow);
			} else if (MapInfo.mapName.equalsIgnoreCase("Silva")) {
				//Item Creation
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
				ItemStack spade = new ItemStack(Material.STONE_SPADE, 1);
				ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);
				ItemStack food = new ItemStack(Material.COOKED_BEEF, 8);
				ItemStack glass = new ItemStack(Material.LEAVES, 32);
				ItemStack log = new ItemStack(Material.LOG, 64);
				ItemStack arrow = new ItemStack(Material.ARROW, 64);
				
				//Item set
				player.getInventory().setItem(0, sword);
				player.getInventory().setItem(1, bow);
				player.getInventory().setItem(2, pick);
				player.getInventory().setItem(3, spade);
				player.getInventory().setItem(4, gapple);
				player.getInventory().setItem(5, food);
				player.getInventory().setItem(6, glass);
				player.getInventory().setItem(7, log);
				player.getInventory().setItem(9, arrow);
			} 
		} else if (MapInfo.gameMode.equalsIgnoreCase("CTW")) {
			//Item Creation
			ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
			ItemStack bow = new ItemStack(Material.BOW, 1);
			ItemStack pick = new ItemStack(Material.IRON_PICKAXE, 1);
			ItemStack axe = new ItemStack(Material.IRON_AXE, 1);
			ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);
			ItemStack food = new ItemStack(Material.COOKED_BEEF, 16);
			ItemStack glass = new ItemStack(Material.GLASS, 32);
			ItemStack log = new ItemStack(Material.LOG, 64);
			ItemStack stone = new ItemStack(Material.STONE, 64);
			ItemStack arrow = new ItemStack(Material.ARROW, 64);
			
			//Item set
			player.getInventory().setItem(0, sword);
			player.getInventory().setItem(1, bow);
			player.getInventory().setItem(2, pick);
			player.getInventory().setItem(3, axe);
			player.getInventory().setItem(4, gapple);
			player.getInventory().setItem(5, food);
			player.getInventory().setItem(6, glass);
			player.getInventory().setItem(7, log);
			player.getInventory().setItem(9, arrow);
		}
		
		Helmet.give(player);
		Chestplate.give(player);
		Leggings.give(player);
		Boots.give(player);
	}
	
	
	
}
