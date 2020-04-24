package me.icycode.orbit.utils.player;

import org.bukkit.entity.Player;

public class Inventory {
	
	public static void clear(Player player) {
		int i = 0;
		while (i <= 35) {
			player.getInventory().setItem(i, null);
			i++;
		}
		player.getInventory().setHelmet(null);
		player.getInventory().setChestplate(null);
		player.getInventory().setLeggings(null);
		player.getInventory().setBoots(null);
	}
	
}
