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
		message += "\nEnter (y/n):";
		SkunkAppUi.displayMessage(message);
		return SkunkAppUi.getPlayerInput();
	}
	
	public static boolean getPlayerInput()
	{
		String playerInput;
		playerInput = StdIn.readLine();
		return playerInput.equalsIgnoreCase("y");
	}

	public void displayGameStart()
	{
		String message = "Game of Skunk. Welcome!";
		message+= "\n";
		message+= "Enter a player name : ";
		SkunkAppUi.displayMessage(message);
		this.getPlayerName();
	}
	
	public void displayPlayerPlayDenialMessage()
	{
		String message = " Player :: " + this.controller.getPlayerName() + " preferred not to play at this time";
		SkunkAppUi.displayMessage(message);
	}
	
	private void getPlayerName()
	{
		String playerName = StdIn.readLine();
		Player player = new Player(playerName);
		this.controller.setPlayer(player);
		//test remove later
		SkunkAppUi.displayMessage("Player name is :: " + this.controller.getPlayer().getPlayerName());
	}
	
	private static void displayMessage(String message)
	{
		StdOut.print(message);
	}
}
