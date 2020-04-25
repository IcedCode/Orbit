package me.icycode.orbit.match;

import me.icycode.orbit.Main;
import me.icycode.orbit.match.gamemodes.CTF;
import me.icycode.orbit.utils.SoundUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.connorlinfoot.titleapi.TitleAPI;

public class Countdowns {
	
	public static void lobbyCountdown(int time) {
		if (time % 15 == 0 && time > 0) {
			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "The match on " + ChatColor.DARK_GREEN + ChatColor.BOLD + MapInfo.mapName + ChatColor.GREEN + " is starting in " + ChatColor.DARK_GREEN + ChatColor.BOLD + time + ChatColor.GREEN + " seconds.");
			SoundUtils.broadcastSound(Sound.CLICK);
		} else if (time <= 5 && time > 1) {
			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "The match on " + ChatColor.DARK_GREEN + ChatColor.BOLD + MapInfo.mapName + ChatColor.GREEN + " is starting in " + ChatColor.DARK_GREEN + ChatColor.BOLD + time + ChatColor.GREEN + " seconds.");
			SoundUtils.broadcastSound(Sound.NOTE_PLING);
		} else if (time == 1) {
			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "The match on " + ChatColor.DARK_GREEN + ChatColor.BOLD + MapInfo.mapName + ChatColor.GREEN + " is starting in " + ChatColor.DARK_GREEN + ChatColor.BOLD + time + ChatColor.GREEN + " second.");
			SoundUtils.broadcastSound(Sound.NOTE_PLING);
		} else if (time == 0) {
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (TeamManager.team1.contains(player)) {
					player.teleport(MapInfo.getTeam1Spawn().location);
				} else if (TeamManager.team2.contains(player)) {
					player.teleport(MapInfo.getTeam2Spawn().location);
				} else if (TeamManager.team3.contains(player)) {
					player.teleport(MapInfo.getTeam3Spawn().location);
				} else if (TeamManager.team4.contains(player)) {
					player.teleport(MapInfo.getTeam4Spawn().location);
				} else if (TeamManager.spectators.contains(player.getName())){
					player.teleport(MapInfo.getSpectatorSpawn().location);
					player.setGameMode(GameMode.SPECTATOR);
				}
				Loadout.giveLoadout(player);
				player.setGameMode(GameMode.SPECTATOR);
				
			}
			SoundUtils.broadcastSound(Sound.NOTE_BASS);
			GameState.setCountdown();
			Main.gameCountdown = 8; //Allows time for tp for slow clients (+3 secs)
			
			
		}
		
	}
	
	public static void gameCountdown(int Time) {
		if (Time < 6 && Time > 1) {
			for (Player player : Bukkit.getServer().getOnlinePlayers()) {
				TitleAPI.sendTitle(player, 5, 12, 3, "" + ChatColor.GREEN + Time + " seconds left", "" + ChatColor.RED + ChatColor.BOLD + ChatColor.UNDERLINE + GameInfo.getGameTitle());
			}
			SoundUtils.broadcastSound(Sound.ANVIL_LAND);
		} else if (Time == 1) {
			for (Player player : Bukkit.getServer().getOnlinePlayers()) {
				TitleAPI.sendTitle(player, 5, 12, 3, "" + ChatColor.GREEN + Time + " second left", "" + ChatColor.RED + ChatColor.BOLD + ChatColor.UNDERLINE + GameInfo.getGameTitle());
			}
			SoundUtils.broadcastSound(Sound.ANVIL_LAND);
		} else if (Time == 0) {
			for (Player player : Bukkit.getServer().getOnlinePlayers()) {
				TitleAPI.sendTitle(player, 5, 35, 5, "", "" + ChatColor.RED + ChatColor.BOLD + ChatColor.UNDERLINE + "The match has begun!");
			}
			SoundUtils.broadcastSound(Sound.WITHER_SPAWN);
			if (MapInfo.gameMode.equalsIgnoreCase("TDM") || MapInfo.gameMode.equalsIgnoreCase("Parkour") || MapInfo.gameMode.equalsIgnoreCase("CTF")) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (!TeamManager.spectators.contains(player.getName())) {
						player.setGameMode(GameMode.ADVENTURE);
					}
				}
				if (MapInfo.gameMode.equalsIgnoreCase("TDM")) {
					Main.gameTime = 60 * 2;
				}
				
				if (MapInfo.gameMode.equalsIgnoreCase("CTF")) {
					CTF.resetInfo();
				}
			}
			GameState.setIn_Game();
		}
	}
	
	public static void gameTimeCountdown(int Time) {
		if (Time % 60 == 0 && Time > 0 && Time != 60) {
			int minutes = Time / 60;
			Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "There are " + ChatColor.DARK_AQUA + minutes + ChatColor.AQUA + " minutes remaining.");
			SoundUtils.broadcastSound(Sound.CLICK);
		} else if (Time == 60) {
			int minutes = Time / 60;
			Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "There is " + ChatColor.DARK_AQUA + minutes + ChatColor.AQUA + " minute remaining.");
			SoundUtils.broadcastSound(Sound.CLICK);
		} else if (Time == 30) {
			Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "There are " + ChatColor.DARK_AQUA + Time + ChatColor.AQUA + " seconds remaining.");
			SoundUtils.broadcastSound(Sound.CLICK);
		} else if (Time < 11 && Time > 1) {
			Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "There are " + ChatColor.DARK_AQUA + Time + ChatColor.AQUA + " seconds remaining.");
			SoundUtils.broadcastSound(Sound.CLICK);
		} else if (Time == 1) {
			Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "There is " + ChatColor.DARK_AQUA + Time + ChatColor.AQUA + " second remaining.");
			SoundUtils.broadcastSound(Sound.CLICK);
		} else if (Time == 0) {
			GameManager.endGame(null);
		}
	}
	
	
}
