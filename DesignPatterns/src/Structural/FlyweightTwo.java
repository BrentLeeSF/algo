package Structural;

import java.util.Random;
import java.util.HashMap;

/** A common interface for all players */
interface Player {
	public void assignBall(String ball);

	public void mission();
}

/** Basketball player must have ball type and mission */
class Basketball implements Player {

	/** Intrinsic Attribute */
	private final String PLAYBASEKTBALL;

	/** Extrinsic Attribute */
	private String ball;

	public Basketball() {
		PLAYBASEKTBALL = "Play Basketball";
	}

	public void assignBall(String ball) {
		this.ball = ball;
	}

	public void mission() {
		System.out.println("Basketball player with " + ball + " Task is " + PLAYBASEKTBALL);
	}
}

/** Basketball player must have ball type and mission */
class Baseball implements Player {

	/** Intrinsic Attribute */
	private final String BASEBALLPLAYER;

	/** Extrinsic Attribute */
	private String ball;

	public Baseball() {
		BASEBALLPLAYER = "Play Baseball";
	}

	public void assignBall(String ball) {
		this.ball = ball;
	}

	public void mission() {
		System.out.println("Baseball player with " + ball + " Task is " + BASEBALLPLAYER);
	}
}

class PlayerFactory {

	/** HashMap stores the reference to the type of player */
	private static HashMap<String, Player> hm = new HashMap<String, Player>();

	public static Player getPlayer(String type) {

		Player p = null;

		if (hm.containsKey(type))
			p = hm.get(type);
		else {

			switch (type) {
			case "basketball":
				System.out.println("Basketball Created");
				p = new Basketball();
				break;
			case "baseball":
				System.out.println("Baseball Created");
				p = new Baseball();
				break;
			default:
				System.out.println("Unreachable code!");
			}

			/** Once created insert it into the HashMap */
			hm.put(type, p);
		}
		return p;
	}
}

public class FlyweightTwo {

	/**
	 * All player types and arena (used by getRandPlayerType() and getRandArena()
	 */
	private static String[] playerType = { "basketball", "baseball" };
	private static String[] arenaStuff = { "Appropirate shoes", "uniform", "Jersey", "Bobble Heads" };

	public static void main(String args[]) {

		/** Assume that we have a total of 10 players in the game. */
		for (int i = 0; i < 10; i++) {

			/** getPlayer() is called using class name since method is static */
			Player p = PlayerFactory.getPlayer(getRandPlayerType());

			/** Assign an arena item chosen randomly from the arenaStuff array */
			p.assignBall(getRandArena());

			/** Send this player on a mission */
			p.mission();
		}
	}

	/** Utility methods to get a random player type and arena stuff */
	public static String getRandPlayerType() {
		Random r = new Random();

		/** Will return an integer between [0,2) */
		int randInt = r.nextInt(playerType.length);

		/** return the player stored at index 'randInt' */
		return playerType[randInt];
	}

	public static String getRandArena() {
		Random r = new Random();

		/** Will return an integer between [0,5) */
		int randInt = r.nextInt(arenaStuff.length);

		/** Return the arena stuff stored at index 'randInt' */
		return arenaStuff[randInt];
	}
}
