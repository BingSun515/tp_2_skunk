import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkAppUi {

	GameController controller = new GameController();
	
	SkunkAppUi()
	{
		
	}
	
	public static boolean canStartGame()
	{
		String message = "\nThe Game is about to begin";
		message += "\nAre you ready to roll ?";
		message += "\nEnter (y/n): ";
		
		return SkunkAppUi.getPlayerInput(message);
	}

	public static boolean getPlayerRollChoice()
	{
		String message = "Do you like to roll again ?";
		return SkunkAppUi.getPlayerInput(message);
	}
	
	public static boolean getPlayerInput(String message)
	{
		SkunkAppUi.displayMessage(message);
		String playerInput;
		playerInput = StdIn.readLine();
		return playerInput.trim().equalsIgnoreCase("y");
	}

	public void displayGameStart()
	{
		String message = "Game of Skunk. Welcome!";
		message+= "\n";
		message+= "Enter a player name : ";
		SkunkAppUi.displayMessage(message);
		this.getPlayerNameFromPlayer();
	}
	
	public void displayPlayerPlayDenialMessage()
	{
		String message = " Player :: " + this.controller.getPlayerName() + " preferred not to play at this time";
		SkunkAppUi.displayMessage(message);
	}
	
	public void startGame()
	{
		this.controller.startGame();
	}
	
	private void getPlayerNameFromPlayer()
	{
		String playerName = StdIn.readLine();
		Player player = new Player(playerName);
		this.controller.setPlayer(player);
		//test remove later
//		SkunkAppUi.displayMessage("Player name is :: " + this.controller.getPlayer().getPlayerName());
	}
	
	public static void displayResults(String message)
	{
		SkunkAppUi.displayMessage(message);
	}
	
	private static void displayMessage(String message)
	{
		StdOut.print(message);
	}
}
