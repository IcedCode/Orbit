package me.icycode.orbit.listeners;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.match.gamemodes.CTF;
import me.icycode.orbit.utils.Scoreboard;
import me.icycode.orbit.utils.SoundUtils;
import me.icycode.orbit.utils.chat.Chatter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener{
	
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		
		
		
		Player player = e.getEntity();
		
		e.getDrops().clear();
		if (MapInfo.gameMode.equalsIgnoreCase("CTF")) {
			if (CTF.team1FlagHolder == player) {
				CTF.team1FlagHolder = null;
				Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team2.getColor() + player.getName() + " has lost the flag!") + ChatColor.GOLD + ChatColor.BOLD + " < < <");
				SoundUtils.broadcastSound(Sound.SILVERFISH_KILL);
			} else if (CTF.team2FlagHolder == player) {
				CTF.team2FlagHolder = null;
				Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team1.getColor() + player.getName() + " has lost the flag!") + ChatColor.GOLD + ChatColor.BOLD + " < < <");
				SoundUtils.broadcastSound(Sound.SILVERFISH_KILL);
			}
		}
		
		
		if (e.getEntity().getKiller() != null) {
			Player killer = e.getEntity().getKiller();
			String killerName = e.getEntity().getKiller().getDisplayName();
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " was slain by " + TeamManager.getPlayerTeamColor(killer) + killerName + ChatColor.GRAY + "."));
			
			
			 
			if (killer != player) {
				//Team Kill Counter Add
				if (TeamManager.team1.contains(killer)) {
					TeamManager.team1.addPoints(1);
				} else if (TeamManager.team2.contains(killer)) {
					TeamManager.team2.addPoints(1);
				} else if (TeamManager.team3.contains(killer)) {
					TeamManager.team3.addPoints(1);
				} else if (TeamManager.team4.contains(killer)) {
					TeamManager.team4.addPoints(1);
				}
				
				//XP Reward
				GamePlayer gamePlayer = Main.onlinePlayers.get(killer);
				gamePlayer.points++;
				gamePlayer.addXp(2);
				killer.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + " +2 XP " + ChatColor.GOLD + ChatColor.BOLD + Chatter.RightArrow() + ChatColor.GREEN + ChatColor.ITALIC + " Killed " + ChatColor.DARK_GREEN + player.getDisplayName());
				killer.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP , 1, 1);
			}
			Scoreboard.TDMUpdate();
			
			
			
		} else if(e.getDeathMessage().contains("hit the ground too hard") || e.getDeathMessage().contains("fell from a")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " hit the ground too hard."));
			
		} else if (e.getDeathMessage().contains("drowned")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " swam like a brick."));
			
		} else if (e.getDeathMessage().contains("swim in lava")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " tried to swim in lava."));
			
		} else if (e.getDeathMessage().contains("struck by lightning")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " was struck down by lightning."));
			
		} else if (e.getDeathMessage().contains("blew up") || e.getDeathMessage().contains("blown up")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " 'sploded."));
			
		} else if (e.getDeathMessage().contains("went up in flames") || e.getDeathMessage().contains("burned to death")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " went up in flames."));
			
		}  else if (e.getDeathMessage().contains("pricked to death") || e.getDeathMessage().contains("walked into a cactus")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " was pricked to death by a prickly thing."));
			
		} else if (e.getDeathMessage().contains("falling anvil")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " was splatted."));
			
		} else if (e.getDeathMessage().contains("starved")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " starved to death."));
			
		} else if (e.getDeathMessage().contains("suffocated in")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " suffocated."));
			
		} else if (e.getDeathMessage().contains("fell out of the world")) {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " fell into the void."));
		} else {
			
			e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', TeamManager.getPlayerTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " died."));
		}
		
		
		
		
		
		
		
	}
}
