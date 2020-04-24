package me.icycode.orbit.match;

public class GameState {

	public static boolean IN_LOBBY, STARTING, COUNTDOWN, IN_GAME, REBOOTING;

	public static void setIn_Lobby() {
		IN_LOBBY = true;
		STARTING = false;
		COUNTDOWN = false;
		IN_GAME = false;
		REBOOTING = false;
	}

	public static void setStarting() {
		IN_LOBBY = false;
		STARTING = true;
		COUNTDOWN = false;
		IN_GAME = false;
		REBOOTING = false;
	}

	public static void setCountdown() {
		IN_LOBBY = false;
		STARTING = false;
		COUNTDOWN = true;
		IN_GAME = false;
		REBOOTING = false;
	}

	public static void setIn_Game() {
		IN_LOBBY = false;
		STARTING = false;
		COUNTDOWN = false;
		IN_GAME = true;
		REBOOTING = false;
	}

	public static void setRebooting() {
		IN_LOBBY = false;
		STARTING = false;
		COUNTDOWN = false;
		IN_GAME = false;
		REBOOTING = true;
	}

}
