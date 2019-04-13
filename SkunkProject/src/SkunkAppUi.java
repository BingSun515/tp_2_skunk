import org.apache.commons.text.TextStringBuilder;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

class SkunkAppUi {

	private GameController controller = new GameController();
	private String playerName = "";

	SkunkAppUi() {
	}

	static boolean getPlayerRollChoice() {
		String message = "\nDo you like to roll again ? ";
		return SkunkAppUi.getPlayerInput(message);
	}

	static int getPlayerNumericInput(String message) {
		SkunkAppUi.displayMessage(message);
		String playerInput;
		playerInput = StdIn.readLine();
		return IntegerUtil.getParsedValue(playerInput);
	}

	private static boolean getPlayerInput(String message) {
		SkunkAppUi.displayMessage(message);
		String playerInput;
		playerInput = StdIn.readLine();
		return playerInput.trim().equalsIgnoreCase("y");
	}

	static void displayResults(String message) {
		SkunkAppUi.displayMessage(message);
	}

	void startGame() {
		this.displayGameStart();
		this.controller.startGame();
	}

	private static void displayMessage(String message) {
		StdOut.print(message);
	}

	private void displayGameStart() {
		SkunkAppUi.displayMessage("Game of Skunk. Welcome!");
	}

	public static String getPlayerNameFromInput(String nthPlayer)
	{
		SkunkAppUi.displayMessage(String.format("\nEnter player name for, player %s : ", nthPlayer));
		return StdIn.readLine().trim();
	}

	/**
	 * Extend your SkunkApp so it plays a complete Round of Skunk, consisting of one
	 * or more Turns and ending when one (or more) players reach 100.
	 * 
	 * 
	 * TODO: THIS IS THE WORK NEEDED FOR 1P 1.3 + unit tests 1. ADD No. of player
	 * "input" When you start your app, read the number of players 2. loop through
	 * player count to get user name following by the names of each. 3. Initialize
	 * the attributes of each player, 4. then offer the user an option to view the
	 * complete rules for your game and display them on request. 5. Now start a new
	 * Round of Skunk, 6. consisting of a sequence of multiple Turns taken by
	 * players, one after another. 7. Each Round ends with one or more players
	 * scoring >= 100, 8. followed by a final set of Turns giving all non-100
	 * players 9. a final chance to increase their score. 10. After this, do the
	 * final accounting 11. that updates each player's chip count according to the
	 * final player scores. 12. You should have already implemented the "play one
	 * Turn" functionality in TP-1.2 , so extend it here to "play one Round"
	 * functionality, 13. keeping track of Turn scores for each player as well as
	 * their chip totals. 14. If you haven't defined a Player software class, think
	 * about doing so. 15. Each Player can track their different scores, 16. perhaps
	 * also having responsibilities for scoring Rolls and/or Turns and/or Rounds.
	 * 17. Be sure to add tests for any new software classes you create,
	 **/
	/**
	 * 
	 * striving for the JUnit test coverage of your non-UI code to be as complete
	 * (close to 100%) as possible. As discussed above, try to separate your
	 * Presentation Logic and Domain Logic as much as you can.
	 * 
	 ***/
}
