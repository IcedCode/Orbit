package me.icycode.orbit.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.icycode.orbit.Main;
import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.match.gamemodes.CTW;
import me.icycode.orbit.match.gamemodes.DTM;
import me.icycode.orbit.module.Monument;
import me.icycode.orbit.module.WoolCap;

public class Scoreboard {
	
	public static void DTMUpdate() {
		if(!MapInfo.gameMode.equalsIgnoreCase("dtm")) return;
		if(GameState.IN_GAME || GameState.COUNTDOWN) {
			ScoreboardWrapper board = new ScoreboardWrapper(ChatColor.GOLD + "" + ChatColor.BOLD + "DTM");
	        board.addLine(ChatColor.BOLD + "" + TeamManager.team1.getColoredName());
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
	        board.addLine(ChatColor.BOLD + "" + TeamManager.team2.getColoredName());
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
	
	public static void LobbyUpdate() {
		if(GameState.IN_LOBBY|| GameState.STARTING) {
			ScoreboardWrapper board = new ScoreboardWrapper(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lobby");
			board.addLine(ChatColor.AQUA + "" + ChatColor.BOLD + "Gamemode:");
			board.addLine(ChatColor.GOLD + MapInfo.gameMode.toUpperCase());
			board.addBlankSpace();
			board.addLine(ChatColor.AQUA + "" + ChatColor.BOLD + "Map:");
			board.addLine(ChatColor.GOLD + MapInfo.mapName);
			board.addBlankSpace();
			if (GameState.IN_LOBBY) board.addLine(ChatColor.RED  + "Waiting for players");
			else if(GameState.STARTING) {
				board.addLine(ChatColor.AQUA + "" + ChatColor.BOLD + "Starting in:");
				board.addLine(ChatColor.RED + String.valueOf(Main.lobbyCountdown));
			}
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.setScoreboard(board.getScoreboard());
			}
		}
		
		
	}
	
	public static void TDMUpdate() {
		if(!MapInfo.gameMode.equalsIgnoreCase("tdm")) return;
		if(GameState.IN_GAME || GameState.COUNTDOWN) {
			ScoreboardWrapper board = new ScoreboardWrapper(ChatColor.GOLD + "" + ChatColor.BOLD + "TDM");
	        board.addLine(TeamManager.team1.getColoredName());
			board.addLine(ChatColor.YELLOW + String.valueOf(TeamManager.team1.getPoints()));
	        board.addBlankSpace();
	        board.addLine(TeamManager.team2.getColoredName());
	        board.addLine(ChatColor.YELLOW + String.valueOf(TeamManager.team2.getPoints()));
	        

	        for (Player player : Bukkit.getOnlinePlayers()) {
	        	player.setScoreboard(board.getScoreboard());
	        }
		}
	}
	
	public static void CTWUpdate() {
		if(!MapInfo.gameMode.equalsIgnoreCase("ctw")) return;
		if(GameState.IN_GAME || GameState.COUNTDOWN) {
			ScoreboardWrapper board = new ScoreboardWrapper(ChatColor.GOLD + "" + ChatColor.BOLD + "CTW");
	        board.addLine(ChatColor.BOLD + "" + TeamManager.team1.getColoredName());
			for(int i = 0; i < CTW.wools.size() ; i++) {
	        	WoolCap wool = CTW.wools.get(i);
	        	if(wool.team == TeamManager.team1) {
	        		String state;
	        		if (wool.placed) {
	        			state = ChatColor.GREEN + "✔";
	        		} else if (wool.picked) {
	        			state = ChatColor.GOLD + "-";
	        		} else {
	        			state = ChatColor.RED + "✖";
	        		}
	        		board.addLine(state + " " + ChatColor.translateAlternateColorCodes('&', TeamManager.team1.getColor() + wool.name));
	        	}
	        }
	        board.addBlankSpace();
	        board.addLine(ChatColor.BOLD + "" + TeamManager.team2.getColoredName());
			for(int i = 0; i < CTW.wools.size() ; i++) {
	        	WoolCap wool = CTW.wools.get(i);
	        	if(wool.team == TeamManager.team2) {
	        		String state;
	        		if (wool.placed) {
	        			state = ChatColor.GREEN + "✔";
	        		} else if (wool.picked) {
	        			state = ChatColor.GOLD + "-";
	        		} else {
	        			state = ChatColor.RED + "✖";
	        		}
	        		board.addLine(state + " " + ChatColor.translateAlternateColorCodes('&', TeamManager.team2.getColor() + wool.name));
	        	}
	        }
	        for (Player player : Bukkit.getOnlinePlayers()) {
	        	player.setScoreboard(board.getScoreboard());
	        }
		}
		
	}
	
}
