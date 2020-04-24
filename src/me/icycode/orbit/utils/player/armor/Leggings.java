package me.icycode.orbit.utils.player.armor;

import me.icycode.orbit.match.TeamManager;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Leggings {
	
	public static void give(Player player) {
		//Item Creation



		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) leggings.getItemMeta();
		
		if (TeamManager.team1.contains(player)) {
			if (TeamManager.team1.getColor() == "&0") {
				meta.setColor(Color.BLACK);
			} else if (TeamManager.team1.getColor() == "&1") {
				meta.setColor(Color.NAVY);
			} else if (TeamManager.team1.getColor() == "&2") {
				meta.setColor(Color.GREEN);
			} else if (TeamManager.team1.getColor() == "&3") {
				meta.setColor(Color.TEAL);
			} else if (TeamManager.team1.getColor() == "&4") {
				meta.setColor(Color.MAROON);
			} else if (TeamManager.team1.getColor() == "&5") {
				meta.setColor(Color.PURPLE);
			} else if (TeamManager.team1.getColor() == "&6") {
				meta.setColor(Color.ORANGE);
			} else if (TeamManager.team1.getColor() == "&7") {
				meta.setColor(Color.SILVER);
			} else if (TeamManager.team1.getColor() == "&8") {
				meta.setColor(Color.GRAY);
			} else if (TeamManager.team1.getColor()== "&9") {
				meta.setColor(Color.BLUE);
			} else if (TeamManager.team1.getColor() == "&a") {
				meta.setColor(Color.LIME);
			} else if (TeamManager.team1.getColor() == "&b") {
				meta.setColor(Color.AQUA);
			} else if (TeamManager.team1.getColor() == "&c") {
				meta.setColor(Color.RED);
			} else if (TeamManager.team1.getColor() == "&d") {
				meta.setColor(Color.FUCHSIA);
			} else if (TeamManager.team1.getColor() == "&e") {
				meta.setColor(Color.YELLOW);
			} else if (TeamManager.team1.getColor() == "&f") {
				meta.setColor(Color.WHITE);
			}
		} else if (TeamManager.team2.contains(player)) {
			if (TeamManager.team2.getColor() == "&0") {
				meta.setColor(Color.BLACK);
			} else if (TeamManager.team2.getColor() == "&1") {
				meta.setColor(Color.NAVY);
			} else if (TeamManager.team2.getColor() == "&2") {
				meta.setColor(Color.GREEN);
			} else if (TeamManager.team2.getColor() == "&3") {
				meta.setColor(Color.TEAL);
			} else if (TeamManager.team2.getColor() == "&4") {
				meta.setColor(Color.MAROON);
			} else if (TeamManager.team2.getColor() == "&5") {
				meta.setColor(Color.PURPLE);
			} else if (TeamManager.team2.getColor() == "&6") {
				meta.setColor(Color.ORANGE);
			} else if (TeamManager.team2.getColor() == "&7") {
				meta.setColor(Color.SILVER);
			} else if (TeamManager.team2.getColor() == "&8") {
				meta.setColor(Color.GRAY);
			} else if (TeamManager.team2.getColor()== "&9") {
				meta.setColor(Color.BLUE);
			} else if (TeamManager.team2.getColor() == "&a") {
				meta.setColor(Color.LIME);
			} else if (TeamManager.team2.getColor() == "&b") {
				meta.setColor(Color.AQUA);
			} else if (TeamManager.team2.getColor() == "&c") {
				meta.setColor(Color.RED);
			} else if (TeamManager.team2.getColor() == "&d") {
				meta.setColor(Color.FUCHSIA);
			} else if (TeamManager.team2.getColor() == "&e") {
				meta.setColor(Color.YELLOW);
			} else if (TeamManager.team2.getColor() == "&f") {
				meta.setColor(Color.WHITE);
			}
		} else if (TeamManager.team3.contains(player)) {
			if (TeamManager.team3.getColor() == "&0") {
				meta.setColor(Color.BLACK);
			} else if (TeamManager.team3.getColor() == "&1") {
				meta.setColor(Color.NAVY);
			} else if (TeamManager.team3.getColor() == "&2") {
				meta.setColor(Color.GREEN);
			} else if (TeamManager.team3.getColor() == "&3") {
				meta.setColor(Color.TEAL);
			} else if (TeamManager.team3.getColor() == "&4") {
				meta.setColor(Color.MAROON);
			} else if (TeamManager.team3.getColor() == "&5") {
				meta.setColor(Color.PURPLE);
			} else if (TeamManager.team3.getColor() == "&6") {
				meta.setColor(Color.ORANGE);
			} else if (TeamManager.team3.getColor() == "&7") {
				meta.setColor(Color.SILVER);
			} else if (TeamManager.team3.getColor() == "&8") {
				meta.setColor(Color.GRAY);
			} else if (TeamManager.team3.getColor() == "&9") {
				meta.setColor(Color.BLUE);
			} else if (TeamManager.team3.getColor() == "&a") {
				meta.setColor(Color.LIME);
			} else if (TeamManager.team3.getColor() == "&b") {
				meta.setColor(Color.AQUA);
			} else if (TeamManager.team3.getColor() == "&c") {
				meta.setColor(Color.RED);
			} else if (TeamManager.team3.getColor() == "&d") {
				meta.setColor(Color.FUCHSIA);
			} else if (TeamManager.team3.getColor() == "&e") {
				meta.setColor(Color.YELLOW);
			} else if (TeamManager.team3.getColor() == "&f") {
				meta.setColor(Color.WHITE);
			}
		} else if (TeamManager.team4.contains(player)) {
			if (TeamManager.team4.getColor() == "&0") {
				meta.setColor(Color.BLACK);
			} else if (TeamManager.team4.getColor() == "&1") {
				meta.setColor(Color.NAVY);
			} else if (TeamManager.team4.getColor() == "&2") {
				meta.setColor(Color.GREEN);
			} else if (TeamManager.team4.getColor() == "&3") {
				meta.setColor(Color.TEAL);
			} else if (TeamManager.team4.getColor() == "&4") {
				meta.setColor(Color.MAROON);
			} else if (TeamManager.team4.getColor() == "&5") {
				meta.setColor(Color.PURPLE);
			} else if (TeamManager.team4.getColor() == "&6") {
				meta.setColor(Color.ORANGE);
			} else if (TeamManager.team4.getColor() == "&7") {
				meta.setColor(Color.SILVER);
			} else if (TeamManager.team4.getColor() == "&8") {
				meta.setColor(Color.GRAY);
			} else if (TeamManager.team4.getColor() == "&9") {
				meta.setColor(Color.BLUE);
			} else if (TeamManager.team4.getColor() == "&a") {
				meta.setColor(Color.LIME);
			} else if (TeamManager.team4.getColor() == "&b") {
				meta.setColor(Color.AQUA);
			} else if (TeamManager.team4.getColor() == "&c") {
				meta.setColor(Color.RED);
			} else if (TeamManager.team4.getColor() == "&d") {
				meta.setColor(Color.FUCHSIA);
			} else if (TeamManager.team4.getColor() == "&e") {
				meta.setColor(Color.YELLOW);
			} else if (TeamManager.team4.getColor() == "&f") {
				meta.setColor(Color.WHITE);
			}
		}
		
		
		leggings.setItemMeta(meta);
		
		//Item Set
		player.getInventory().setLeggings(leggings);
		
	}
	
}
