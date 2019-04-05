import org.apache.commons.text.TextStringBuilder;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkAppUi {

	private GameController controller = new GameController();
	private String playerName = "";

	SkunkAppUi()
	{		
	}

	public static boolean getPlayerRollChoice()
	{
		String message = "\nDo you like to roll again ? ";
		return SkunkAppUi.getPlayerInput(message);
	}
	
	public static boolean getPlayerInput(String message)
	{
		SkunkAppUi.displayMessage(message);
		String playerInput;
		playerInput = StdIn.readLine();
		return playerInput.trim().equalsIgnoreCase("y");
	}

	public static void displayResults(String message)
	{
		SkunkAppUi.displayMessage(message);
	}
	
	public void displayPlayerPlayDenialMessage()
	{
		String message = String.format(" Player :: %s preferred not to play at this time", this.controller.getPlayerName());
		SkunkAppUi.displayMessage(message);
	}
	
	public void startGame()
	{//1
		this.displayGameStart();
		this.setPlayerNameFromInput();
		this.controller.startGame(this.playerName);
	}


	private static void displayMessage(String message)
	{
		StdOut.print(message);
	}

	private void displayGameStart()
	{//2
		TextStringBuilder tb = new TextStringBuilder();
		tb.appendln("Game of Skunk. Welcome!");
		tb.appendln("Enter a player name : ");
		SkunkAppUi.displayMessage(tb.toString());
	}
		
	private void setPlayerNameFromInput()
	{//3
		String userInput = StdIn.readLine();
		this.playerName = userInput;
	}
	
}
