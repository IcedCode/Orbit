package me.icycode.orbit.utils;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class Xp {
	
	private static HashMap<String, Integer> xp = new HashMap<String, Integer>();
	private static HashMap<String, Integer> xpLevel = new HashMap<String, Integer>();
	private static HashMap<String, Integer> prestige = new HashMap<String, Integer>();
	
	public static void addXp(Player player, int Xp) {
		int finalXp = Xp + xp.get(player.getName());
		
		xp.put(player.getName(), finalXp);
		
	}
	
	
	
	private void updateXpLevel(Player player) {
		String playerName = player.getName();
		int totalXp = xp.get(playerName);
		int level = xpLevel.get(playerName);
		long requiredXp = 16;
		if (level == 1) {
			//Player does not have a level
			xpLevel.put(playerName, 1);
		} else if (level > 0) {
			int counter = 1;
			while (counter <= level) {
				requiredXp = Math.round(requiredXp * 1.1);
			}
		}
		
		
			
		
		
		
	}
	
}
