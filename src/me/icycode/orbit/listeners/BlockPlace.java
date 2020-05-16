package me.icycode.orbit.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.material.Wool;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.match.gamemodes.CTW;
import me.icycode.orbit.match.gamemodes.DTM;
import me.icycode.orbit.module.Region;
import me.icycode.orbit.module.WoolCap;
import me.icycode.orbit.utils.Scoreboard;
import me.icycode.orbit.utils.SoundUtils;
import me.icycode.orbit.utils.chat.Chatter;
import net.md_5.bungee.api.ChatColor;

public class BlockPlace implements Listener{
	
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		if (GameState.IN_LOBBY || GameState.STARTING || GameState.COUNTDOWN || /*MapInfo.gameMode == "TDM" ||*/ MapInfo.gameMode.equalsIgnoreCase("Parkour") || MapInfo.gameMode.equalsIgnoreCase("FFA")) {
            event.setCancelled(true);
        }
		
		if(GameState.IN_GAME && MapInfo.gameMode.equalsIgnoreCase("ctw")) {
			for(int i = 0; i < CTW.wools.size() ; i++) {
				if(CTW.wools.get(i).location.equals(event.getBlock().getLocation())) {
					WoolCap wc = CTW.wools.get(i);
					Block block = event.getBlock();
					Player player = event.getPlayer();
					if (block.getType() != Material.WOOL) {
						event.setCancelled(true);
						player.sendMessage(Chatter.Warning() + ChatColor.RED + "You may not alter your objective!");
						return;
					}
					GamePlayer gamePlayer = Main.onlinePlayers.get(event.getPlayer());
					if(wc.team.equals(TeamManager.team1) && !TeamManager.team1.contains(event.getPlayer())) {
						event.setCancelled(true);
						event.getPlayer().sendMessage(Chatter.Warning() + " You may not alter your own objective!");
						break;
					} else if(wc.team.equals(TeamManager.team2) && !TeamManager.team2.contains(event.getPlayer())) {
						event.setCancelled(true);
						event.getPlayer().sendMessage(Chatter.Warning() + " You may not alter your own objective!");
						break;
					}
					
					@SuppressWarnings("deprecation")
					Wool wool = new Wool(block.getType(), block.getData());
					if (wool.getColor() == wc.color) {
						wc.placed = true;
						Scoreboard.CTWUpdate();
						Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > " + ChatColor.translateAlternateColorCodes('&', wc.team.getColor() + event.getPlayer().getName() + " has placed the wool " + wc.name + "!") + ChatColor.GOLD + ChatColor.BOLD + " < < <");
						SoundUtils.broadcastSound(Sound.BLAZE_DEATH);
						player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +20 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You placed a wool!");
						event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.LEVEL_UP, 1, 1);
						gamePlayer.addXp(20);
						CTW.wools.set(i, wc);
						CTW.gameEndCheck();
					}
					
				}
			}
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
