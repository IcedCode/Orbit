package me.icycode.orbit.module;

import lombok.Getter;
import lombok.Setter;

public class Hill {
	
	@Getter @Setter public Region region;
	@Getter @Setter public String name;
	
	public Hill(Region r, String n) {
		region = r;
		name = n;
	}
	
}
