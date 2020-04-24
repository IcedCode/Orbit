package me.icycode.orbit.listeners;

import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener{
	
	@EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
		if (GameState.IN_LOBBY || GameState.STARTING || GameState.COUNTDOWN /*|| MapInfo.gameMode == "TDM" */|| MapInfo.gameMode.equalsIgnoreCase("Parkour")) {
            event.setCancelled(true);
        }
    }
	
	
}
