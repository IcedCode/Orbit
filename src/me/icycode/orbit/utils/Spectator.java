package me.icycode.orbit.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Spectator {
	
	public static void makeSpec(Player player) {
		player.setAllowFlight(true);
		player.setGameMode(GameMode.ADVENTURE);
		player.setAllowFlight(true);
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.hidePlayer(player);
		}
	}
	
}
