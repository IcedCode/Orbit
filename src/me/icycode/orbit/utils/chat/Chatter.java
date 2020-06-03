package me.icycode.orbit.utils.chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.context.ContextManager;
import net.luckperms.api.context.ImmutableContextSet;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;

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
	
	public static String getPrefix(Player player) {
		final LuckPerms lpAPI = LuckPermsProvider.get();
		User user = lpAPI.getUserManager().getUser(player.getUniqueId());
		ContextManager contextManager = lpAPI.getContextManager();
	    ImmutableContextSet contextSet = contextManager.getContext(user).orElseGet(contextManager::getStaticContext);
	    CachedMetaData metaData = user.getCachedData().getMetaData(QueryOptions.contextual(contextSet));
	    String prefix = metaData.getPrefix();
	    if (prefix == null) {
	    	return "";
	    } else {
	    	return prefix;
	    }
	}
	
	public static String getSuffix(Player player) {
		final LuckPerms lpAPI = LuckPermsProvider.get();
		User user = lpAPI.getUserManager().getUser(player.getUniqueId());
		ContextManager contextManager = lpAPI.getContextManager();
	    ImmutableContextSet contextSet = contextManager.getContext(user).orElseGet(contextManager::getStaticContext);
	    CachedMetaData metaData = user.getCachedData().getMetaData(QueryOptions.contextual(contextSet));
	    String suffix = metaData.getSuffix();
	    if (suffix == null) {
	    	return "";
	    } else {
	    	return suffix;
	    }
	}
}
