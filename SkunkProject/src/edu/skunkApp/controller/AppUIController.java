package edu.skunkApp.controller;

import org.apache.commons.text.TextStringBuilder;

import edu.skunkApp.GameUI;
import edu.skunkApp.common.Constants;

public class AppUIController {
//
//	public static ArrayList<PlayerDm> getPlayers()
//	{
//		//TODO: build out UI
//		return new ArrayList<PlayerDm>();
//	}
//	
	public static void displayWelcome()
	{
		TextStringBuilder tb = new TextStringBuilder()
					.appendln(Constants.DOUBLE_LINE)
					.appendln(Constants.WELCOME_MESSAGE)
					.appendln(Constants.DOUBLE_LINE);
		GameUI.display(tb.toString());
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
