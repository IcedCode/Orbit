package me.icycode.orbit.listeners;

import me.icycode.orbit.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class PlayerKick implements Listener{
	
	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {
		Player player = e.getPlayer();
		Main.onlinePlayers.remove(player);
	}
	
}
