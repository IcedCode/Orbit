package me.icycode.orbit.match;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;

import me.icycode.orbit.Main;
import me.icycode.orbit.match.gamemodes.CTW;
import me.icycode.orbit.match.gamemodes.DTM;
import me.icycode.orbit.module.Monument;
import me.icycode.orbit.module.Region;
import me.icycode.orbit.module.Spawn;
import me.icycode.orbit.module.WoolCap;

public class RotationManager {
	
	public static String currentMap;
	
	public static ArrayList<String> rotation = new ArrayList<String>();;
	
	public static void addMap(String map){
		rotation.add(map);
	}
	
	public static void setNextMap() {
		rotation.remove(0);
		if (rotation.size() >= 0) {
			currentMap = rotation.get(0);
			MapInfo.resetInfo();
			setMapInfo();
			Main.delete();
			Main.copy();
			MapInfo.resetInfo();
			setMapInfo();
		}
		if (rotation.get(0).isEmpty()) {
			Bukkit.getServer().shutdown();
		}
		
	}
	
	public static void setMapInfo() {
		MapInfo.setWorld(Bukkit.getWorld("MatchMap"));
		if (currentMap == "Oasis") {
			
			MapInfo.mapName = "Oasis";
			MapInfo.gameMode = "TDM";
			MapInfo.creators = "samthemenace";
			MapInfo.version = "0.1";
			MapInfo.worldName = ("Oasis");
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 0.5, 84, -33.5, 0, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Cyan");
			TeamManager.team1.setColor("&3");
			Spawn team1Spawn = new Spawn(MapInfo.world, 50.5, 66, 0.5, 90, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			
			TeamManager.team2.setName("Lime");
			TeamManager.team2.setColor("&a");
			Spawn team2Spawn = new Spawn(MapInfo.world, -51.5, 66, 0.5, -90, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			
		} 
		else if (currentMap == "Triax") {
			
			MapInfo.mapName = "Triax";
			MapInfo.gameMode = "TDM";
			MapInfo.creators = "Running_Boy_12";
			MapInfo.version = "1.0";
			MapInfo.worldName = ("Triax");
			MapInfo.teams = 2;
									
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 5.5, 84, 76.5, 90, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			
			TeamManager.team1.setName("Orange");
			TeamManager.team1.setColor("&6");
			Spawn team1Spawn = new Spawn(MapInfo.world, -4.5, 72, -148.5 ,0 ,0);
			MapInfo.team1Spawns.add(team1Spawn);
			
			TeamManager.team2.setName("Purple");
			TeamManager.team2.setColor("&5");
			Spawn team2Spawn = new Spawn(MapInfo.world, -4.5, 72, -3.5, 180, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			

			
		} 
		else if (currentMap == "Tumbleweed") {
			
			MapInfo.mapName = "Tumbleweed";
			MapInfo.gameMode = "TDM";
			MapInfo.creators = "ParaSpider";
			MapInfo.version = "1.0";
			MapInfo.worldName = ("Tumbleweed");
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 2.5, 6, -33.5, 90, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Red");
			TeamManager.team1.setColor("&4");
			Spawn Team1Spawn = new Spawn(MapInfo.world, -20, 5, -21, 180, 0);
			MapInfo.team1Spawns.add(Team1Spawn);
			
			TeamManager.team2.setName("Blue");
			TeamManager.team2.setColor("&9");
			Spawn team2Spawn = new Spawn(MapInfo.world, -4.5, 5, 25.5, 90, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			
		} else if (currentMap == "Island Hopper") {
			
			MapInfo.mapName = "Island Hopper";
			MapInfo.gameMode = "Parkour";
			MapInfo.creators = "IcyCode, samthemenace";
			MapInfo.version = "1.0";
			MapInfo.worldName = ("IslandHopper");
			MapInfo.teams = 1;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -1, 81, -3, 0, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Players");
			TeamManager.team1.setColor("&6");
			Spawn team1Spawn = new Spawn(MapInfo.world, -0.5, 67, -3.5, 0, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			
			Location point1 = new Location(MapInfo.world, -85, 117, 38);
			Location point2 = new Location(MapInfo.world, -79, 121, 33);
			Region region = new Region(point1, point2);
			MapInfo.setParkourEnd(region);
			
		} else if (currentMap == "Melted Canada TDM") {
			MapInfo.mapName = "Melted Canada TDM";
			MapInfo.gameMode = "TDM";
			MapInfo.creators = "IcyCode";
			MapInfo.version = "1.0";
			MapInfo.worldName = ("Melted Canada TDM");
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -66.5, 82, 20.5, 0, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Red Team");
			TeamManager.team1.setColor("&c");
			Spawn team1Spawn = new Spawn(MapInfo.world, -133, 81, 21, -90, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			
			TeamManager.team2.setName("Blue Team");
			TeamManager.team2.setColor("&9");
			Spawn team2Spawn = new Spawn(MapInfo.world, 0, 81, 34, 90, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			
			
		} else if (currentMap == "Melted Canada CTF") {
			MapInfo.mapName = "Melted Canada CTF";
			MapInfo.gameMode = "CTF";
			MapInfo.creators = "IcyCode";
			MapInfo.version = "1.0";
			MapInfo.worldName = ("Melted Canada CTF");
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -66.5, 82, 20.5, 0, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Red Team");
			TeamManager.team1.setColor("&c");
			Spawn team1Spawn = new Spawn(MapInfo.world, -59, 51, -39, -90, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			Location t1P1 = new Location(MapInfo.world, -48, 52, -20);
			Location t1P2 = new Location(MapInfo.world, -50, 57, -18);
			Region t1Flag = new Region(t1P1, t1P2);
			MapInfo.setTeam1Flag(t1Flag);
			
			TeamManager.team2.setName("Blue Team");
			TeamManager.team2.setColor("&9");
			Spawn team2Spawn = new Spawn(MapInfo.world, 74, 51, -25, 90, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			Location t2P1 = new Location(MapInfo.world, 62, 52, -45);
			Location t2P2 = new Location(MapInfo.world, 64, 57, -47);
			Region t2Flag = new Region(t2P1, t2P2);
			MapInfo.setTeam2Flag(t2Flag);
			
			
		} else if (currentMap == "Frozen Waste") {
			MapInfo.mapName = "Frozen Waste";
			MapInfo.gameMode = "TDM";
			MapInfo.creators = "samthemenace, The_Banter_1";
			MapInfo.version = "1.0";
			MapInfo.worldName = ("Frozen Waste");
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 0.5, 67, 14, -180, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Red");
			TeamManager.team1.setColor("&c");
			Spawn team1Spawn = new Spawn(MapInfo.world, -15.5, 62, 16.5, -135, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			
			TeamManager.team2.setName("Green");
			TeamManager.team2.setColor("&a");
			Spawn team2Spawn = new Spawn(MapInfo.world, -15.5, 62, -15.5, -45, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			
			TeamManager.team3.setName("Yellow");
			TeamManager.team3.setColor("&e");
			Spawn team3Spawn = new Spawn(MapInfo.world, 16.5, 62, -15.5, 45, 0);
			MapInfo.team3Spawns.add(team3Spawn);
			
			TeamManager.team4.setName("Blue");
			TeamManager.team4.setColor("&9");
			Spawn team4Spawn = new Spawn(MapInfo.world, 16.5, 62, 16.5, 135, 0);
			MapInfo.team4Spawns.add(team4Spawn);
			
		} else if (currentMap == "8 Bit") {
			MapInfo.mapName = "8 Bit";
			MapInfo.gameMode = "Parkour";
			MapInfo.creators = "samthemenace";
			MapInfo.version = "1.0";
			MapInfo.worldName = ("8 Bit");
			MapInfo.teams = 1;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 209.5, 115, 300.5, 180, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Players");
			TeamManager.team1.setColor("&6");
			Spawn team1Spawn = new Spawn(MapInfo.world, 249.5, 100, 311.5, 180, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			
			Location point1 = new Location(MapInfo.world, 161, 78, 272);
			Location point2 = new Location(MapInfo.world, 155, 82, 275);
			Region region = new Region(point1, point2);
			MapInfo.setParkourEnd(region);
			
		}		/* else if (currentMap == "Monkeysun") {
		
			MapInfo.mapName = "Monkeysun";
			MapInfo.gameMode = "TDM";
			MapInfo.creators = "ParaSpider, Zedther";
			MapInfo.version = "1.0";
			MapInfo.worldName = ("Monkeysun");
			MapInfo.teams = 4;
			
			MapInfo.spectatorSpawnX = -177.5;
			MapInfo.spectatorSpawnY = 14;
			MapInfo.spectatorSpawnZ = -44.5;
			MapInfo.spectatorSpawnYaw = 0;
			MapInfo.spectatorSpawnPitch = 0;
			
			TeamManager.team1.setName("Red");
			TeamManager.team1.setColor("&4");
			
			MapInfo.team1SpawnX = -133.5;
			MapInfo.team1SpawnY = 6;
			MapInfo.team1SpawnZ = -89.5;
			MapInfo.team1SpawnPitch = (float) 0;
			MapInfo.team1SpawnYaw = (float) 45;
			
			TeamManager.team2.setName("Blue");
			TeamManager.team2.setColor("&9");
			
			MapInfo.team2SpawnX = -223.5;
			MapInfo.team2SpawnY = 6;
			MapInfo.team2SpawnZ = 0.5;
			MapInfo.team2SpawnPitch = (float) 0;
			MapInfo.team2SpawnYaw = (float) -135;

			TeamManager.team3.setName("Green");
			TeamManager.team3.setColor("&2");
			
			MapInfo.team3SpawnX = -133.5;
			MapInfo.team3SpawnY = 6;
			MapInfo.team3SpawnZ = 0.5;
			MapInfo.team3SpawnPitch = (float) 0;
			MapInfo.team3SpawnYaw = (float) 135;

			TeamManager.team4.setName("Yellow");
			TeamManager.team4.setColor("&e");
			
			MapInfo.team4SpawnX = -223.5;
			MapInfo.team4SpawnY = 6;
			MapInfo.team4SpawnZ = -90.5;
			MapInfo.team4SpawnPitch = (float) 0;
			MapInfo.team4SpawnYaw = (float) -45;

		}*/ else if (currentMap == "Hellway") {
			MapInfo.mapName = "Hellway";
			MapInfo.gameMode = "TDM";
			MapInfo.creators = "ParaSpider";
			MapInfo.version = "1.0";
			MapInfo.worldName = ("Hellway");
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 1.5, 98, 13.5, 0, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Red");
			TeamManager.team1.setColor("&4");
			Spawn team1Spawn = new Spawn(MapInfo.world, 67.5, 60, 0.5, 90, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			
			TeamManager.team2.setName("Blue");
			TeamManager.team2.setColor("&9");
			Spawn team2Spawn = new Spawn(MapInfo.world, -64.5, 60, 0.5, -90, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			
		} else if (currentMap == "Senex 1") {
			MapInfo.mapName = "Senex 1";
			MapInfo.gameMode = "DTM";
			MapInfo.creators = "ParaPenguin";
			MapInfo.version = "1.0";
			MapInfo.worldName = "senex_1";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 82, 37, -809, 0, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Lime");
			TeamManager.team1.setColor("&a");
			Spawn team1Spawn = new Spawn(MapInfo.world, 35, 20, -743, -90, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			Monument limeLeft = new Monument(new Location(MapInfo.world, 176, 23, -755), TeamManager.team1, "Left");
			DTM.monuments.add(limeLeft);
			Monument limeRight = new Monument(new Location(MapInfo.world, 176, 23, -733), TeamManager.team1, "Right");
			DTM.monuments.add(limeRight);
			Region limeSpawn = new Region(currentMap, 41, 19, -750, 29, 25, -738);
			MapInfo.protectedZones.add(limeSpawn);
			
			TeamManager.team2.setName("Cyan");
			TeamManager.team2.setColor("&3");
			Spawn team2Spawn = new Spawn(MapInfo.world, 129, 20, -743, 90, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			Monument cyanLeft = new Monument(new Location(MapInfo.world, -12, 23, -733), TeamManager.team2, "Left");
			DTM.monuments.add(cyanLeft);
			Monument cyanRight = new Monument(new Location(MapInfo.world, -12, 23, -755), TeamManager.team2, "Right");
			DTM.monuments.add(cyanRight);
			Region cyanSpawn = new Region(currentMap, 123, 19, -738, 135, 25, -750);
			MapInfo.protectedZones.add(cyanSpawn);
			
			DTM.objectives = 2;
		} else if (currentMap == "Halcyon") {
			MapInfo.mapName = "Halcyon";
			MapInfo.gameMode = "DTM";
			MapInfo.creators = "funkystudios";
			MapInfo.version = "1.0";
			MapInfo.worldName = "Halcyon";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -34.5, 85, -816.5, -90, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Purple");
			TeamManager.team1.setColor("&5");
			Spawn team1Spawn = new Spawn(MapInfo.world, 14, 75, -871, 0, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			Monument purpleLeft = new Monument(new Location(MapInfo.world, 41, 74, -773), TeamManager.team1, "Left");
			DTM.monuments.add(purpleLeft);
			Monument purpleRight = new Monument(new Location(MapInfo.world, -13, 74, -773), TeamManager.team1, "Right");
			DTM.monuments.add(purpleRight);
			Region purpleSpawn = new Region(currentMap, 19, 72, -866, 9, 85, -877);
			MapInfo.protectedZones.add(purpleSpawn);
			
			TeamManager.team2.setName("Red");
			TeamManager.team2.setColor("&4");
			Spawn team2Spawn = new Spawn(MapInfo.world, 14, 75, -761, -180, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			Monument redLeft = new Monument(new Location(MapInfo.world, -13, 74, -861), TeamManager.team2, "Left");
			DTM.monuments.add(redLeft);
			Monument redRight = new Monument(new Location(MapInfo.world, 41, 74, -861), TeamManager.team2, "Right");
			DTM.monuments.add(redRight);
			Region redSpawn = new Region(currentMap, 8, 72, -768, 19, 85, -757);
			MapInfo.protectedZones.add(redSpawn);
			
			DTM.objectives = 2;
		} else if (currentMap == "Quintlet") {
			MapInfo.mapName = "Quintlet";
			MapInfo.gameMode = "DTM";
			MapInfo.creators = "IcyCode & The_Good_1";
			MapInfo.version = "1.0";
			MapInfo.worldName = "quintlet";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -113.5, 127, 73.5, -90, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Purple");
			TeamManager.team1.setColor("&5");
			Spawn team1Spawn = new Spawn(MapInfo.world, 0.5, 72, 145, 180, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			Monument purpleFrontLeft = new Monument(new Location(MapInfo.world, -37, 74, 0), TeamManager.team1, "Front Left");
			DTM.monuments.add(purpleFrontLeft);
			Monument purpleFrontRight = new Monument(new Location(MapInfo.world, 37, 74, 0), TeamManager.team1, "Front Right");
			DTM.monuments.add(purpleFrontRight);
			Monument purpleBackLeft = new Monument(new Location(MapInfo.world, -37, 74, -37), TeamManager.team1, "Back Left");
			DTM.monuments.add(purpleBackLeft);
			Monument purpleBackRight = new Monument(new Location(MapInfo.world, 37, 74, -37), TeamManager.team1, "Back Right");
			DTM.monuments.add(purpleBackRight);
			Monument purpleMiddle = new Monument(new Location(MapInfo.world, 0, 74, -37), TeamManager.team1, "Middle");
			DTM.monuments.add(purpleMiddle);
			Region purpleSpawn = new Region(currentMap, 10, 65, 137, -10, 87, 149);
			MapInfo.protectedZones.add(purpleSpawn);
			Region purpleWalk = new Region(currentMap, -2, 70, 135, 2, 76, 104);
			MapInfo.protectedZones.add(purpleWalk);
			
			TeamManager.team2.setName("Cyan");
			TeamManager.team2.setColor("&3");
			Spawn team2Spawn = new Spawn(MapInfo.world, 0.5, 72, 0.5, 0, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			Monument cyanFrontLeft = new Monument(new Location(MapInfo.world, 37, 74, 146), TeamManager.team2, "Front Left");
			DTM.monuments.add(cyanFrontLeft);
			Monument cyanFrontRight = new Monument(new Location(MapInfo.world, -37, 74, 146), TeamManager.team2, "Front Right");
			DTM.monuments.add(cyanFrontRight);
			Monument cyanBackLeft = new Monument(new Location(MapInfo.world, 37, 74, 183), TeamManager.team2, "Back Left");
			DTM.monuments.add(cyanBackLeft);
			Monument cyanBackRight = new Monument(new Location(MapInfo.world, -37, 74, 183), TeamManager.team2, "Back Right");
			DTM.monuments.add(cyanBackRight);
			Monument cyanMiddle = new Monument(new Location(MapInfo.world, 0, 74, 183), TeamManager.team2, "Middle");
			DTM.monuments.add(cyanMiddle);
			Region cyanSpawn = new Region(currentMap, -10, 65, 10, 10, 87, -10);
			MapInfo.protectedZones.add(cyanSpawn);
			Region cyanWalk = new Region(currentMap, 2, 70, 12, -2, 76, 42);
			MapInfo.protectedZones.add(cyanWalk);
			
			DTM.objectives = 5;
		} else if (currentMap == "Kingdom") {
			MapInfo.mapName = "Kingdom";
			MapInfo.gameMode = "DTM";
			MapInfo.creators = "IcyCode, EricV4 & DefeaTheCookie";
			MapInfo.version = "1.0";
			MapInfo.worldName = "Kingdom";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 109.5, 132, -71.6, -90, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Red");
			TeamManager.team1.setColor("&4");
			Spawn team1Spawn = new Spawn(MapInfo.world, -0.5, 65, -148.5, 0, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			Monument team1Left = new Monument(new Location(MapInfo.world, 46, 83, -17), TeamManager.team1, "Left");
			DTM.monuments.add(team1Left);
			Monument team1Right = new Monument(new Location(MapInfo.world, -48, 83, -17), TeamManager.team1, "Right");
			DTM.monuments.add(team1Right);
			Region redSpawn = new Region(currentMap, -7, 56, -158, 5, 69, -115);
			MapInfo.protectedZones.add(redSpawn);
			
			TeamManager.team2.setName("Blue");
			TeamManager.team2.setColor("&9");
			Spawn team2Spawn = new Spawn(MapInfo.world, -0.5, 65, 5.5, -180, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			Monument team2Left = new Monument(new Location(MapInfo.world, -48, 83, -127), TeamManager.team2, "Left");
			DTM.monuments.add(team2Left);
			Monument team2Right = new Monument(new Location(MapInfo.world, 46, 83, -127), TeamManager.team2, "Right");
			DTM.monuments.add(team2Right);
			Region blueSpawn = new Region(currentMap, 6, 56, 15, -8, 69, -29);
			MapInfo.protectedZones.add(blueSpawn);
			
			DTM.objectives = 2;
		} else if (currentMap == "Arbaro") {
			MapInfo.mapName = "Arbaro";
			MapInfo.gameMode = "FFA";
			MapInfo.creators = "IcyCode & The_Bad_1";
			MapInfo.version = "1.0";
			MapInfo.worldName = "Arbaro";
			MapInfo.teams = 1;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 1, 120, 0, -90, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Players");
			TeamManager.team1.setColor("&6");
			Spawn spawn1 = new Spawn(MapInfo.world, -54, 64, 2, 90, 0);
			Spawn spawn2 = new Spawn(MapInfo.world, 2, 64, 51, -180, 0);
			Spawn spawn3 = new Spawn(MapInfo.world, 50, 64, 2, 90, 0);
			Spawn spawn4 = new Spawn(MapInfo.world, -2, 64, -51, 90, 0);
			Spawn spawn5 = new Spawn(MapInfo.world, -24, 86, -28, 0, 0);
			
			MapInfo.team1Spawns.add(spawn1);
			MapInfo.team1Spawns.add(spawn2);
			MapInfo.team1Spawns.add(spawn3);
			MapInfo.team1Spawns.add(spawn4);
			MapInfo.team1Spawns.add(spawn5);
		}  else if (currentMap == "BerrylandMC") {
			MapInfo.mapName = "BerrylandMC DTM";
			MapInfo.gameMode = "DTM";
			MapInfo.creators = "99250, ViceTechnicolour & Zintenka";
			MapInfo.version = "1.0";
			MapInfo.worldName = "berrylandmc";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -52, 163, 1, 0, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Red");
			TeamManager.team1.setColor("&4");
			Spawn team1Spawn = new Spawn(MapInfo.world, 19.5, 94, -87.5, 0, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			Monument team1Left = new Monument(new Location(MapInfo.world, 18, 79, 52), TeamManager.team1, "A");
			DTM.monuments.add(team1Left);
			Monument team1Right = new Monument(new Location(MapInfo.world, 18, 79, 53), TeamManager.team1, "B");
			DTM.monuments.add(team1Right);
			Region redSpawn = new Region(currentMap, 2, 102, -93, 34, 83, -80);
			MapInfo.protectedZones.add(redSpawn);
			
			
			TeamManager.team2.setName("Blue");
			TeamManager.team2.setColor("&9");
			Spawn team2Spawn = new Spawn(MapInfo.world, 18.5, 94, 100.5, -180, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			Monument team2Left = new Monument(new Location(MapInfo.world, 18, 79, -40), TeamManager.team2, "A");
			DTM.monuments.add(team2Left);
			Monument team2Right = new Monument(new Location(MapInfo.world, 18, 79, -41), TeamManager.team2, "B");
			DTM.monuments.add(team2Right);
			Region blueSpawn = new Region(currentMap, 34, 102, 104, 2, 83, 92);
			MapInfo.protectedZones.add(blueSpawn);
			
			DTM.objectives = 2;
		} else if (currentMap == "Inferno") {
			MapInfo.mapName = "Inferno";
			MapInfo.gameMode = "Red Alert";
			MapInfo.creators = "IcyCode";
			MapInfo.version = "1.0";
			MapInfo.worldName = "Inferno";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -5, 90, 45, -180, 90);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Players");
			TeamManager.team1.setColor("&6");
			Spawn spawn1 = new Spawn(MapInfo.world, 5, 73, 58, -180, 0);
			Spawn spawn2 = new Spawn(MapInfo.world, -8, 73, 44, -90, 0);
			Spawn spawn3 = new Spawn(MapInfo.world, 5, 73, 31, 0, 0);
			Spawn spawn4 = new Spawn(MapInfo.world, 18, 73, 44, 90, 0);
			
			MapInfo.team1Spawns.add(spawn1);
			MapInfo.team1Spawns.add(spawn2);
			MapInfo.team1Spawns.add(spawn3);
			MapInfo.team1Spawns.add(spawn4);
		} else if (currentMap == "Rendezvous") {
			MapInfo.mapName = "Rendezvous";
			MapInfo.gameMode = "DTM";
			MapInfo.creators = "ParaPenguin";
			MapInfo.version = "1.0";
			MapInfo.worldName = "rendezvous";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, 12, 54, -897, 0, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Red");
			TeamManager.team1.setColor("&4");
			Spawn team1Spawn1 = new Spawn(MapInfo.world, 63.5, 27, -798.5, -180, 0);
			MapInfo.team1Spawns.add(team1Spawn1);
			Spawn team1Spawn2 = new Spawn(MapInfo.world, 63.5, 27, -796.5, 0, 0);
			MapInfo.team1Spawns.add(team1Spawn2);
			Monument team1Left = new Monument(new Location(MapInfo.world, -84, 37, -763), TeamManager.team1, "Left");
			DTM.monuments.add(team1Left);
			Monument team1Right = new Monument(new Location(MapInfo.world, -84, 37, -833), TeamManager.team1, "Right");
			DTM.monuments.add(team1Right);
			Region redSpawn = new Region(currentMap, 61, 26, -788, 65, 31, -808);
			MapInfo.protectedZones.add(redSpawn);
			
			TeamManager.team2.setName("Blue");
			TeamManager.team2.setColor("&9");
			Spawn team2Spawn1 = new Spawn(MapInfo.world, -38.5, 27, -798.5, -180, 0);
			MapInfo.team2Spawns.add(team2Spawn1);
			Spawn team2Spawn2 = new Spawn(MapInfo.world, -38.5, 27, -796.5, 0, 0);
			MapInfo.team2Spawns.add(team2Spawn2);
			Monument team2Left = new Monument(new Location(MapInfo.world, 108, 37, -833), TeamManager.team2, "Left");
			DTM.monuments.add(team2Left);
			Monument team2Right = new Monument(new Location(MapInfo.world, 108, 37, -763), TeamManager.team2, "Right");
			DTM.monuments.add(team2Right);
			Region blueSpawn = new Region(currentMap, -41, 26, -808, -37, 31, -788);
			MapInfo.protectedZones.add(blueSpawn);
			
			DTM.objectives = 2;
		} else if (currentMap == "Forgotten Mine") {
			MapInfo.mapName = "Forgotten Mine";
			MapInfo.gameMode = "FFA";
			MapInfo.creators = "ReverseGamma, ImOriginal1, IcyCode";
			MapInfo.version = "1.0";
			MapInfo.worldName = "ForgottenMine";
			MapInfo.teams = 1;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -24.5, 69, 5, -90, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Players");
			TeamManager.team1.setColor("&6");
			//Spawn spawn1 = new Spawn(MapInfo.world, -42.5, 69, 19, -180, 0);
			Spawn spawn2 = new Spawn(MapInfo.world, -17.5, 69,5, -90, 0);
			Spawn spawn3 = new Spawn(MapInfo.world, 5.5, 69, 4.5, 0, 0);
			//Spawn spawn4 = new Spawn(MapInfo.world, -2, 69, -51, 90, 0);
			Spawn spawn5 = new Spawn(MapInfo.world, 6, 69, -6, 0, 0);
			Spawn spawn6 = new Spawn(MapInfo.world, 31.5, 69, 4.5, 90, 0);
			Spawn spawn7 = new Spawn(MapInfo.world, 23.5, 69, 33.5, 145, 0);
			Spawn spawn8 = new Spawn(MapInfo.world, 5.5, 69, 19.5, 0, 0);
			
			
			//MapInfo.team1Spawns.add(spawn1);
			MapInfo.team1Spawns.add(spawn2);
			MapInfo.team1Spawns.add(spawn3);
			//MapInfo.team1Spawns.add(spawn4);
			MapInfo.team1Spawns.add(spawn5);
			MapInfo.team1Spawns.add(spawn6);
			MapInfo.team1Spawns.add(spawn7);
			MapInfo.team1Spawns.add(spawn8);
		} else if (currentMap == "Rendezvous Meadows") {
			MapInfo.mapName = "Rendezvous Meadows";
			MapInfo.gameMode = "CTW";
			MapInfo.creators = "Haribo98 & Crimson_Aught";
			MapInfo.version = "1.0";
			MapInfo.worldName = "rendezvous4";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -58.5, 70, -771.5, -90, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Blue");
			TeamManager.team1.setColor("&9");
			Spawn team1Spawn = new Spawn(MapInfo.world, 23.5, 51, -887.5, 0, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			Region lBlueRoom = new Region(MapInfo.world, 63, 51, -650, 78, 62, -636);
			WoolCap team1Wool1 = new WoolCap(new Location(MapInfo.world, 21, 45, -884), TeamManager.team1, "Light Blue", DyeColor.LIGHT_BLUE, lBlueRoom);
			CTW.wools.add(team1Wool1);
			Region limeRoom = new Region(MapInfo.world, -17, 51, -652, -35, 62, -636);
			WoolCap team1Wool2 = new WoolCap(new Location(MapInfo.world, 25, 45, -884), TeamManager.team1, "Lime", DyeColor.LIME, limeRoom);
			CTW.wools.add(team1Wool2);
			//Region team1SpawnProt = new Region(currentMap, 19, 72, -866, 9, 85, -877);
			//MapInfo.protectedZones.add(team1SpawnProt);
			
			TeamManager.team2.setName("Red");
			TeamManager.team2.setColor("&4");
			Spawn team2Spawn = new Spawn(MapInfo.world, 23.5, 51, -657.5, -180, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			Region pinkRoom = new Region(MapInfo.world, -26, 51, -895, -17, 62, -911);
			WoolCap team2Wool1 = new WoolCap(new Location(MapInfo.world, 25, 45, -662), TeamManager.team2, "Pink", DyeColor.PINK, pinkRoom);
			CTW.wools.add(team2Wool1);
			Region orangeRoom = new Region(MapInfo.world, 64, 50, -894, 74, 62, -909);
			WoolCap team2Wool2 = new WoolCap(new Location(MapInfo.world, 21, 45, -662), TeamManager.team2, "Orange", DyeColor.ORANGE, orangeRoom);
			CTW.wools.add(team2Wool2);
			//Region redSpawn = new Region(currentMap, 8, 72, -768, 19, 85, -757);
			//MapInfo.protectedZones.add(redSpawn);
			
			CTW.objectives = 2;
		} else if (currentMap == "Silva") {
			MapInfo.mapName = "Silva";
			MapInfo.gameMode = "DTM";
			MapInfo.creators = "IcyCode, PeachyYas, Kammy878 & Rot43";
			MapInfo.version = "1.0";
			MapInfo.worldName = "Silva";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -64.5, 175, 44.5, 180, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Red");
			TeamManager.team1.setColor("&4");
			Spawn team1Spawn = new Spawn(MapInfo.world, -9.5, 113, 213.5, 180, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			Monument team1Left = new Monument(new Location(MapInfo.world, -34, 118, 15), TeamManager.team1, "Left");
			DTM.monuments.add(team1Left);
			Monument team1Right = new Monument(new Location(MapInfo.world, 14, 118, 15), TeamManager.team1, "Right");
			DTM.monuments.add(team1Right);
			Region redSpawn = new Region(currentMap, -17, 106, 205, -1, 122, 222);
			MapInfo.protectedZones.add(redSpawn);
			
			TeamManager.team2.setName("Green");
			TeamManager.team2.setColor("&2");
			Spawn team2Spawn = new Spawn(MapInfo.world, -9.5, 113, -0.5, 0, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			Monument team2Left = new Monument(new Location(MapInfo.world, 14, 118, 197), TeamManager.team2, "Left");
			DTM.monuments.add(team2Left);
			Monument team2Right = new Monument(new Location(MapInfo.world, -34, 118, 197), TeamManager.team2, "Right");
			DTM.monuments.add(team2Right);
			Region greenSpawn = new Region(currentMap, -2, 106, 7, -19, 122, -10);
			MapInfo.protectedZones.add(greenSpawn);
			
			DTM.objectives = 2;
		} else if (currentMap == "Deepwind Jungle") {
			MapInfo.mapName = "Deepwind Jungle";
			MapInfo.gameMode = "CTW";
			MapInfo.creators = "PandaBattalion & Rokosnoco";
			MapInfo.version = "1.2.3";
			MapInfo.worldName = "deepwind_jungle";
			MapInfo.teams = 2;
			
			Spawn spectatorSpawn = new Spawn(MapInfo.world, -50, 59, 0, 90, 0);
			MapInfo.setSpectatorSpawn(spectatorSpawn);
			
			TeamManager.team1.setName("Blue");
			TeamManager.team1.setColor("&9");
			Spawn team1Spawn = new Spawn(MapInfo.world, 0, 9, -75, 0, 0);
			MapInfo.team1Spawns.add(team1Spawn);
			Region greenRoom = new Region(MapInfo.world, 17, 0, 66,37,256,79);
			WoolCap team1Wool1 = new WoolCap(new Location(MapInfo.world, 1,10,-81), TeamManager.team1, "Green", DyeColor.GREEN, greenRoom);
			CTW.wools.add(team1Wool1);
			Region cyanRoom = new Region(MapInfo.world, -17,0,66,-37,256,79);
			WoolCap team1Wool2 = new WoolCap(new Location(MapInfo.world, -2,10,-81), TeamManager.team1, "Cyan", DyeColor.CYAN, cyanRoom);
			CTW.wools.add(team1Wool2);
			//Region team1SpawnProt = new Region(currentMap, 19, 72, -866, 9, 85, -877);
			//MapInfo.protectedZones.add(team1SpawnProt);
			
			TeamManager.team2.setName("Red");
			TeamManager.team2.setColor("&4");
			Spawn team2Spawn = new Spawn(MapInfo.world, 0, 9, 75, 180, 0);
			MapInfo.team2Spawns.add(team2Spawn);
			Region purpleRoom = new Region(MapInfo.world, -17,0,-65,-37,256,-78);
			WoolCap team2Wool1 = new WoolCap(new Location(MapInfo.world, -2,10,81), TeamManager.team2, "Purple", DyeColor.PURPLE, purpleRoom);
			CTW.wools.add(team2Wool1);
			Region yellowRoom = new Region(MapInfo.world, 17,0,-65,37,256,-78);
			WoolCap team2Wool2 = new WoolCap(new Location(MapInfo.world, 1,10,81), TeamManager.team2, "Yellow", DyeColor.YELLOW, yellowRoom);
			CTW.wools.add(team2Wool2);
			//Region redSpawn = new Region(currentMap, 8, 72, -768, 19, 85, -757);
			//MapInfo.protectedZones.add(redSpawn);
			
			CTW.objectives = 2;
		}
		
		
		/* else if (currentMap == "The Cage") {
			MapInfo.mapName = "The Cage";
			MapInfo.gameMode = "TDM";
			MapInfo.creators = "Kroest";
			MapInfo.version = "1.0";
			MapInfo.worldName = "TheCage";
			MapInfo.teams = 2;
			
			MapInfo.spectatorSpawnX = 45.5;
			MapInfo.spectatorSpawnY = 36;
			MapInfo.spectatorSpawnZ = 43.5;
			MapInfo.spectatorSpawnYaw = 90;
			MapInfo.spectatorSpawnPitch = 0;
			
			TeamManager.team1.setName("Green");
			TeamManager.team1.setColor("&2");
			
			MapInfo.team1SpawnX = 12.5;
			MapInfo.team1SpawnY = 23;
			MapInfo.team1SpawnZ = 1.5;
			MapInfo.team1SpawnPitch = (float) 0;
			MapInfo.team1SpawnYaw = (float) 0;
			
			TeamManager.team2.setName("Red");
			TeamManager.team2.setColor("&4");
			
			MapInfo.team2SpawnX = 12.5;
			MapInfo.team2SpawnY = 23;
			MapInfo.team2SpawnZ = 85.5;
			MapInfo.team2SpawnPitch = (float) 0;
			MapInfo.team2SpawnYaw = (float) -180;
		} */
	}
}
