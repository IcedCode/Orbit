package me.icycode.orbit.module;

import lombok.Getter;
import me.icycode.orbit.match.Team;

import org.bukkit.World;

public class Map {
	
	//Basics
	@Getter private String mapName;
	@Getter private String version;
	@Getter private String creators;
	@Getter private World world;
	@Getter private GameMode gamemode;
	
	
	public Map(String mapName, String version, String creators, String worldName, GameMode gamemode, int teams, Team team1, Team team2, Team team3, Team team4) {
		this.mapName = mapName;
		this.version = version;
		this.creators = creators;
		this.gamemode = gamemode;
	}
	
	
}
