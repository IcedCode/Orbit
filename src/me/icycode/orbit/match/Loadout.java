package me.icycode.orbit.match;

import me.icycode.orbit.utils.player.armor.Boots;
import me.icycode.orbit.utils.player.armor.Chestplate;
import me.icycode.orbit.utils.player.armor.Helmet;
import me.icycode.orbit.utils.player.armor.Leggings;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Loadout {
	
	
	
	public static void giveLoadout(Player player) {
		if (MapInfo.gameMode.equalsIgnoreCase("TDM")) {
			//Item Creation
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 3);
			ItemStack food = new ItemStack(Material.COOKED_BEEF, 8);
			
			//Item set
			player.getInventory().setItem(0, sword);
			player.getInventory().setItem(1, gapple);
			player.getInventory().setItem(2, food);
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
		}
		
		Helmet.give(player);
		Chestplate.give(player);
		Leggings.give(player);
		Boots.give(player);
	}
	
	
	
}
