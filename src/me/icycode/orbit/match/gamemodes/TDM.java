package me.icycode.orbit.match.gamemodes;

import java.util.ArrayList;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.utils.chat.Chatter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class TDM {
	
	//Kits
	public static ArrayList<String> Barbarian = new ArrayList<String>();
	public static ArrayList<String> Warrior = new ArrayList<String>();
	public static ArrayList<String> Beserker = new ArrayList<String>();
	public static ArrayList<String> Bowman = new ArrayList<String>();
	public static ArrayList<String> Heavy = new ArrayList<String>();
	public static ArrayList<String> Scout = new ArrayList<String>();
	
	public static void kill(Player player){
		if (TeamManager.team1.contains(player)){
			TeamManager.team1.addPoints(1);
		} else if (TeamManager.team2.contains(player)){
			TeamManager.team2.addPoints(1);
		} else if (TeamManager.team3.contains(player)){
			TeamManager.team3.addPoints(1);
		} else if (TeamManager.team4.contains(player)){
			TeamManager.team4.addPoints(1);
		} 
	}
	
	public static void endGameLogic() {
		
		if (TeamManager.team1.getPoints() > TeamManager.team2.getPoints() && TeamManager.team1.getPoints() > TeamManager.team3.getPoints() && TeamManager.team1.getPoints() > TeamManager.team4.getPoints()) {
			
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
		} else if (TeamManager.team2.getPoints() > TeamManager.team1.getPoints() && TeamManager.team2.getPoints() > TeamManager.team3.getPoints() && TeamManager.team2.getPoints() > TeamManager.team4.getPoints()) {
			
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
		} else if (TeamManager.team3.getPoints() > TeamManager.team2.getPoints() && TeamManager.team3.getPoints() > TeamManager.team1.getPoints() && TeamManager.team3.getPoints() > TeamManager.team4.getPoints()) {
			
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
		} else if (TeamManager.team4.getPoints() > TeamManager.team2.getPoints() && TeamManager.team4.getPoints() > TeamManager.team3.getPoints() && TeamManager.team4.getPoints() > TeamManager.team1.getPoints()) {
			
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
	
}
