package me.icycode.orbit.listeners;

import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.gamemodes.DTM;
import me.icycode.orbit.module.Region;
import me.icycode.orbit.utils.chat.Chatter;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener{
	
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		if (GameState.IN_LOBBY || GameState.STARTING || GameState.COUNTDOWN || /*MapInfo.gameMode == "TDM" ||*/ MapInfo.gameMode.equalsIgnoreCase("Parkour")) {
            event.setCancelled(true);
        }
		
		//Restricted zone check
				if(GameState.IN_GAME) {
					for (int i = 0; i < MapInfo.protectedZones.size(); i++) {
						Region r = MapInfo.protectedZones.get(i);
						Location l = event.getBlock().getLocation();
						if (r.getLowerX() < l.getX() 
								&& r.getLowerY() < l.getY() 
								&& r.getLowerZ() < l.getZ() 
								&& r.getUpperX() > l.getX() 
								&& r.getUpperY() > l.getY() 
								&& r.getUpperZ() > l.getZ()){
							event.getPlayer().sendMessage(Chatter.Warning() + "You may not edit this!");
							event.setCancelled(true);
						}
					}
				}
		
				
				if(GameState.IN_GAME && MapInfo.gameMode.equalsIgnoreCase("dtm")) {
					for(int i = 0; i < DTM.monuments.size() ; i++) {
						if(DTM.monuments.get(i).location.equals(event.getBlock().getLocation())) {
							event.getPlayer().sendMessage(Chatter.Warning() + "You may not edit this block!");
							event.setCancelled(true);
						}
				}
			}
	}
	
}
