package me.icycode.orbit.match;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Team {
	
	private String name;
	private String color;
	private ArrayList<String> players = new ArrayList<String>();
	
	private int points;
	
	
	
	public Team() {
		this.name = null;
		this.color = null;
	}

	//Getters
	public String getName() {
		return this.name;
	}
	
	public String getColoredName() {
		String teamName = ChatColor.translateAlternateColorCodes('&', this.color + this.name);
		return teamName;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getPoints() {
		return points;
	}
	
	public ArrayList<String> getPlayers() {
		return players;
	}
	
	public int getSize() {
		return players.size();
	}
	
	//Setters
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addPlayer(Player player) {
		players.add(player.getName());
	}
	
	public void removePlayer(Player player) {
		players.remove(player.getName());
	}
	
	public void reset() {
		players.clear();
		points = 0;
		name = null;
		color = null;
	}
	
	public void addPoints(int points) {
		this.points += points;
	}
	
	//Checker
	public boolean contains(Player player) {
		if (players.contains(player.getName())) {
			return true;
		} else {
			return false;
		}
	}
	
}
