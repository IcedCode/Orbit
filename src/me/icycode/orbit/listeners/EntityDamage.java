package me.icycode.orbit.listeners;

import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class EntityDamage implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			if (GameState.IN_LOBBY || GameState.STARTING) {
				event.setCancelled(true);
				Player player = (Player) event.getEntity();
				player.setHealth(20);
			} else if (MapInfo.gameMode.equalsIgnoreCase("Parkour") && event.getCause().equals(DamageCause.FALL)) {
				event.setCancelled(true);
				Player player = (Player) event.getEntity();
				player.setHealth(20);
			}
		}
	}
}
