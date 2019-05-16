package edu.skunkApp.controller;

import java.util.ArrayList;

import org.apache.commons.text.TextStringBuilder;

import edu.skunkApp.GameUI;
import edu.skunkApp.common.Constants;
import edu.skunkApp.common.IntegerUtil;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollScoreDm;

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
			playerName = PlayerController.getPlayerName("" + (players.size() + 1));
			
			PlayerDm player = new PlayerDm();
			player.name = playerName;
			players.add(player);
		}

		return players;
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

	public static void displayWinnerAndChoices(String playerName)
	{
		TextStringBuilder tb = new TextStringBuilder()
				.appendln(Constants.DOUBLE_LINE)
				.appendln(String.format(Constants.WINNER, playerName))
				.appendln(Constants.DOUBLE_LINE)
				.appendln(Constants.PLAYER_CONTINUE);
		GameUI.display(tb.toString());
	}
	
	public static void displayRollScoreSummary(RollScoreDm score) {

		TextStringBuilder tb = new TextStringBuilder().appendln(Constants.LINE)
				.appendln(String.format(Constants.LAST_ROLL, score.roll.die1, score.roll.die2, score.roll.diceTotal))
				.appendln(Constants.LINE);
	}

}
