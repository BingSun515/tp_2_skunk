package edu.skunkApp.UI;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class SkunkAppUI {

	public static void main(String[] args)
	{
//		SkunkAppUi gameUi = new SkunkAppUi();
		
		System.out.print("Hello world !!!");
//		StdOut.println("Hello World");
//		gameUi.startGame();
		
//		SkunkAppUI ui = new SkunkAppUI();
		SkunkAppUI.getUserInput();
	}
	public static void getUserInput()
	{
		TextIO textIO = TextIoFactory.getTextIO();
		String user = textIO.newStringInputReader()
		        .withDefaultValue("admin")
		        .read("Username");
		
		System.out.println(user);
	}
}
