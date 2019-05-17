package edu.skunkApp;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class GameUI {
	
	public static void display(String message)
	{
		GameUI.displayMessage(message);
	}
	
	public static String getPlayerInput(String message)
	{
		GameUI.displayMessage("\n"+message);
		return StdIn.readString().trim().toUpperCase();
	}
	
	public static void displayMessage(String message)
	{
		StdOut.print(message);
	}

}
