package me.icycode.orbit;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import me.icycode.orbit.listeners.BlockBreak;
import me.icycode.orbit.listeners.BlockPlace;
import me.icycode.orbit.listeners.ChatManager;
import me.icycode.orbit.listeners.CreatureSpawn;
import me.icycode.orbit.listeners.EntityDamage;
import me.icycode.orbit.listeners.EntityDamageByEntity;
import me.icycode.orbit.listeners.PlayerDeath;
import me.icycode.orbit.listeners.PlayerJoin;
import me.icycode.orbit.listeners.PlayerKick;
import me.icycode.orbit.listeners.PlayerLeave;
import me.icycode.orbit.listeners.PlayerMove;
import me.icycode.orbit.listeners.PlayerRespawn;
import me.icycode.orbit.listeners.WeatherChange;
import me.icycode.orbit.match.Countdowns;
import me.icycode.orbit.match.GameInfo;
import me.icycode.orbit.match.GameManager;
import me.icycode.orbit.match.GameState;
import me.icycode.orbit.match.Loadout;
import me.icycode.orbit.match.MapInfo;
import me.icycode.orbit.match.RotationManager;
import me.icycode.orbit.match.TeamManager;
import me.icycode.orbit.sql.mysql.MySQL;
import me.icycode.orbit.utils.SoundUtils;
import me.icycode.orbit.utils.chat.Announcement;
import me.icycode.orbit.utils.chat.Chatter;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.connorlinfoot.titleapi.TitleAPI;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;

public class Main extends JavaPlugin {

	public static int playersOnline;
	public static int lobbyCountdown;
	public static int gameCountdown;
	public static int gameTime;
	public static int announceTime;
	
	private int interval = 60; //Interval between broadcasts
	
	public static HashMap<Player, GamePlayer> onlinePlayers = new HashMap<Player, GamePlayer>();
	
	MySQL MySQL = new MySQL("198.20.114.182", "3306", "mc132549", "mc132549", "pass");
	Connection c = null;
	
	@Override
	public void onEnable() {
		
		
		
		
		getConfig().options().copyDefaults(true);
        saveConfig();
		
		Announcement.counter = 0;
		announceTime = interval;
		playersOnline = 0;
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BlockBreak(), this);
		pm.registerEvents(new BlockPlace(), this);
		pm.registerEvents(new ChatManager(), this);
		pm.registerEvents(new CreatureSpawn(), this);
		pm.registerEvents(new EntityDamageByEntity(), this);
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new PlayerDeath(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerKick(), this);
		pm.registerEvents(new PlayerLeave(), this);
		pm.registerEvents(new PlayerMove(), this);
		pm.registerEvents(new PlayerRespawn(), this);
		pm.registerEvents(new WeatherChange(), this);
		GameState.setIn_Lobby();
		lobbyCountdown = -1;
		gameCountdown = -1;
		gameTime = -1;
		
		Bukkit.getServer().createWorld(new WorldCreator("MatchMap"));
		
		MapInfo.resetInfo();
		
		onlinePlayers.clear();
		
		TeamManager.team1.reset();
		TeamManager.team2.reset();
		TeamManager.team3.reset();
		TeamManager.team4.reset();
		
		//World Loading
		Bukkit.getServer().createWorld(new WorldCreator("Lobby"));
		
		//RotationManager.rotation = (ArrayList<String>) getConfig().getStringList("rotation");
		
		RotationManager.addMap("Tumbleweed");
		RotationManager.addMap("Arbaro");
		RotationManager.addMap("Kingdom");
		RotationManager.addMap("Quintlet");
		RotationManager.addMap("Halcyon");
		RotationManager.addMap("Island Hopper");
		RotationManager.addMap("Senex 1");
		RotationManager.addMap("Tumbleweed");
		RotationManager.addMap("Quintlet");
		RotationManager.addMap("Triax");
		RotationManager.addMap("Tumbleweed");
		
		
		
		
		
		RotationManager.setNextMap();
		
		//World Downloader Preventer
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "WDL|CONTROL");
		Bukkit.getMessenger().registerIncomingPluginChannel(this, "WDL|INIT", (s, player, bytes) -> {
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			out.writeInt(1);
			out.writeBoolean(false);
			out.writeInt(1);
			out.writeBoolean(false);
			out.writeBoolean(false);
			out.writeBoolean(false);
			out.writeBoolean(false);
			Bukkit.getLogger().info("Blocking WorldDownloader for " + player.getDisplayName());
			for (Player p : Bukkit.getServer().getOnlinePlayers()) {
				if (p.hasPermission("orbit.mod")) {
					p.sendMessage(Chatter.Severe() + ChatColor.RED + "The player " + player.getName() + " has attempted to download maps via WorldDownloader.");
				}
			}
			player.kickPlayer(ChatColor.RED + "Do " + ChatColor.BOLD +" not " + ChatColor.RED + " attempt to download our maps.");
			player.sendPluginMessage(this, "WDL|CONTROL", out.toByteArray());
		});
  
		
		// Repeating task running every second
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
					public void run() {
						if (lobbyCountdown > -1) {
							Countdowns.lobbyCountdown(lobbyCountdown);
						} else if (gameCountdown > -1) {
							Countdowns.gameCountdown(gameCountdown);
						} else if (gameTime > -1) {
							 Countdowns.gameTimeCountdown(gameTime);
						}
						if (announceTime == 0) {
							Announcement.broadcast();
							announceTime = interval;
						}
						lobbyCountdown -= 1;
						gameCountdown -= 1;
						gameTime -= 1;
						announceTime -= 1;
						/**if (MapInfo.gameMode.equalsIgnoreCase("CTF")) {
							if (CTF.team1FlagHolder != null) {
								Player p = CTF.team1FlagHolder;
								ParticleEffect.FIREWORKS_SPARK.display(OrdinaryColor., p.getLocation(), 10);
							} else if (CTF.team2FlagHolder != null) {
								Player p = CTF.team2FlagHolder;
								ParticleEffect.FIREWORKS_SPARK.display(Color.ORANGE, 0, 2, 0, 2, 10, p.getLocation(), 10);
							}
						} **/
						//Tab.update();
					}
				}, 20, 20);
	}
	
	public void loadConfiguration(){
	     getConfig().options().copyDefaults(true);
	     saveConfig();
	}
	
	private void addMapsToRotation() {
		FileConfiguration f = getConfig();
		List<String> filerot = f.getStringList("rotation");
		  for(String s : filerot){
		    while(RotationManager.rotation.size() >= filerot.size()){
		      RotationManager.rotation.add(s);
		    } break;
		}
	}
	
	public WorldEditPlugin getWorldEdit() {
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("World Edit");
		
		if (p instanceof WorldEditPlugin) {
			return (WorldEditPlugin) p;
		} else return null;
	}
	
	public static void copy() {
        //File dataFolder = new File(Bukkit.getWorldContainer().getPath());
        //player.sendMessage(dataFolder.toString());
        File srcDir = new File(Bukkit.getWorldContainer() + "/Maps/" +  MapInfo.worldName);
        if (!srcDir.exists()) {
            Bukkit.getLogger().warning("Map directory does not exist!");
            return;
        }
        File destDir = new File(Bukkit.getWorldContainer() + "/MatchMap");
        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Bukkit.getServer().createWorld(new WorldCreator("MatchMap"));
    }
	
	public static void delete() {
        try {
        	Bukkit.getServer().unloadWorld("MatchMap", true);
            File dir = new File(Bukkit.getWorldContainer() + "MatchMap");
            FileUtils.deleteDirectory(dir);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd,
		String commandLabel, String[] args){
		
		
		
		Player player = (Player) sender;
		GamePlayer gamePlayer = onlinePlayers.get(player);
		
		//START
		if (cmd.getName().equalsIgnoreCase("start")) {
			if (!(player.hasPermission("orbit.manager"))){
				player.sendMessage(Chatter.PermissionWarn());
				return true;
			}
			
			if (!(GameState.IN_LOBBY || GameState.STARTING)) {
				sender.sendMessage(ChatColor.RED
						+ "You may not use this at this time.");
				return true;
			}
			if (args[0] == null) {
				sender.sendMessage(ChatColor.RED
						+ "Please specify a time frame.");
				return true;
			}
			if (GameState.IN_LOBBY) {
				TeamManager.assignAllPlayersTeam(2);
			}
			lobbyCountdown = Integer.valueOf(args[0]);
			GameState.setStarting();
			return true;
		}
		
		//JOIN
		if (cmd.getName().equalsIgnoreCase("join")){
			
			if (!(TeamManager.spectators.contains(player.getName()))) {
				player.sendMessage(Chatter.Warning() + ChatColor.RED + "You are already on a team.");
				return true;
			}
			if (GameState.IN_GAME == false) {
				player.sendMessage(Chatter.Warning() + ChatColor.RED + "You may not use this command at this time.");
				return true;
			}
			TeamManager.assignPlayerTeam(MapInfo.teams, player);
			Loadout.giveLoadout(player);
			player.setGameMode(GameMode.SURVIVAL);
			GameManager.teleportSpawn(player);
		}
		
		//MAP
		if (cmd.getName().equalsIgnoreCase("map")) {
			player.sendMessage(ChatColor.DARK_AQUA + "---===[ " + ChatColor.AQUA + ChatColor.BOLD + MapInfo.mapName + ChatColor.DARK_AQUA + " ]===---");
			player.sendMessage(ChatColor.DARK_AQUA + "Gamemode: " + ChatColor.AQUA + MapInfo.gameMode + " - " + GameInfo.getGameInfo());
			player.sendMessage(ChatColor.DARK_AQUA + "Creators: " + ChatColor.AQUA + MapInfo.creators);
		}
		
		//LEAVE
		if (cmd.getName().equalsIgnoreCase("leave")) {
			if (TeamManager.spectators.contains(player.getName())) {
				player.sendMessage(ChatColor.RED + "You are not on a team.");
				return true;
			} else if (TeamManager.team1.contains(player)) {
				TeamManager.team1.removePlayer(player);
				TeamManager.spectators.add(player.getName());
				player.setGameMode(GameMode.SPECTATOR);
				return true;
			} else if (TeamManager.team2.contains(player)) {
				TeamManager.team2.removePlayer(player);
				TeamManager.spectators.add(player.getName());
				player.setGameMode(GameMode.SPECTATOR);
				return true;
			} else if (TeamManager.team3.contains(player)) {
				TeamManager.team3.removePlayer(player);
				TeamManager.spectators.add(player.getName());
				player.setGameMode(GameMode.SPECTATOR);
				return true;
			} else if (TeamManager.team4.contains(player)) {
				TeamManager.team4.removePlayer(player);
				TeamManager.spectators.add(player.getName());
				player.setGameMode(GameMode.SPECTATOR);
				return true;
			}
		}
		
		//ROTATION
		
		if (cmd.getName().equalsIgnoreCase("rotation")) {
			player.sendMessage("" + ChatColor.BLUE + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "-----{-" + ChatColor.DARK_AQUA + " Current Rotation " + ChatColor.BLUE + ChatColor.BOLD + ChatColor.STRIKETHROUGH + "-}-----");
			int i = 0;
			while (i + 1 <= RotationManager.rotation.size()) {
				if (i==0) {
					player.sendMessage("" + ChatColor.DARK_AQUA + ChatColor.BOLD + i + " - " + ChatColor.GREEN + ChatColor.BOLD + RotationManager.rotation.get(i));
				} else {
					player.sendMessage("" + ChatColor.DARK_AQUA + ChatColor.BOLD + i + " - " + ChatColor.DARK_GREEN + RotationManager.rotation.get(i));
				}
					i++;
			}
		}
		
		//WARN
        if(cmd.getName().equalsIgnoreCase("warn")){
        	
            if(sender.hasPermission("orbit.trainee")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Error: Correct usage - /warn <player> <reason>");
                    return true;
                }

                StringBuilder str = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    str.append(args[i] + " ");
                }
                String warnMessage = str.toString();

                final Player target = Bukkit.getServer().getPlayerExact(args[0]);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Error: " + target.getDisplayName() + " is not online.");
                    return true;
                }
                if (args.length == 1) {
                    player.sendMessage(ChatColor.RED + "Error: Please specify a reason.");
                    return true;
                }
                if (args.length >= 2) {
                    TitleAPI.sendTitle(target, 10, 50, 10, ChatColor.DARK_RED + "" + ChatColor.BOLD + "WARN", ChatColor.RED + warnMessage);
                    target.sendMessage(ChatColor.RED + "You have been warned by " + ChatColor.BLUE + player.getDisplayName() + " " + ChatColor.GOLD + Chatter.RightArrow() + " " + ChatColor.RED + warnMessage);
                    player.sendMessage(ChatColor.RED + "You have warned " + ChatColor.BLUE + target.getDisplayName() + " " + ChatColor.GOLD + Chatter.RightArrow() + " " + ChatColor.RED + warnMessage);
                    return true;

                }
            }
        }
        //KICK
        if(cmd.getName().equalsIgnoreCase("kick")){
            if(sender.hasPermission("orbit.trainee")) {
                if (player instanceof Player) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.RED + "Error: Correct usage - /kick <player> <reason>");
                        return true;
                    }

                    StringBuilder str = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        str.append(args[i] + " ");
                    }
                    String kickMessage = str.toString();

                    final Player target = Bukkit.getServer().getPlayerExact(args[0]);

                    if (target == null) {
                        player.sendMessage(ChatColor.RED + "Error: " + args[0] + " cannot be found.");
                        return true;
                    }

                    if (args.length == 1) {
                        player.sendMessage(ChatColor.RED + "Error: Please specify a reason!");
                        return true;
                    }
                    if (args.length >= 2) {
                        target.kickPlayer(ChatColor.DARK_RED + "[KICK] " + ChatColor.GOLD + "" + ChatColor.BOLD + player.getName() + "\n " + ChatColor.AQUA + "" + ChatColor.ITALIC + kickMessage + "\n" + "\n" + ChatColor.RESET + "If this is an error, please contact (SUPPORT EMAIL HERE)");
                        getServer().broadcastMessage(ChatColor.DARK_RED + "[KICK] " + ChatColor.GOLD + player.getName() + ChatColor.AQUA + " » "
                                + ChatColor.DARK_RED + "" + ChatColor.UNDERLINE + "Kicked" +
                                ChatColor.AQUA + " » " + ChatColor.GOLD + "" + ChatColor.BOLD + target.getName() +
                                ChatColor.AQUA + " » " + ChatColor.GOLD + "" + ChatColor.ITALIC + kickMessage);
                    }
                }
            }
        }
        //BAN
        if(cmd.getName().equalsIgnoreCase("ban")) {
            if (player.hasPermission("punishment.ban")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Error: Correct usage - /ban <player> <reason>");
                    return true;
                }
                StringBuilder str = new StringBuilder();
                for (int i = 1; i < args.length; i++) {

                }
                String banMessage = str.toString();

                final Player target = Bukkit.getServer().getPlayerExact(args[0]);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "That player is not online.");
                    return true;
                }

                if (args.length == 1) {
                    player.sendMessage(ChatColor.RED + "Please specify a reason!");
                    return true;
                }

                if (args.length >= 2) {
                    target.kickPlayer(ChatColor.DARK_RED + "[BAN] " + ChatColor.GOLD + "" + ChatColor.BOLD + player.getName() + "\n " + ChatColor.AQUA + "" + ChatColor.ITALIC + banMessage + "\n" + "\n" + ChatColor.RESET + "If this is an error, please contact (SUPPORT EMAIL HERE)");
                    target.setBanned(true);
                    getServer().broadcastMessage(ChatColor.GOLD + player.getName() + ChatColor.AQUA + " » "
                            + ChatColor.DARK_RED + "" + ChatColor.UNDERLINE + "Permanent Ban" +
                            ChatColor.AQUA + " » " + ChatColor.GOLD + "" + ChatColor.BOLD + target.getName() +
                            ChatColor.AQUA + " » " + ChatColor.GOLD + "" + ChatColor.ITALIC + banMessage);
                }
            }
        }



        //MODERATOR CHAT
        if (cmd.getName().equalsIgnoreCase("s")) {
            if (sender instanceof Player){
                Player m = (Player) sender;
                if (m.hasPermission("staffchat.mod")){
                    if (args.length == 0) {
                        m.sendMessage(ChatColor.RED + "Correct usage: /s [message]");
                        return true;
                    } else {
                        String msg = "";
                        for(int i = 0; i < args.length; i++){
                            msg = msg + args[i] + ' ';
                        }

                        String path = ChatColor.GRAY + "" + ChatColor.BOLD + "[" + ChatColor.RED + "" + ChatColor.BOLD + "{TYPE}" + ChatColor.GRAY + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "{NAME}" + ChatColor.WHITE + " » {MESSAGE}";
                        path = path.replace("{TYPE}", "S");
                        path = path.replace("{NAME}", m.getDisplayName());
                        path = path.replace("{MESSAGE}", msg);

                        for(Player p : Bukkit.getOnlinePlayers()) {
                            if (p.hasPermission("staffchat.mod.see")) p.sendMessage(path);
                        }
                    }
                }else {
                    sender.sendMessage(ChatColor.RED + "You have no permission!");
                    return true;
                }
            }

        }
        
        //ADMIN CHAT
        if(cmd.getName().equalsIgnoreCase("a")){
            if(sender instanceof Player){
                Player m = (Player) sender;
                if (m.hasPermission("staffchat.admin")){
                    if (args.length == 0 ){
                        m.sendMessage(ChatColor.RED + "Correct usage: /a [message]");
                        return true;
                    } else {
                        String msg = "";
                        for(int i = 0; i < args.length; i++){
                            msg = msg + args[i] + ' ';
                        }

                        String path = ChatColor.GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "{TYPE}" + ChatColor.GRAY + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "{NAME}" + ChatColor.WHITE + " » {MESSAGE}";
                        path = path.replace("{TYPE}", "A");
                        path = path.replace("{NAME}", m.getDisplayName());
                        path = path.replace("{MESSAGE}", msg);

                        for(Player p : Bukkit.getOnlinePlayers()){
                            if(p.hasPermission("staffchat.admin.see")) p.sendMessage(path);
                        }
                    }
                }else {
                    sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                    return true;
                }
            }
        }
        
        //DEVELOPER CHAT
        if(cmd.getName().equalsIgnoreCase("d")){
            if(sender instanceof Player){
                Player m = (Player) sender;
                if(m.hasPermission("staffchat.dev")){
                    if (args.length == 0){
                        m.sendMessage(ChatColor.RED + "Correct usage: /d [message]");
                        return true;
                    } else {
                        String msg = "";
                        for(int i = 0; i < args.length; i++){
                            msg = msg + args[i] + ' ';
                        }

                        String path = ChatColor.GRAY + "" + ChatColor.BOLD + "[" + ChatColor.BLUE + "" + ChatColor.BOLD + "{TYPE}" + ChatColor.GRAY + "" + ChatColor.BOLD + "] " + ChatColor.RESET + "{NAME}" + ChatColor.WHITE + " » {MESSAGE}";
                        path = path.replace("{TYPE}", "D");
                        path = path.replace("{NAME}", m.getDisplayName());
                        path = path.replace("{MESSAGE}", msg);

                        for(Player p : Bukkit.getOnlinePlayers()){
                            if(p.hasPermission("staffchat.dev.see")) p.sendMessage(path);
                        }
                    }
                }else {
                    sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                    return true;
                }
            }
        }

        //REPORT SENDING
        
        if(cmd.getName().equalsIgnoreCase("report")){
            if(sender instanceof Player){
                    if(args.length == 0){
                        player.sendMessage(ChatColor.RED + "Error: Correct usage - /report <name> <reason>");
                        return true;
                    }

                    StringBuilder str = new StringBuilder();
                    for(int i = 1; i < args.length; i++){
                        str.append(args[i] + " ");
                    }
                    String reportReason= str.toString();

                    final Player reported = Bukkit.getServer().getPlayer(args[0]);
                    final Server server = Bukkit.getServer();


                    if(reported == null){
                        player.sendMessage(Chatter.Warning() + ChatColor.RED + "The player " + args[0] + " is not online!");
                        return true;
                    }
                    if(args.length == 1){
                        player.sendMessage(Chatter.Warning() + ChatColor.RED + "Error: Please specify a reason.");
                        return true;
                    }

                    if (args.length >= 2) {
                        for(Player p : Bukkit.getOnlinePlayers()){
                            if(p.hasPermission("orbit.trainee") | p.isOp()) {
                            	p.sendMessage(ChatColor.GOLD + "[Report] " +
                                        ChatColor.GOLD + "(" + server.getServerName() + ") " +
                                        ChatColor.AQUA + player.getName() +
                                        ChatColor.GOLD + " has reported " +
                                        ChatColor.AQUA + reported.getName() +
                                        ChatColor.WHITE + ": " + reportReason);
                            	TitleAPI.sendTitle(p, 10, 20, 10, "", ChatColor.RED + "INCOMING REPORT");
                            	p.getWorld().playSound(player.getLocation(), Sound.GLASS, 1, 1);
                            }
                                    
                            
                        }
                        sender.sendMessage(ChatColor.GREEN + "Your report has been sent to online staff successfully.");
                        return true;

                    }

                }


        }
        
        
        //XP
        if(cmd.getName().equalsIgnoreCase("xp")) {
        	
        	if(args.length == 0) {
            	player.sendMessage(ChatColor.GREEN + "" + ChatColor.ITALIC + gamePlayer.xp + " XP" + ChatColor.GRAY + " | " + ChatColor.DARK_AQUA + ChatColor.ITALIC + "Lvl " + gamePlayer.getXpLevel());
            	return true;
        	} else if (args.length == 1) {
        		player.sendMessage(ChatColor.RED + "Error: Correct usage - /xp <name> <amount>");
        		return true;
        	} else {
        		Player target = Bukkit.getServer().getPlayer(args[0]);
        		if (target == null) {
        			player.sendMessage(ChatColor.RED + "That player is not online.");
        		}
        		int amount = Integer.parseInt(args[1]);
        		GamePlayer targetPlayer = onlinePlayers.get(player);
        		targetPlayer.addXp(amount);
        		player.sendMessage(ChatColor.GREEN + "You have added " + amount + " XP to player " + targetPlayer.getPlayer().getDisplayName());
        		return true;
        	}

        }
        
        //PRESTIGE
        if(cmd.getName().equalsIgnoreCase("prestige")) {
        	if (gamePlayer.getXpLevel() == 50) {
        		if(gamePlayer.prestige == 5) {
        			player.sendMessage(ChatColor.RED + "You have reached the maximum prestige level.");
        			return false;
        		}
        		gamePlayer.prestige();
        		gamePlayer.resetXp();
        		Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + player.getDisplayName() + " has reached prestige level " + gamePlayer.prestige + "!");
        		SoundUtils.broadcastSound(Sound.ENDERDRAGON_DEATH);
        		return true;
        	} else {
        		player.sendMessage(ChatColor.RED + "You need to be level 50 to prestige.");
        		return true;
        	}
        	
        	
        	
        }
        
        //SETNEXT
        
        /*if(cmd.getName().equalsIgnoreCase("setnext")) {
        	if(!(player.hasPermission("staffchat.admin"))){
        		Chatter.PermissionWarn();
        		return true;
        	}
        	
        	if(args.length == 0) {
        		player.sendMessage(Chatter.Warning() + ChatColor.RED + " ERROR - Correct Usage: /setnext <mapname> ");
        	}
        	
        	RotationManager.rotation.set(1, args.toString());
        	RotationManager.setNextMap();
        } */

        return true;
		
		
	}
	
	
}
