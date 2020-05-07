package me.icycode.orbit.match.gamemodes;

import java.util.ArrayList;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;

import me.icycode.orbit.match.TeamManager;

public class RedAlert {
	
	private static ArrayList<Block> red = new ArrayList<Block>();
	private static ArrayList<Block> fall = new ArrayList<Block>();
	
	public static void clear() {

		red.clear();
		fall.clear();
	}
	
	public static void winCheck() {
		//if(TeamManager.team1.getSize() != 1) {
			//return;
		//} Removed for testing
		TeamManager.team1.getPlayers().get(0);
	}
	
	@SuppressWarnings("deprecation")
	public static void addRed(Block block) {
		if(!red.contains(block)) {
			block.setType(Material.STAINED_CLAY);
			block.setData(DyeColor.RED.getData());
			red.add(block);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void addFall() {
		for(Block block : red) {
			red.remove(block);
			Byte blockData = 0x0;
			block.getWorld().spawnFallingBlock(block.getLocation(), block.getType(), blockData);
			block.setType(Material.AIR);
			fall.add(block);
		}
	}
	
}
