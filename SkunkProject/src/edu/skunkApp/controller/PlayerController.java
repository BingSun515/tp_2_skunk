package edu.skunkApp.controller;

import java.util.ArrayList;
import java.util.UUID;

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
			player.playerId = UUID.randomUUID();
			player.name = playerName;
			players.add(player);
		}

		return players;
	}

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

		TextStringBuilder tb = new TextStringBuilder()
				.appendln("\n"+String.format(Constants.LAST_ROLL, score.roll.die1, score.roll.die2, score.roll.diceTotal))
				.appendln(Constants.LINE);
		GameUI.display(tb.toString());
	}

	public static void displaySkunkSummary(RollScoreDm score) {

		String skunkMessage = "";
		
		switch (score.rollStatus) {
		case SINGLESKUNK:
			skunkMessage = Constants.SINGLE_SKUNK;
			break;
		case DEUCESKUNK:
			skunkMessage = Constants.DEUCE_SKUNK;
			break;
		case DOUBLESKUNK:
			skunkMessage = Constants.DOUBLE_SKUNK;
			break;
		default:
			
			break;
		}
		
		TextStringBuilder tb = new TextStringBuilder().appendln(Constants.LINE)
				.appendln(String.format(Constants.LAST_ROLL, score.roll.die1, score.roll.die2, score.roll.diceTotal))
				.appendln(skunkMessage)
				.appendln(Constants.LINE);
		GameUI.display(tb.toString());
	}

	public static void displayCurrentPlayer(String playerName)
	{
		GameUI.display("\n" + Constants.CURRENT_PLAYER + playerName + "\n");
	}
	
	public static void displayPlayerName(String playerName)
	{
		GameUI.display("\n" + Constants.PLAYER + playerName + "\n");
	}

	public static void displayRoundSummary(String roundName)
	{
		TextStringBuilder tb = new TextStringBuilder()
				.appendln(Constants.ROUND_SUMMARY)
//				.appendln(Constants.PLAYER + playerName)
				.appendln(Constants.LINE);
		GameUI.display(tb.toString());
	}
}
