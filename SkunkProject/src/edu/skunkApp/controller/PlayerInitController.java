package edu.skunkApp.controller;

import java.util.ArrayList;

import edu.skunkApp.common.Constants;
import edu.skunkApp.common.IntegerUtil;
import edu.skunkApp.domainModels.PlayerDm;

public class PlayerInitController {

	public static ArrayList<PlayerDm> getNewPlayers()
	{		
		//UI will ask for how many players
		int playerCount = 0;
		do
		{
			String playerCountInput = AppUIController.getPlayerCount();
			playerCount = IntegerUtil.getParsedValue(playerCountInput);
			
			if (playerCount < 2)
			{
				AppUIController.displayNewLineMessage(Constants.MINIMUM_PLAYERS);
			}
			
		} while(playerCount > 1);
		
		return getNewPlayerNames(playerCount);
	}
	
	public static ArrayList<PlayerDm> getNewPlayerNames(int playerCount)
	{
		String playerName;
		ArrayList<PlayerDm> players = new ArrayList<PlayerDm>();
		do
		{
			playerName = AppUIController.getPlayerName(""+playerCount);
			if (validatePlayerName(playerName))
			{
				PlayerDm player = new PlayerDm();
				player.name = playerName;
				players.add(player);
			}
		} while(players.size() == playerCount);

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


}
