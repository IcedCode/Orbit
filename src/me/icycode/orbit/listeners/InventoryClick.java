package me.icycode.orbit.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.gamemodes.CTW;
import me.icycode.orbit.module.Region;
import me.icycode.orbit.module.WoolCap;
import me.icycode.orbit.utils.Scoreboard;
import me.icycode.orbit.utils.SoundUtils;
import net.md_5.bungee.api.ChatColor;

public class InventoryClick implements Listener{
	
	@EventHandler
	public void onInventoryMoveItemEvent(InventoryMoveItemEvent event) {
		
		if (MapInfo.gameMode.equalsIgnoreCase("ctw")) {
			 Player player = (Player) event.getSource().getHolder();
			 Material material = event.getItem().getType();
			 if (material == Material.WOOL) {
				 for(int i = 0; i < CTW.wools.size() ; i++) {
					 WoolCap wc = CTW.wools.get(i);
					 Region r = wc.woolRoom;
					 Location l = player.getLocation();
					 if (r.getLowerX() < l.getX() 
								&& r.getLowerY() < l.getY() 
								&& r.getLowerZ() < l.getZ() 
								&& r.getUpperX() > l.getX() 
								&& r.getUpperY() > l.getY() 
								&& r.getUpperZ() > l.getZ()){
						 wc.picked = true;
						 CTW.wools.set(i, wc);
						 Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > " + ChatColor.translateAlternateColorCodes('&', wc.team.getColor() + player.getName() + " has placed the wool " + wc.name + "!") + ChatColor.GOLD + ChatColor.BOLD + " < < <");
						 SoundUtils.broadcastSound(Sound.ENDERMAN_HIT);
						 Scoreboard.CTWUpdate();
					 }
				 }
			}
		}
	}
		
	
}
