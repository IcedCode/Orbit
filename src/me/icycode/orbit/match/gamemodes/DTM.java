package me.icycode.orbit.match.gamemodes;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.match.GameManager;
import me.icycode.orbit.match.Team;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.module.Monument;
import me.icycode.orbit.utils.chat.Chatter;

public class DTM {
	
	public static ArrayList<Monument> monuments = new ArrayList<Monument>();
	public static int objectives;
	
	public static void gameEndCheck() {
		int objTeam1 = 0;
		int objTeam2 = 0;
		for(int i = 0; i < monuments.size(); i++) {
			Monument mon = monuments.get(i);
			if(mon.destroyed && mon.team.getName().equalsIgnoreCase(TeamManager.team1.getName())) {
				objTeam1++;
			} else if(mon.destroyed && mon.team.getName().equalsIgnoreCase(TeamManager.team2.getName())) {
				objTeam2++;
			}
			if(objTeam1 == objectives) {
				endGameLogic(TeamManager.team1);
			} else if(objTeam2 == objectives) {
				endGameLogic(TeamManager.team2);
			}
		}
		
	}
	
	public static void endGameLogic(Team team) {
		GameManager.endGame(null);
		if (team == TeamManager.team1) {
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
		} else if (team == TeamManager.team2) {
			
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
		}
		
	}
}
