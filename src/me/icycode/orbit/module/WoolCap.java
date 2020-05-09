package me.icycode.orbit.module;

import org.bukkit.DyeColor;
import org.bukkit.Location;

import lombok.Getter;
import lombok.Setter;
import me.icycode.orbit.match.Team;
import me.icycode.orbit.match.gamemodes.CTW;
import me.icycode.orbit.utils.chat.Chatter;

public class WoolCap {
	
	@Getter @Setter public Location location;
	@Getter @Setter public Team team;
	@Getter @Setter public boolean picked;
	@Getter @Setter public boolean placed;
	@Getter @Setter public String name;
	@Getter @Setter public DyeColor color; 
	@Getter @Setter public Region woolRoom;
	
	public WoolCap(Location l, Team t, String n, DyeColor d, Region wRoom) {
		location = l;
		team = t;
		picked = false;
		placed = false;
		name = n;
		color = d;
		woolRoom = wRoom;
	}
	
}