package me.icycode.orbit;

import lombok.Getter;

import org.bukkit.entity.Player;

public class GamePlayer {
	
	private Player player;
	@Getter public int xp;
	@Getter public int prestige;
	
	public GamePlayer(Player player) {
		this.player = player;
		this.xp = 0; //TODO retrieve XP.
		this.prestige = 0;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void addXp(int increment){
		xp += increment;
	}
	
	public void removeXp(int decrement) {
		xp -= decrement;
	}
	
	public void resetXp() {
		xp = 0;
	}
	
	public void prestige() {
		prestige += 1;
	}
	
	public int getXpLevel() {
		if (xp >= 8850) {
			return 50;
		} else if (xp >= 8181) {
			return 49;
		} else if (xp >= 7562) {
			return 48;
		} else if (xp >= 6989) {
			return 47;
		} else if (xp >= 6458) {
			return 46;
		} else if (xp >= 5966) {
			return 45;
		} else if (xp >= 5510) {
			return 44;
		} else if (xp >= 5088) {
			return 43;
		} else if (xp >= 4697) {
			return 42;
		} else if (xp >= 4335) {
			return 41;
		} else if (xp >= 4000) {
			return 40;
		} else if (xp >= 3690) {
			return 39;
		} else if (xp >= 3403) {
			return 38;
		} else if (xp >= 3137) {
			return 37;
		} else if (xp >= 2891) {
			return 36;
		} else if (xp >= 2663) {
			return 35;
		} else if (xp >= 2452) {
			return 34;
		} else if (xp >= 2257) {
			return 33;
		} else if (xp >= 2076) {
			return 32;
		} else if (xp >= 1908) {
			return 31;
		} else if (xp >= 1752) {
			return 30;
		} else if (xp >= 1608) {
			return 29;
		} else if (xp >= 1475) {
			return 28;
		} else if (xp >= 1352) {
			return 27;
		} else if (xp >= 1238) {
			return 26;
		} else if (xp >= 1132) {
			return 25;
		} else if (xp >= 1034) {
			return 24;
		} else if (xp >= 943) {
			return 23;
		} else if (xp >= 859) {
			return 22;
		} else if (xp >= 781) {
			return 21;
		} else if (xp >= 709) {
			return 20;
		} else if (xp >= 642) {
			return 19;
		} else if (xp >= 580) {
			return 18;
		} else if (xp >= 523) {
			return 17;
		} else if (xp >= 470) {
			return 16;
		} else if (xp >= 421) {
			return 15;
		} else if (xp >= 376) {
			return 14;
		} else if (xp >= 334) {
			return 13;
		} else if (xp >= 295) {
			return 12;
		} else if (xp >= 259) {
			return 11;
		} else if (xp >= 226) {
			return 10;
		} else if (xp >= 195) {
			return 9;
		} else if (xp >= 166) {
			return 8;
		} else if (xp >= 139) {
			return 7;
		} else if (xp >= 114) {
			return 6;
		} else if (xp >= 91) {
			return 5;
		} else if (xp >= 70) {
			return 4;
		} else if (xp >= 51) {
			return 3;
		} else if (xp >= 33) {
			return 2;
		} else {
			return 1;
		}
		
	}
	
}
