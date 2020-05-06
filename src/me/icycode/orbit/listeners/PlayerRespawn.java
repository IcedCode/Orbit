package me.icycode.orbit.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.icycode.orbit.match.GameManager;
import me.icycode.orbit.match.Loadout;
import me.icycode.orbit.match.TeamManager;

public class PlayerRespawn implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		Player player = e.getPlayer();
		GameManager.teleportSpawn(player);
		e.setRespawnLocation(TeamManager.getSpawn(player));
		Loadout.giveLoadout(player);
	}
}
