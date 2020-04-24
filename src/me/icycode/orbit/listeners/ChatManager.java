package me.icycode.orbit.listeners;

import me.icycode.orbit.GamePlayer;
import me.icycode.orbit.Main;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.utils.chat.Chatter;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatManager implements Listener{
	
	@EventHandler
	public void chatFormat(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		String chatColor;
		if (TeamManager.team1.contains(p)) {
			chatColor = TeamManager.team1.getColor();
		} else if (TeamManager.team2.contains(p)) {
			chatColor = TeamManager.team2.getColor();
		} else if (TeamManager.team3.contains(p)) {
			chatColor = TeamManager.team3.getColor();
		} else if (TeamManager.team4.contains(p)) {
			chatColor = TeamManager.team4.getColor();
		} else {
			chatColor = "&b";
		}
		GamePlayer gamePlayer = Main.onlinePlayers.get(p);
		String suffix;
		switch(gamePlayer.getPrestige()) {
		case 0:
			suffix = "";
			break;
		case 1:
			suffix = "&d*";
			break;
		case 2:
			suffix = "&a*";
			break;
		case 3:
			suffix = "&e*";
			break;
		case 4:
			suffix = "&c*";
			break;
		case 5:
			suffix = "&6*";
			break;
		default:
			suffix = "";
			break;
		}
		String chatFormat = ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_AQUA + Integer.toString(Main.onlinePlayers.get(p).getXpLevel()) + " " + PermissionsEx.getUser(p).getPrefix() + ChatColor.DARK_GRAY + " | " +  chatColor + "" + p.getDisplayName() + suffix + " " + ChatColor.DARK_GRAY + Chatter.RightArrow() + " " + ChatColor.WHITE + event.getMessage());
		event.setFormat(chatFormat);
	}

	
}
