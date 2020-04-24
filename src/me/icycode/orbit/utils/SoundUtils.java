package me.icycode.orbit.utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundUtils {
	public static void broadcastSound(Sound sound) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.getWorld().playSound(player.getLocation(), sound, 1, 1);
		}
	}
}
