package me.icycode.orbit.match.gamemodes;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.utils.chat.Chatter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Parkour {
	
	public static void endGameLogic(Player player) {
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > > " + ChatColor.RED + ChatColor.BOLD + player.getName() + " Wins!" + ChatColor.GOLD + ChatColor.BOLD + " < < < <");
		player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +20 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You won!");
		player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
		GamePlayer gamePlayer = Main.onlinePlayers.get(player);
		gamePlayer.addXp(20);
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p != player) {
				p.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +5 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You participated in a match!");
				p.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
				GamePlayer gameP = Main.onlinePlayers.get(p);
				gameP.addXp(5);
			}
			
		}
	}
	
}
