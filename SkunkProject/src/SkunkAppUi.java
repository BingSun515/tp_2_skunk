import org.apache.commons.text.TextStringBuilder;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

class SkunkAppUi {

	private GameController controller = new GameController();

	SkunkAppUi() {
	}

	static String getPlayerRollChoice() {
		TextStringBuilder message = new TextStringBuilder("\n  Roll Choices :: Y (roll again) / N (stop my Turn) / HELP (Display game rules)")
				.appendln("\n  Do you like to roll again ? ");
		return SkunkAppUi.getPlayerInput(message.toString());
	}

	static int getPlayerNumericInput(String message) {
		SkunkAppUi.displayMessage(message);
		String playerInput;
		playerInput = StdIn.readLine();
		return IntegerUtil.getParsedValue(playerInput);
	}

	static void displayResults(String message) {
		SkunkAppUi.displayMessage(message);
	}

	static String getPlayerNameFromInput(String nthPlayer)
	{
		SkunkAppUi.displayMessage(String.format("\nEnter player name for, player %s : ", nthPlayer));
		return StdIn.readLine().trim();
	}

	void startGame() {
		this.displayGameStart();
		this.controller.startGame();
	}

	private static String getPlayerInput(String message) {
		SkunkAppUi.displayMessage(message);
		String playerInput;
		playerInput = StdIn.readLine();
		return playerInput.trim();
	}

	private static void displayMessage(String message) {
		StdOut.print(message);
	}

	private void displayGameStart() {
		SkunkAppUi.displayMessage("Game of Skunk. Welcome!");
	}
	//TODO: DELETE THIS BEFORE MERGE INTO DEVELOP
	/**
	 * Extend your SkunkApp so it plays a complete Round of Skunk, consisting of one
	 * or more Turns and ending when one (or more) players reach 100.
	 * 
	 * 
	 * TODO: THIS IS THE WORK NEEDED FOR 1P 1.3 + unit tests
	 * 1. DONE: ADD No. of player "input" When you start your app, read the number of players
	 * 2. DONE: loop through player count to get user name following by the names of each.
	 * 3. DONE: Initialize the attributes of each player,
	 * 4. DONE: then offer the user an option to view the complete rules for your game and display them on request.
	 * 5. DONE: Now start a new Round of Skunk,
	 * 6. DONE: consisting of a sequence of multiple Turns taken by players, one after another. 
	 * 7. DONE: Each Round ends with one or more players	 scoring >= 100, 
	 * 8. DONE: followed by a final set of Turns giving all non-100 players a final chance to increase their score. 
	 * 9. DONE: After this, do the final accounting that updates each player's chip count according to the final player scores. 
	 * 10. You should have already implemented the "play one Turn" functionality in TP-1.2 ,so extend it here to "play one Round" functionality, 
	 * 11. keeping track of Turn scores for each player as well as their chip totals. 
	 * 12. If you haven't defined a Player software class, think about doing so. 
	 * 13. Each Player can track their different scores, 
	 * 14. perhaps also having responsibilities for scoring Rolls and/or Turns and/or Rounds.
	 * 15. Be sure to add tests for any new software classes you create,
	 **/
	/**
	 * 
	 * striving for the JUnit test coverage of your non-UI code to be as complete
	 * (close to 100%) as possible. As discussed above, try to separate your
	 * Presentation Logic and Domain Logic as much as you can.
	 * 
	 ***/
}
