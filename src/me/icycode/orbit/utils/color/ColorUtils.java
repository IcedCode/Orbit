package me.icycode.orbit.utils.color;

import org.bukkit.Color;
import org.bukkit.DyeColor;

public class ColorUtils {
	
	public static Color getColor(String colorString) {
		if (colorString == "&0") {
			return Color.BLACK;
		} else if (colorString == "&1") {
			return Color.NAVY;
		} else if (colorString == "&2") {
			return Color.GREEN;
		} else if (colorString == "&3") {
			return Color.TEAL;
		} else if (colorString == "&4") {
			return Color.MAROON;
		} else if (colorString == "&5") {
			return Color.PURPLE;
		} else if (colorString == "&6") {
			return Color.ORANGE;
		} else if (colorString == "&7") {
			return Color.SILVER;
		} else if (colorString == "&8") {
			return Color.GRAY;
		} else if (colorString== "&9") {
			return Color.BLUE;
		} else if (colorString == "&a") {
			return Color.LIME;
		} else if (colorString == "&b") {
			return Color.AQUA;
		} else if (colorString == "&c") {
			return Color.RED;
		} else if (colorString == "&d") {
			return Color.FUCHSIA;
		} else if (colorString == "&e") {
			return Color.YELLOW;
		} else if (colorString == "&f") {
			return Color.WHITE;
		}
		return null;
	}
	
	public static DyeColor getDyeColor(String colorString) {
		if (colorString == "&0") {
			return DyeColor.BLACK;
		} else if (colorString == "&1") {
			return DyeColor.BLUE;
		} else if (colorString == "&2") {
			return DyeColor.GREEN;
		} else if (colorString == "&3") {
			return DyeColor.BLUE;
		} else if (colorString == "&4") {
			return DyeColor.BROWN;
		} else if (colorString == "&5") {
			return DyeColor.PURPLE;
		} else if (colorString == "&6") {
			return DyeColor.ORANGE;
		} else if (colorString == "&7") {
			return DyeColor.SILVER;
		} else if (colorString == "&8") {
			return DyeColor.GRAY;
		} else if (colorString== "&9") {
			return DyeColor.LIGHT_BLUE;
		} else if (colorString == "&a") {
			return DyeColor.LIME;
		} else if (colorString == "&b") {
			return DyeColor.CYAN;
		} else if (colorString == "&c") {
			return DyeColor.RED;
		} else if (colorString == "&d") {
			return DyeColor.PINK;
		} else if (colorString == "&e") {
			return DyeColor.YELLOW;
		} else if (colorString == "&f") {
			return DyeColor.WHITE;
		}
		return null;
	}
	
}
