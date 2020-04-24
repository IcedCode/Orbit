package me.icycode.orbit.listeners;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.match.GameManager;
import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.utils.player.Inventory;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		Player player = e.getPlayer();
		
		Main.onlinePlayers.put(player, new GamePlayer(player));
		
		e.setJoinMessage(ChatColor.DARK_GRAY + "(" + ChatColor.DARK_GREEN + ChatColor.ITALIC + "+" + ChatColor.DARK_GRAY + ") " + ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(player).getPrefix()) + " " + ChatColor.AQUA + player.getDisplayName());
		
		Inventory.clear(player);
		
		Main.playersOnline += 1;
		
		if (GameState.IN_LOBBY || GameState.STARTING) {
			player.setGameMode(GameMode.ADVENTURE);
			GameManager.teleportToLobby(player);
		}
		
		if (GameState.STARTING) {
			TeamManager.assignPlayerTeam(1, e.getPlayer());
		}
		
		if (GameState.COUNTDOWN || GameState.IN_GAME) {
			player.setGameMode(GameMode.SPECTATOR);
			TeamManager.spectators.add(player.getName());
			player.teleport(MapInfo.getSpectatorSpawn().getLocation());
		}
		
		if (Main.playersOnline >= 2) {
			

			if (GameState.IN_LOBBY) {
				Main.lobbyCountdown = 60;
				TeamManager.assignAllPlayersTeam(MapInfo.teams);
				GameState.setStarting();
			}
		}
	}

}
