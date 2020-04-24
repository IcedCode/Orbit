package me.icycode.orbit.module;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.Location;
import org.bukkit.World;

public class Spawn {
	
	@Getter @Setter public Location location;
	
	public Spawn(World world, double x, double y, double z, float yaw, float pitch) {
		Location l = new Location(world, x, y, z, yaw, pitch);
		location = l;
	}
	
	
}
