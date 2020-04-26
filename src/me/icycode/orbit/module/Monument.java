package me.icycode.orbit.module;

import org.bukkit.Location;

import lombok.Getter;
import lombok.Setter;
import me.icycode.orbit.match.Team;

public class Monument {
	
	@Getter @Setter public Location location;
	@Getter @Setter public Team team;
	@Getter @Setter public boolean destroyed;
	@Getter @Setter public String name;
	
	public Monument(Location l, Team t, String n) {
		location = l;
		team = t;
		destroyed = false;
		name = n;
	}
	
}
