package me.icycode.orbit.match.gamemodes;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.utils.chat.Chatter;

public class FFA {
	
	private static HashMap<Player, Integer> points = new HashMap<Player, Integer>();
	
	public static void addPoints(Player player, int p) {
		points.put(player, p);
	}
	
	public static void endGameLogic() {
		int highScore = 0;
		Player winPlayer = null;
		for (Player player : Bukkit.getOnlinePlayers()) {
			GamePlayer gamePlayer = Main.onlinePlayers.get(player);
			if(gamePlayer.points > highScore) {
				highScore = gamePlayer.points;
				winPlayer = gamePlayer.getPlayer();
			}
		}
		Player player = winPlayer;
		if (player != null) {
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > > " + ChatColor.RED + ChatColor.BOLD + player.getName() + " Wins!" + ChatColor.GOLD + ChatColor.BOLD + " < < < <");
			player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +20 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You won!");
			player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
			GamePlayer gamePlayer = Main.onlinePlayers.get(player);
			gamePlayer.addXp(20);
			for (Player p : Bukkit.getOnlinePlayers()) {
				GamePlayer gameP = Main.onlinePlayers.get(p);
				if (p != player) {
					p.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +5 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You participated in a match!");
					p.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					gameP.addXp(5);
				}
				gameP.points = 0;
		}
		
		
		}
	}
}
