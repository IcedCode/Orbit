package me.icycode.orbit.match;

import me.icycode.orbit.Main;
import me.icycode.orbit.match.gamemodes.CTF;
import me.icycode.orbit.match.gamemodes.Parkour;
import me.icycode.orbit.match.gamemodes.TDM;
import me.icycode.orbit.utils.Scoreboard;
import me.icycode.orbit.utils.SoundUtils;
import me.icycode.orbit.utils.player.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;


public class GameManager {
	
	public static void teleportToLobby(Player player){
		Location location = new Location(Bukkit.getServer().getWorld("Lobby"), 2.5, 66, 8.5);
		player.teleport(location);
	}
	
	public static void endGame(Player playerWinner) {
		
		
		GameState.setIn_Lobby();
		
		if (MapInfo.gameMode == "TDM") {
			TDM.endGameLogic();
		} else if (MapInfo.gameMode == "CTH") {
			//TODO: CTH.endGameLogic();
		} else if (MapInfo.gameMode.equalsIgnoreCase("Parkour")) {
			Parkour.endGameLogic(playerWinner);
		} else if (MapInfo.gameMode.equalsIgnoreCase("CTF")) {
			CTF.endGameLogic();
		}
		
		TeamManager.resetTeams();
		MapInfo.resetInfo();
		
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.closeInventory();
			Inventory.clear(player);
			player.setHealth(20);
			player.setFoodLevel(20);
			player.setGameMode(GameMode.ADVENTURE);
			teleportToLobby(player);
		}
		
		SoundUtils.broadcastSound(Sound.WITHER_DEATH);
		

		
		if (Main.playersOnline >= 2) {
			GameState.setStarting();
			Main.lobbyCountdown = 60;
			TeamManager.assignAllPlayersTeam(MapInfo.teams);
			GameState.setStarting();
		}
		
		RotationManager.setNextMap();
		Scoreboard.LobbyUpdate();
	}
	
	public static void teleportSpawn(Player player) {
		if (TeamManager.team1.contains(player)) {
			player.teleport(MapInfo.getTeam1Spawn().location);
			
		} else if (TeamManager.team2.contains(player)) {
			player.teleport(MapInfo.getTeam2Spawn().location);
			
		} else if (TeamManager.team3.contains(player)) {
			player.teleport(MapInfo.getTeam3Spawn().location);
			
		} else if (TeamManager.team4.contains(player)) {
			player.teleport(MapInfo.getTeam4Spawn().location);
			
		}
	}
	
	
	
}
