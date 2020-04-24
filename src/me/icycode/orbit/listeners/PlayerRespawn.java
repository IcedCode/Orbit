package me.icycode.orbit.listeners;

import me.icycode.orbit.match.Loadout;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.TeamManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		Player player = e.getPlayer();
		
		
		
		if (TeamManager.team1.contains(player)) {
			
			e.setRespawnLocation(MapInfo.getTeam1Spawn().location);
			Loadout.giveLoadout(player);
			
		} else if (TeamManager.team2.contains(player)) {
			e.setRespawnLocation(MapInfo.getTeam2Spawn().location);
			Loadout.giveLoadout(player);
			
		} else if (TeamManager.team3.contains(player)) {
			e.setRespawnLocation(MapInfo.getTeam3Spawn().location);
			Loadout.giveLoadout(player);
			
		} else if (TeamManager.team4.contains(player)) {
			e.setRespawnLocation(MapInfo.getTeam4Spawn().location);
			Loadout.giveLoadout(player);
			
		} 
	}
}
