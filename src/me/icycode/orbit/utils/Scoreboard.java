package me.icycode.orbit.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.match.gamemodes.DTM;
import me.icycode.orbit.module.Monument;

public class Scoreboard {
	
	public static void DTMUpdate() {
		if(!MapInfo.gameMode.equalsIgnoreCase("dtm")) return;
		ScoreboardWrapper board = new ScoreboardWrapper(ChatColor.DARK_RED + "" + ChatColor.BOLD + "DTM");
        board.addLine(TeamManager.team1.getColoredName());
		for(int i = 0; i < DTM.monuments.size() ; i++) {
        	Monument mon = DTM.monuments.get(i);
        	if(mon.team == TeamManager.team1) {
        		String state;
        		if (mon.destroyed) {
        			state = ChatColor.GREEN + "✔";
        		} else {
        			state = ChatColor.RED + "✖";
        		}
        		board.addLine(state + " " + ChatColor.translateAlternateColorCodes('&', TeamManager.team1.getColor() + mon.name));
        	}
        }
        board.addBlankSpace();
        board.addLine(TeamManager.team2.getColoredName());
        for(int i = 0; i < DTM.monuments.size() ; i++) {
        	Monument mon = DTM.monuments.get(i);
        	if(mon.team == TeamManager.team2) {
        		String state;
        		if (mon.destroyed) {
        			state = ChatColor.GREEN + "✔";
        		} else {
        			state = ChatColor.RED + "✖";
        		}
        		board.addLine(state + " " + ChatColor.translateAlternateColorCodes('&', TeamManager.team2.getColor() + mon.name));
        	}
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
        	player.setScoreboard(board.getScoreboard());
        }
	}
	
}
