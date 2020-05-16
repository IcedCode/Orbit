package me.icycode.orbit.match;


import java.util.ArrayList;

import org.bukkit.World;

import me.icycode.orbit.match.gamemodes.CTH;
import me.icycode.orbit.match.gamemodes.CTW;
import me.icycode.orbit.match.gamemodes.DTM;
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
	
	public static ArrayList<Spawn> team1Spawns = new ArrayList<Spawn>();
	public static ArrayList<Spawn> team2Spawns = new ArrayList<Spawn>();
	public static ArrayList<Spawn> team3Spawns = new ArrayList<Spawn>();
	public static ArrayList<Spawn> team4Spawns = new ArrayList<Spawn>();
	
	public static ArrayList<Region> protectedZones = new ArrayList<Region>();

	
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
		
		team1Spawns.clear();
		team2Spawns.clear();
		team3Spawns.clear();
		team4Spawns.clear();
		
		protectedZones.clear();
		
		CTH.hill = null;
		
		team1Flag = null;
		team2Flag = null;
		
		parkourEnd = null;
		
		DTM.monuments.clear();
		DTM.objectives = 0;
		
		CTW.wools.clear();
		CTW.objectives = 0;
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
