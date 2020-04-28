package me.icycode.orbit.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mcsg.double0negative.tabapi.TabUtils;

import me.icycode.orbit.match.MapInfo;
import net.md_5.bungee.api.ChatColor;

public class Tab {
	
	public static void update() {
		
		for(Player player: Bukkit.getOnlinePlayers()) {
			TabUtils.sendTabHeader(player, ChatColor.GOLD + "" + ChatColor.BOLD + MapInfo.gameMode.toUpperCase() + ChatColor.BLACK + " - " + ChatColor.WHITE + MapInfo.mapName);
		}

	}
	
}
