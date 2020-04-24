package me.icycode.orbit.match;

import org.bukkit.World;

import lombok.Getter;
import lombok.Setter;
import me.icycode.orbit.module.Region;
import me.icycode.orbit.module.Spawn;

public class MapInfo {
	
	public static String mapName;
	public static String version;
	public static String creators;
	public static World world;
	public static String gameMode;
	public static int teams;
	
	@Getter @Setter public static Spawn spectatorSpawn;
	
	@Getter @Setter public static Spawn team1Spawn;
	@Getter @Setter public static Spawn team2Spawn;
	@Getter @Setter public static Spawn team3Spawn;
	@Getter @Setter public static Spawn team4Spawn;
	
	//Regeneration
	@Getter @Setter public static Region mapBox;
	
	//CTH ONLY
	@Getter @Setter public static Region hill;
	
	//CTF ONLY
	@Getter @Setter public static Region team1Flag;
	@Getter @Setter public static Region team2Flag;
	
	//Parkour ONLY
	@Getter @Setter public static Region parkourEnd;
	
	
	
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
}
