package edu.skunkApp.controller;

import org.apache.commons.text.TextStringBuilder;

import edu.skunkApp.GameUI;
import edu.skunkApp.common.Constants;

public class AppUIController {

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

	public static void displayHelp()
	{
		String message = Constants.GAME_RULE1 +
							Constants.GAME_RULE2 +
							Constants.GAME_RULE3 +
							Constants.GAME_RULE4 +
							Constants.GAME_RULE5 +
							Constants.GAME_RULE6 +
							Constants.GAME_RULE8;
				
		GameUI.display(message);
	}
}

