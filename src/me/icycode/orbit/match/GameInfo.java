package me.icycode.orbit.match;

public class GameInfo {
	
	public static String getGameTitle() {
		if (MapInfo.gameMode.equalsIgnoreCase("tdm")) {
			return "Team Deathmatch";
		} else if (MapInfo.gameMode.equalsIgnoreCase("cth")){
			return "Capture The Hill";
		} else if (MapInfo.gameMode.equalsIgnoreCase("parkour")){
			return "Parkour";
		} else if (MapInfo.gameMode.equalsIgnoreCase("CTF")){
			return "Capture The Flag";
		} else {
			return "UNKNOWN";
		}
	}
	
	public static String getGameInfo() {
		if (MapInfo.gameMode.equalsIgnoreCase("tdm")) {
			return "Be the team with the most kills in 10 minutes!";
		} else if (MapInfo.gameMode.equalsIgnoreCase("cth")) {
			return "Capture the hill and get kills for points, first to 100 wins!";
		} else return "UNKNOWN";
	}
	
}
