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
	
	private static int team1SpawnCounter;
	private static int team2SpawnCounter;
	private static int team3SpawnCounter;
	private static int team4SpawnCounter;

	private static int teamSorter;
	
	public static void resetTeams() {
		team1.reset();
		team2.reset();
		team3.reset();
		team4.reset();
		
		team1SpawnCounter = 0;
		team2SpawnCounter = 0;
		team3SpawnCounter = 0;
		team4SpawnCounter = 0;
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
			if  (team2.getSize() < team1.getSize()) {
				team2.addPlayer(player);
				player.sendMessage(ChatColor.GRAY + "You have joined " + team2.getColoredName());
			} else {
				team1.addPlayer(player);
				player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
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
				if  (team2.getSize() < team1.getSize()) {
					team2.addPlayer(player);
					player.sendMessage(ChatColor.GRAY + "You have joined " + team2.getColoredName());
				} else {
					team1.addPlayer(player);
					player.sendMessage(ChatColor.GRAY + "You have joined " + team1.getColoredName());
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
	
	/*This method returns the Location of spawn for a given player using a counter to cycle
	 * between the different spawns for each team. This is especially useful in FFA where 1
	 * team (team1) will have multiple spawns to cycle through.
	 */
	
	public static Location getSpawn(Player player){
		if (team1.contains(player)) {
			team1SpawnCounter++;
			if(team1SpawnCounter >= MapInfo.team1Spawns.size()) 
				team1SpawnCounter = 0;
			return MapInfo.team1Spawns.get(team1SpawnCounter).location;
		} else if (team2.contains(player)) {
			team2SpawnCounter++;
			if(team2SpawnCounter >= MapInfo.team2Spawns.size()) 
				team2SpawnCounter = 0;
			return MapInfo.team2Spawns.get(team2SpawnCounter).location;
		} else if (team3.contains(player)){
			team3SpawnCounter++;
			if(team3SpawnCounter >= MapInfo.team3Spawns.size()) 
				team3SpawnCounter = 0;
			return MapInfo.team3Spawns.get(team3SpawnCounter).location;
		} else if (team4.contains(player)) {
			team4SpawnCounter++;
			if(team4SpawnCounter >= MapInfo.team4Spawns.size()) 
				team4SpawnCounter = 0;
			return MapInfo.team4Spawns.get(team4SpawnCounter).location;
		} else if (spectators.contains(player.getName())){
			return MapInfo.getSpectatorSpawn().location;
		} else {
			return null;
		}
	}

}
