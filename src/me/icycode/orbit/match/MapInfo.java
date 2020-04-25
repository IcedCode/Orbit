package me.icycode.orbit.match;


import org.bukkit.World;

import me.icycode.orbit.module.Region;
import me.icycode.orbit.module.Spawn;

public class MapInfo {
	
	public static String mapName;
	public static String version;
	public static String creators;
	public static String worldName;
	public static World world;
	



	public static String gameMode;
	public static int teams;
	
	public static Spawn spectatorSpawn;
	
	public static Spawn team1Spawn;
	public static Spawn team2Spawn;
	public static Spawn team3Spawn;
	public static Spawn team4Spawn;
	
	
	



	//CTH ONLY
	public static Region hill;
	
	//CTF ONLY
	public static Region team1Flag;
	public static Region team2Flag;
	
	//Parkour ONLY
	public static Region parkourEnd;
	
	
	
	public static void resetInfo() {
		version = null;
		world = null;
		gameMode = null;
		mapName = null;
		creators = null;
		
		spectatorSpawn = null;
		
		team1Spawn = null;
		team2Spawn = null;
		team3Spawn = null;
		team4Spawn = null;
		
		hill = null;
		
		team1Flag = null;
		team2Flag = null;
		
		parkourEnd = null;
		
	}
	
	public static World getWorld() {
		return world;
	}



	public static void setWorld(World world) {
		MapInfo.world = world;
	}



	public static Spawn getSpectatorSpawn() {
		return spectatorSpawn;
	}



	public static void setSpectatorSpawn(Spawn spectatorSpawn) {
		MapInfo.spectatorSpawn = spectatorSpawn;
	}



	public static Spawn getTeam1Spawn() {
		return team1Spawn;
	}



	public static void setTeam1Spawn(Spawn team1Spawn) {
		MapInfo.team1Spawn = team1Spawn;
	}



	public static Spawn getTeam2Spawn() {
		return team2Spawn;
	}



	public static void setTeam2Spawn(Spawn team2Spawn) {
		MapInfo.team2Spawn = team2Spawn;
	}



	public static Spawn getTeam3Spawn() {
		return team3Spawn;
	}



	public static void setTeam3Spawn(Spawn team3Spawn) {
		MapInfo.team3Spawn = team3Spawn;
	}



	public static Spawn getTeam4Spawn() {
		return team4Spawn;
	}



	public static void setTeam4Spawn(Spawn team4Spawn) {
		MapInfo.team4Spawn = team4Spawn;
	}





	public static Region getHill() {
		return hill;
	}



	public static void setHill(Region hill) {
		MapInfo.hill = hill;
	}



	public static Region getTeam1Flag() {
		return team1Flag;
	}



	public static void setTeam1Flag(Region team1Flag) {
		MapInfo.team1Flag = team1Flag;
	}



	public static Region getTeam2Flag() {
		return team2Flag;
	}



	public static void setTeam2Flag(Region team2Flag) {
		MapInfo.team2Flag = team2Flag;
	}



	public static Region getParkourEnd() {
		return parkourEnd;
	}



	public static void setParkourEnd(Region parkourEnd) {
		MapInfo.parkourEnd = parkourEnd;
		
	}
}
