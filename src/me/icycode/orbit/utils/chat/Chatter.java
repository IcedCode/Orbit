package me.icycode.orbit.utils.chat;

import org.bukkit.ChatColor;

public class Chatter {
	public static String RightArrow() {
		return "»";
	}
	public static String LeftArrow() {
		return "«";
	}
	
	public static String Good() {
		return (ChatColor.DARK_GREEN + "⚠ ");
	}
	
	public static String Info() {
		return (ChatColor.DARK_AQUA + "⚠ ");
	}
	
	public static String Warning() {
		return (ChatColor.YELLOW + "⚠ ");
	}
	
	public static String Severe() {
		return 	(ChatColor.DARK_RED + "⚠ ");
	}
	
	public static String Tip() {
		return (ChatColor.GRAY + "(" + ChatColor.RED + ChatColor.BOLD + ChatColor.ITALIC + "Tip" + ChatColor.RESET + ChatColor.GRAY + ") ");
	}
	
	public static String PermissionWarn() {
		return (Warning() + ChatColor.RED + " You don't have permission to do that.");
	}
}
