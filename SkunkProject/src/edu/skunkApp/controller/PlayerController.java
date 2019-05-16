package edu.skunkApp.controller;

import java.util.ArrayList;

import edu.skunkApp.GameUI;
import edu.skunkApp.common.Constants;
import edu.skunkApp.common.IntegerUtil;
import edu.skunkApp.domainModels.PlayerDm;

public class PlayerController {

	public static ArrayList<PlayerDm> getNewPlayers()
	{		
		//UI will ask for how many players
		int playerCount = 0;
		do
		{
			String playerCountInput = PlayerController.getPlayerCount();
			playerCount = IntegerUtil.getParsedValue(playerCountInput);
			
			if (playerCount < 2)
			{
				AppUIController.displayNewLineMessage(Constants.MINIMUM_PLAYERS);
			}
			
		} while(playerCount < 2);

		return getNewPlayerNames(playerCount);
	}
	
	public static ArrayList<PlayerDm> getNewPlayerNames(int playerCount)
	{
		String playerName;

		ArrayList<PlayerDm> players = new ArrayList<PlayerDm>();
		
		for (int i= 0; i < playerCount; i++)
		{
			do
			{
				playerName = PlayerController.getPlayerName("" + players.size() + 1);
			} while (!validatePlayerName(playerName));
			
			PlayerDm player = new PlayerDm();
			player.name = playerName;
			players.add(player);
		}

		return players;
	}
		
	public static boolean validatePlayerName(String playerName)
	{
		if (playerName.isBlank() || playerName.isEmpty())
		{
			AppUIController.displayNewLineMessage(Constants.INVALID_PLAYER_NAME);
			return false;
		}
		return true;
	}

	//TODO: move this to PlayerInitController.java ?
	public static String getPlayerName(String nthPlayer)
	{
		return GameUI.getPlayerInput(String.format(Constants.ENTER_PLAYER_NAME, nthPlayer));
	}

	public static String getPlayerCount()
	{
		return GameUI.getPlayerInput(Constants.PLAYER_INPUT);
	}
	
}
