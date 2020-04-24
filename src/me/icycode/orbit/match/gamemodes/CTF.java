package me.icycode.orbit.match.gamemodes;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.match.GameManager;
import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.module.Region;
import me.icycode.orbit.utils.SoundUtils;
import me.icycode.orbit.utils.chat.Chatter;
import me.icycode.orbit.utils.color.ColorUtils;
import me.icycode.orbit.utils.player.armor.Helmet;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CTF {
	
	public static Player team1FlagHolder = null; //Team 2 tries to get it
	public static Player team2FlagHolder = null; //Team 1 tries to get it
	
	public static int team1Captures;
	public static int team2Captures;
	
	public static void endGameCheck() {
		if (team1Captures == 3 || team2Captures == 3) {
			GameManager.endGame(null);
		}
	}
	
	public static void endGameLogic() {
		if (team1Captures == 3) {
			//Win Message
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team1.getColor() + TeamManager.team1.getName() + " Wins") + ChatColor.GOLD + ChatColor.BOLD + " < < < <");
			
			for (Player player : Bukkit.getOnlinePlayers()){
				if (TeamManager.team1.contains(player)) {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +20 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " Your team won!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(20);
				} else {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +5 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You participated in a match!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(5);
				}
			}
		} else {
			//Win Message
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team2.getColor() + TeamManager.team2.getName() + " Wins") + ChatColor.GOLD + ChatColor.BOLD + " < < < <");
			
			for (Player player : Bukkit.getOnlinePlayers()){
				if (TeamManager.team2.contains(player)) {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +20 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " Your team won!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(20);
				} else {
					
					//Tokens Handling
					player.sendMessage(ChatColor.AQUA + " " + ChatColor.ITALIC + " +5 XP " + ChatColor.GOLD + Chatter.RightArrow() + ChatColor.GREEN + " You participated in a match!");
					player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
					GamePlayer gamePlayer = Main.onlinePlayers.get(player);
					gamePlayer.addXp(5);
				}
			}
		}
	}
	
	public static void resetInfo() {
		team1FlagHolder = null;
		team2FlagHolder = null;
		
		team1Captures = 0;
		team2Captures = 0;
	}
	
	public static void flagCheck(Player player) {
		
		Region r1 = MapInfo.getTeam1Flag(); //Team 2 tries to get
		Region r2 = MapInfo.getTeam2Flag(); // Team 1 tries to get
		Location l = player.getLocation();
		ItemStack flag = new ItemStack(Material.BANNER, 1);
		BannerMeta flagMeta = (BannerMeta) flag.getItemMeta();
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		
		if (r1.getLowerX() < l.getX() && r1.getLowerY() < l.getY() && r1.getLowerZ() < l.getZ() && r1.getUpperX() > l.getX() && r1.getUpperY() > l.getY() && r1.getUpperZ() > l.getZ()) {
			
			if (!GameState.IN_GAME) {
				return;
			}
			
			if (team1FlagHolder != null) {
				return;
			}
			
			if (TeamManager.team1.contains(player)) {
				if (team2FlagHolder.equals(player)) {
					team1Captures++;
					team2FlagHolder = null;
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team1.getColor() + player.getName() + " has captured the flag!") + ChatColor.GOLD + ChatColor.BOLD + " < < <");
					SoundUtils.broadcastSound(Sound.BLAZE_DEATH);
					Helmet.give(player);
					endGameCheck();
				}
				return;
			}
			
			
			team1FlagHolder = player;
			flagMeta.setBaseColor(ColorUtils.getDyeColor(TeamManager.team1.getColor()));
			flag.setItemMeta(flagMeta);
			player.getInventory().setHelmet(flag);
			player.getInventory().setChestplate(chestplate);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 0));
			player.sendMessage("" + ChatColor.GOLD + ChatColor.BOLD + "You have picked up the flag, return it to your base!");
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team2.getColor() + player.getName() + " has picked up the flag!") + ChatColor.GOLD + ChatColor.BOLD + " < < <");
			SoundUtils.broadcastSound(Sound.FIREWORK_BLAST2);
		} else if (r2.getLowerX() < l.getX() && r2.getLowerY() < l.getY() && r2.getLowerZ() < l.getZ() && r2.getUpperX() > l.getX() && r2.getUpperY() > l.getY() && r2.getUpperZ() > l.getZ()) {
			
			
			
			if (!GameState.IN_GAME) {
				return;
			}
			
			if (team2FlagHolder != null) {
				return;
			}
			
			if (TeamManager.team2.contains(player)) {
				if (team1FlagHolder.equals(player)) {
					team2Captures++;
					team1FlagHolder = null;
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team2.getColor() + player.getName() + " has captured the flag!") + ChatColor.GOLD + ChatColor.BOLD + " < < <");
					SoundUtils.broadcastSound(Sound.BLAZE_DEATH);
					Helmet.give(player);
					endGameCheck();
				}
				return;
			}
			
			
			team2FlagHolder = player;
			flagMeta.setBaseColor(ColorUtils.getDyeColor(TeamManager.team2.getColor()));
			flag.setItemMeta(flagMeta);
			player.getInventory().setHelmet(flag);
			player.getInventory().setChestplate(chestplate);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 0));
			player.sendMessage("" + ChatColor.GOLD + ChatColor.BOLD + "You have picked up the flag, return it to your base!");
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " > > > " + ChatColor.translateAlternateColorCodes('&', TeamManager.team1.getColor() + player.getName() + " has picked up the flag!") + ChatColor.GOLD + ChatColor.BOLD + " < < <");
			SoundUtils.broadcastSound(Sound.FIREWORK_BLAST2);
		}
	}
	
}
