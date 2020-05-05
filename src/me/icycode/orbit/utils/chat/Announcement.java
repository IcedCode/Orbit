package me.icycode.orbit.utils.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Announcement {
	
	public static int counter;
	
	
	
	public static void broadcast() {
		if (counter == 0) {
			Bukkit.getServer().broadcastMessage(Chatter.Tip() + ChatColor.YELLOW + "This game is still under development. Report bugs at https://github.com/Celestial-Network/Issues/issues");
			counter++;
		} else if (counter == 1) {
			Bukkit.getServer().broadcastMessage(Chatter.Tip() + ChatColor.RED + "Visit our website at (Address here)");
			counter++;
		} else if (counter == 2) {
			Bukkit.getServer().broadcastMessage(Chatter.Tip() + ChatColor.BLUE + "Get a " + ChatColor.AQUA + ChatColor.BOLD + "PREMIUM" + ChatColor.BLUE + " rank for loads more perks!");
			counter++;
		}else if (counter == 3) {
			Bukkit.getServer().broadcastMessage(Chatter.Tip() + ChatColor.GOLD + "Come and meet the community at (Address here)");
			counter++;
		}else if (counter == 4) {
			Bukkit.getServer().broadcastMessage(Chatter.Tip() + ChatColor.GREEN + "Is someone breaking the rules? Use /report to alert the staff!");
			counter = 0;
		}
		
	}
	
}
