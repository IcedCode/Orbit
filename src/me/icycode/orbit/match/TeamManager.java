package me.icycode.orbit.match;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TeamManager {
	
	public static ArrayList<String> spectators = new ArrayList<String>();
	

	public static Team team1 = new Team();
	public static Team team2 = new Team();
	public static Team team3 = new Team();
	public static Team team4 = new Team();

	private static int teamSorter;
	
	public static void resetTeams() {
		team1.reset();
		team2.reset();
		team3.reset();
		team4.reset();
		
		
	}
	
	public static String getPlayerTeamColor(Player player) {
		if (team1.contains(player)) {
			return team1.getColor();
		} else if (team2.contains(player)) {
			return team2.getColor();
		} else if (team3.contains(player)) {
			return team3.getColor();
		} else if (team4.contains(player)) {
			return team4.getColor();
		} else {
			return "&f";
		}
	}
	
	public static void assignPlayerTeam(int teams, Player player) {
		spectators.remove(player.getName());
		if (teams == 1) {
			team1.addPlayer(player);
			player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
		} else if (teams == 2) {
			teamSorter = 0;
			switch (Integer.valueOf(teamSorter)) {
			case 0:
				team1.addPlayer(player);
				teamSorter += 1;
				player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
				break;
			case 1:
				team2.addPlayer(player);
				teamSorter -= 1;
				player.sendMessage(ChatColor.GRAY + "You have joined " + team2.getColoredName());
				break;
			default:
				break;
			}
		} else if (teams == 3) {
			teamSorter = 0;
			switch (Integer.valueOf(teamSorter)) {
			case 0:
				team1.addPlayer(player);
				teamSorter++;
				player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
				break;
			case 1:
				team2.addPlayer(player);
				teamSorter++;
				player.sendMessage(ChatColor.GRAY + "You have joined " + team2.getColoredName());
				break;
			case 2:
				team3.addPlayer(player);
				teamSorter = 0;
				player.sendMessage(ChatColor.GRAY + "You have joined " + team3.getColoredName());
				break;
			default:
				break;
			}
		} else if (teams == 4) {
			teamSorter = 0;
			switch (Integer.valueOf(teamSorter)) {
			case 0:
				team1.addPlayer(player);
				teamSorter++;
				player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
				break;
			case 1:
				team2.addPlayer(player);
				teamSorter++;
				player.sendMessage(ChatColor.GRAY + "You have joined " + team2.getColoredName());
				break;
			case 2:
				team3.addPlayer(player);
				teamSorter++;
				player.sendMessage(ChatColor.GRAY + "You have joined " + team3.getColoredName());
				break;
			case 3:
				team4.addPlayer(player);
				teamSorter = 0;
				player.sendMessage(ChatColor.GRAY + "You have joined " + team4.getColoredName());
				break;
			default:
				break;
			}
		}
	}

	public static void assignAllPlayersTeam(int teams) {
		if (teams == 1) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				team1.addPlayer(player);
				player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
			}
		} else if (teams == 2) {
			teamSorter = 0;
			for (Player player : Bukkit.getOnlinePlayers()) {
				switch (Integer.valueOf(teamSorter)) {
				case 0:
					team1.addPlayer(player);
					teamSorter = 1;
					player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
					break;
				case 1:
					team2.addPlayer(player);
					teamSorter = 0;
					player.sendMessage(ChatColor.GRAY + "You have joined " + team2.getColoredName());
					break;
				default:
					break;
				}
			}
		} else if (teams == 3) {
			teamSorter = 0;
			for (Player player : Bukkit.getOnlinePlayers()) {
				switch (Integer.valueOf(teamSorter)) {
				case 0:
					team1.addPlayer(player);
					teamSorter += 1;
					player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
					break;
				case 1:
					team2.addPlayer(player);
					teamSorter += 1;
					player.sendMessage(ChatColor.GRAY + "You have joined " + team2.getColoredName());
					break;
				case 2:
					team3.addPlayer(player);
					teamSorter = 0;
					player.sendMessage(ChatColor.GRAY + "You have joined " + team3.getColoredName());
					break;
				default:
					break;
				}
			}
		} else if (teams == 4) {
			teamSorter = 0;
			for (Player player : Bukkit.getOnlinePlayers()) {
				switch (Integer.valueOf(teamSorter)) {
				case 0:
					team1.addPlayer(player);
					teamSorter++;
					player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
					break;
				case 1:
					team2.addPlayer(player);
					teamSorter++;
					player.sendMessage(ChatColor.GRAY + "You have joined " + team2.getColoredName());
					break;
				case 2:
					team3.addPlayer(player);
					teamSorter++;
					player.sendMessage(ChatColor.GRAY + "You have joined " + team3.getColoredName());
					break;
				case 3:
					team4.addPlayer(player);
					teamSorter = 0;
					player.sendMessage(ChatColor.GRAY + "You have joined " + team4.getColoredName());
					break;
				default:
					break;
				}
			}
		}
	}
	
	public static Location getSpawn(Player player){
		if (team1.contains(player)) {
			return MapInfo.getTeam1Spawn().getLocation();
		} else if (team2.contains(player)) {
			return MapInfo.getTeam2Spawn().getLocation();
		} else if (team3.contains(player)){
			return MapInfo.getTeam3Spawn().getLocation();
		} else if (team4.contains(player)) {
			return MapInfo.getTeam4Spawn().getLocation();
		} else {
			return null;
		}
		
		
	}

}
