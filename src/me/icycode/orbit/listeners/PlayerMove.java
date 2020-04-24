package me.icycode.orbit.listeners;

import me.icycode.orbit.match.GameManager;
import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.gamemodes.CTF;
import me.icycode.orbit.module.Region;

import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		player.setPlayerWeather(WeatherType.CLEAR);
		if (GameState.COUNTDOWN) {
			e.setTo(e.getFrom());
		} else if (GameState.IN_LOBBY || GameState.STARTING) {
			player.setFoodLevel(20);
			if (player.getLocation().getY() < 0) {
				GameManager.teleportToLobby(player);
			}
		}
		
		
		//Parkour
		if (MapInfo.gameMode == "Parkour") {
			player.setFoodLevel(20);
			Location l = player.getLocation();
			Region r = MapInfo.parkourEnd;
			if (r.getLowerX() < l.getX() && r.getLowerY() < l.getY() && r.getLowerZ() < l.getZ() && r.getUpperX() > l.getX() && r.getUpperY() > l.getY() && r.getUpperZ() > l.getZ()){
				GameManager.endGame(player);
			} else if (l.getY() < 0) {
				player.teleport(MapInfo.team1Spawn.location);
			}
		}
		
		if (MapInfo.gameMode.equalsIgnoreCase("CTF")) {
			CTF.flagCheck(player);
		}
	}

}
