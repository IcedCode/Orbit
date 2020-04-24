package me.icycode.orbit.listeners;

import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.TeamManager;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {
	
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) { // Triggered whenever an entity damages another entity
		
		if (GameState.IN_LOBBY || GameState.STARTING) {
			e.setCancelled(true);
			Player player = (Player) e.getEntity();
			player.setHealth(20);
		}
		
		if(!(GameState.IN_GAME)) {
			return;
		}
		
		
		
	    if(!(e.getEntity() instanceof Player)) {
	        // Victim is not a player
	        return;
	    }
	 
	    // Cast victim
	    Player victim = (Player) e.getEntity();
	 
	    // Create an empty player object to store attacker
	    Player attacker = null;
	 
	    if(e.getDamager() instanceof Player) {
	        // Attacker is a player (melee damage)
	        attacker = (Player) e.getDamager();
	    } else if(e.getDamager() instanceof Arrow) {
	        // Attacker is an arrow (projectile damage)
	        Arrow arrow = (Arrow) e.getDamager();
	        if(!(arrow.getShooter() instanceof Player)) {
	            // Arrow was not fired by a player
	            return;
	        }
	        // Cast attacker
	        attacker = (Player) arrow.getShooter();
	    } else if(e.getDamager() instanceof ThrownPotion) {
	        /* Splash potion of harming triggers this event because it deals direct damage,
	        but we will deal with that kind of stuff in PotionSplashEvent instead */
	        return;
	    }
	    
	    // Just a quick null check for the attacker, in case I missed something
	    if(attacker == null) {
	        return;
	    }
	    
	    if(MapInfo.gameMode == "FFA" || MapInfo.gameMode.equalsIgnoreCase("Parkour")) {
	    	return;
	    }
	    
	    // Check the teams
	    if(TeamManager.team1.contains(attacker) && TeamManager.team1.contains(victim)) {
	        e.setCancelled(true);
	    } else if (TeamManager.team2.contains(attacker) && TeamManager.team2.contains(victim)){
	    	e.setCancelled(true);
	    } else if (TeamManager.team3.contains(attacker) && TeamManager.team3.contains(victim)){
	    	e.setCancelled(true);
	    } else if (TeamManager.team4.contains(attacker) && TeamManager.team4.contains(victim)){
	    	e.setCancelled(true);
	    }
	}
}
