package me.icycode.orbit.match.gamemodes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.module.Hill;
import me.icycode.orbit.module.Region;
import me.icycode.orbit.utils.Scoreboard;
import me.icycode.orbit.utils.SoundUtils;
import me.icycode.orbit.utils.chat.Chatter;

public class CTH {
	
	public static int pointsToWin;
	
	public static Hill hill;
	
	public static int countDownInterval;
	
	public static void generateCountDownInterval() {
		for(long i = 0 ; i < 30; i++) {
			i = Math.round((Math.random() * 10) + 30);
			countDownInterval = (int) Math.rint(i);
		}
	}
	
	private static void countDownEnd() {
		int t1Add = 0, t2Add = 0, t3Add = 0, t4Add = 0;
		for (Player player : Bukkit.getOnlinePlayers()) {
			Region r = hill.region;
			Location l = player.getLocation();
			if (r.getLowerX() < l.getX() 
					&& r.getLowerY() < l.getY() 
					&& r.getLowerZ() < l.getZ() 
					&& r.getUpperX() > l.getX() 
					&& r.getUpperY() > l.getY() 
					&& r.getUpperZ() > l.getZ()){
				if (TeamManager.team1.contains(player)) {
					t1Add +=10;
				} else if (TeamManager.team2.contains(player)) {
					t2Add += 10;
				} else if (TeamManager.team3.contains(player)) {
					t3Add += 10;
				} else if (TeamManager.team4.contains(player)) {
					t4Add += 10;
				}
			}
		}
		
		 
		//Separate loop as needs to be called after above
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (t1Add != 0)
				player.sendMessage(TeamManager.team1.getColoredName() + ChatColor.GRAY + " scored " + t1Add + " points!");
			if (t2Add != 0)
				player.sendMessage(TeamManager.team2.getColoredName() + ChatColor.GRAY + " scored " + t2Add + " points!");
			if (t3Add != 0)
				player.sendMessage(TeamManager.team3.getColoredName() + ChatColor.GRAY + " scored " + t3Add + " points!");
			if (t4Add != 0)
				player.sendMessage(TeamManager.team4.getColoredName() + ChatColor.GRAY + " scored " + t4Add + " points!");
			if (t1Add == 0 && t2Add == 0 && t3Add == 0 && t4Add == 0)
				player.sendMessage(ChatColor.GRAY + "No team scored any points.");
		}
		
		TeamManager.team1.addPoints(t1Add);
		TeamManager.team2.addPoints(t2Add);
		TeamManager.team3.addPoints(t3Add);
		TeamManager.team4.addPoints(t4Add);
		Scoreboard.CTHUpdate();
		generateCountDownInterval();
	}
	
	public static void endGameLogic() {	
		if (TeamManager.team1.getPoints() > TeamManager.team2.getPoints() 
				&& TeamManager.team1.getPoints() > TeamManager.team3.getPoints() 
				&& TeamManager.team1.getPoints() > TeamManager.team4.getPoints()) {
			
			//Team 1 Wins
			
			//Win Message
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team1.getColor() + TeamManager.team1.getName() + " Wins") + ChatColor.GOLD + ChatColor.BOLD + " < < < <");
			
			for (Player player : Bukkit.getOnlinePlayers()){
				if (TeamManager.team1.contains(player)) {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +20 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " Your team won!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(20);
				} else {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +5 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You participated in a match!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(5);
				}
			}
		} else if (TeamManager.team2.getPoints() > TeamManager.team1.getPoints() 
				&& TeamManager.team2.getPoints() > TeamManager.team3.getPoints() 
				&& TeamManager.team2.getPoints() > TeamManager.team4.getPoints()) {
			
			//Team 2 Wins
			
			//Win Message
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team2.getColor() + TeamManager.team2.getName() + " Wins") + ChatColor.GOLD + ChatColor.BOLD + " < < < <");
			
			for (Player player : Bukkit.getOnlinePlayers()){
				if (TeamManager.team2.contains(player)) {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +20 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " Your team won!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(20);
				} else {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +5 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You participated in a match!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(5);
				}
			}
		} else if (TeamManager.team3.getPoints() > TeamManager.team2.getPoints() 
				&& TeamManager.team3.getPoints() > TeamManager.team1.getPoints() 
				&& TeamManager.team3.getPoints() > TeamManager.team4.getPoints()) {
			
			//Win Message
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team3.getColor() + TeamManager.team3.getColor() + " Wins") + ChatColor.GOLD + ChatColor.BOLD + " < < < <");
			
			for (Player player : Bukkit.getOnlinePlayers()){
				if (TeamManager.team3.contains(player)) {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +20 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " Your team won!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(20);
				} else {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +5 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You participated in a match!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(5);
				}
			}
		} else if (TeamManager.team4.getPoints() > TeamManager.team2.getPoints() 
				&& TeamManager.team4.getPoints() > TeamManager.team3.getPoints() 
				&& TeamManager.team4.getPoints() > TeamManager.team1.getPoints()) {
			
			//Win Message
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team4.getColor() + TeamManager.team4.getName() + " Wins") + ChatColor.GOLD + ChatColor.BOLD + " < < < <");
			
			for (Player player : Bukkit.getOnlinePlayers()){
				if (TeamManager.team4.contains(player)) {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +20 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " Your team won!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(20);
				} else {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +5 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You participated in a match!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(5);
				}
			}
		} else {
			//Draw Message
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > > " + ChatColor.AQUA + ChatColor.BOLD + " DRAW " + ChatColor.GOLD + ChatColor.BOLD + " < < < <");
			
			for (Player player : Bukkit.getOnlinePlayers()){
				if (TeamManager.team1.contains(player) || TeamManager.team2.contains(player) || TeamManager.team3.contains(player) || TeamManager.team4.contains(player)) {
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +10 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " Your team drew!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(10);
				}
				
			}
		}
	}

	public static void countDown() {
		if (countDownInterval < 6 && countDownInterval > 0) {
			SoundUtils.broadcastSound(Sound.ANVIL_LAND);
		} else if (countDownInterval == 0) {
			
		}
		
	}
	
	
	
}
