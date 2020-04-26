package me.icycode.orbit.listeners;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.match.gamemodes.DTM;
import me.icycode.orbit.module.Monument;
import me.icycode.orbit.utils.SoundUtils;
import me.icycode.orbit.utils.chat.Chatter;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener{
	
	@EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
		if (GameState.IN_LOBBY || GameState.STARTING || GameState.COUNTDOWN /*|| MapInfo.gameMode == "TDM" */|| MapInfo.gameMode.equalsIgnoreCase("Parkour")) {
            event.setCancelled(true);
        }
		
		if(GameState.IN_GAME && MapInfo.gameMode.equalsIgnoreCase("DTM")) {
			for(int i = 0; i < DTM.monuments.size() ; i++) {
				if(DTM.monuments.get(i).location.equals(event.getBlock().getLocation())) {
					Monument m = DTM.monuments.get(i);
					m.destroyed = true;
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > " + ChatColor.translateAlternateColorCodes('&', m.team.getColor() + event.getPlayer().getName() + " has destroyed the monument " + m.name + "!") + ChatColor.GOLD + ChatColor.BOLD + " < < <");
					SoundUtils.broadcastSound(Sound.BLAZE_DEATH);
					event.getPlayer().sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +10 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You destroyed a monument!");
					event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(event.getPlayer());
					gamePlayer.addXp(20);
					DTM.monuments.set(i, m);
					DTM.gameEndCheck();
				}
			}
		}
    }
	
	
}
