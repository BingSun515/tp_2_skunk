package edu.skunkApp.controller;

import java.util.ArrayList;

import org.apache.commons.text.TextStringBuilder;

import edu.skunkApp.GameUI;
import edu.skunkApp.common.Constants;
import edu.skunkApp.domainModels.PlayerDm;

public class AppUIController {

	public static ArrayList<PlayerDm> getPlayers()
	{
		//TODO: build out UI
		return new ArrayList<PlayerDm>();
	}
	
	public static String getPlayerName(String nthPlayer)
	{
		return GameUI.getPlayerInput(String.format(Constants.ENTER_PLAYER_NAME, nthPlayer));
	}
	
	public static void displayWelcome()
	{
		TextStringBuilder tb = new TextStringBuilder()
					.appendln(Constants.DOUBLE_LINE)
					.appendln(Constants.WELCOME_MESSAGE)
					.appendln(Constants.DOUBLE_LINE);
		GameUI.display(tb.toString());
	}

	public static String getPlayerCount()
	{
		return GameUI.getPlayerInput(Constants.PLAYER_INPUT);
	}
	
	public static void displayNewLineMessage(String message)
	{
		GameUI.display("\n"+message);
	}
	
	public static void displayMessage(String message)
	{
		GameUI.display(message);
	}
}
