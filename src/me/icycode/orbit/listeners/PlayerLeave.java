package me.icycode.orbit.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.icycode.orbit.Main;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.utils.chat.Chatter;

public class PlayerLeave implements Listener {

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		Main.playersOnline -= 1;
		Player player = e.getPlayer();
		Main.onlinePlayers.remove(player);
		e.setQuitMessage(ChatColor.DARK_GRAY + "(" + ChatColor.DARK_RED + ChatColor.ITALIC + "-" + ChatColor.DARK_GRAY + ") " + ChatColor.translateAlternateColorCodes('&', Chatter.getPrefix(player) + " " + TeamManager.getPlayerTeamColor(player) + ChatColor.AQUA + player.getDisplayName()));
		if (TeamManager.team1.contains(player)) {
			TeamManager.team1.removePlayer(player);
		} else if (TeamManager.team2.contains(player)) {
			TeamManager.team2.removePlayer(player);
		} else if (TeamManager.team3.contains(player)) {
			TeamManager.team3.removePlayer(player);
		} else if (TeamManager.team4.contains(player)) {
			TeamManager.team4.removePlayer(player);
		} else if (TeamManager.spectators.contains(player.getName())) {
			TeamManager.spectators.remove(player.getName());
		}
	}
}
