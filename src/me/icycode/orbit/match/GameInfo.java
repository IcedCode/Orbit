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
		} else if (MapInfo.gameMode.equalsIgnoreCase("DTM")){
			return "Destroy The Monument";
		} else if (MapInfo.gameMode.equalsIgnoreCase("FFA")){
			return "Free For All";
		} else if (MapInfo.gameMode.equalsIgnoreCase("CTW")){
			return "Capture The Wool";
		} else {
			return "UNKNOWN";
		}
	}
	
	public static String getGameInfo() {
		if (MapInfo.gameMode.equalsIgnoreCase("tdm")) {
			return "Be the team with the most kills in 10 minutes!";
		} else if (MapInfo.gameMode.equalsIgnoreCase("cth")) {
			return "Capture the hill and get kills for points, first to 150 wins!";
		} else if (MapInfo.gameMode.equalsIgnoreCase("dtm")) {
			return "Destroy the opposing teams monuments to win!";
		} else if (MapInfo.gameMode.equalsIgnoreCase("ffa")) {
			return "Every man for themselves, get as many kills as possible in the time!";
		} else if (MapInfo.gameMode.equalsIgnoreCase("ctw")) {
			return "Retrieve the wool from the enemy's side and place it on your team's monument.";
		} else return "UNKNOWN";
	}
	
}
