package edu.skunkApp;

import edu.princeton.cs.introcs.StdOut;

public class GameUI {
	
	public static void display(String message)
	{
		GameUI.displayMessage(message);
	}
	
	public static String display(String message, boolean getUserInput)
	{
		GameUI.displayMessage(message);
		
		if (getUserInput)
		{
			return GameUI.getPlayerInput();
		}
		return null;
	}
	
	public static void displayMessage(String message)
	{
		StdOut.print(message);
	}
	
	public static String getPlayerInput()
	{
		String playerInput = "";
//		playerInput = System.in.read();
		return playerInput.trim();
	}
}
