package me.icycode.orbit.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.keenant.tabbed.Tabbed;
import com.keenant.tabbed.item.BlankTabItem;
import com.keenant.tabbed.item.PlayerTabItem;
import com.keenant.tabbed.item.TextTabItem;
import com.keenant.tabbed.tablist.TitledTabList;
import com.keenant.tabbed.util.Skins;

import me.icycode.orbit.Main;

public class Tab {
	
	public static void update(Player player) {
		TitledTabList tab = Main.tabbed.newTitledTabList(player);
		// Better to send this (one packet)
		tab.setHeaderFooter("The tab list header!", "The tab list footer :O");

		// Getters
		String header = tab.getHeader();
		String footer = tab.getFooter();
		
	}
	
}
