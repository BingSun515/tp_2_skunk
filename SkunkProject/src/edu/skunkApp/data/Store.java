package edu.skunkApp.data;

import java.util.ArrayList;

public class Store {

	private static final ArrayList<Integer> kittySingleton = new ArrayList<Integer>();
	private static final ArrayList<Player> playerSingleton = new ArrayList<Player>();
	private static final ArrayList<RollScore> rollScoreSingleton = new ArrayList<RollScore>();
	private static final ArrayList<Round> roundSingleton = new ArrayList<Round>();

	public static ArrayList<Integer> getKitty()
	{
		return kittySingleton;
	}
	
	public static ArrayList<Player> getPlayer()
	{
		return playerSingleton;
	}
	
	public static ArrayList<RollScore> getRollScore()
	{
		return rollScoreSingleton;
	}
	
	public static ArrayList<Round> getRound()
	{
		return roundSingleton;
	}
}
