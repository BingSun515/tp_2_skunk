package edu.skunkApp.common;

public class Constants
{
	public static final String LINE = "--------------------------------------------";
	public static final String DOUBLE_LINE = "===========================================";
	
	public static final String WELCOME_MESSAGE = "Game of Skunk. Welcome!";

	public static final String PLAYER_INPUT = "Enter the # of players : ";
	public static final String CURRENT_PLAYER = " :: Current PLAYER :: ";
	public static final String PLAYER_NAME = "   PLAYER NAME:: ";
	public static final String WINNER = " Winner is player, ";
	public static final String MINIMUM_PLAYERS = " Two players needed to play this game ";
	public static final String ENTER_PLAYER_NAME = " Enter player name for, player %s : ";
	public static final String INVALID_PLAYER_NAME = " Invalid player name. ";
	public static final String PLAYER_ROLL_CHOICES = "Roll Choices :: Y (roll again) / N (stop my Turn) / HELP (Display game rules) / R (Round Score) / A (My Score)" ;

	public static final String LAST_ROLL = "Dice with last roll: %3$d => %1$d + %2$d" ;
	
	public static final String GAME_SUMMARY = "               GAME SUMMARY               ";

	public static final String GAME_RULES = "               GAME RULES               ";
	
	
	public static final String GAME_RULE1 = "1:Each letter of skunk represents a different round of the game; Total 5 rounds per Game.";
	
	public static final String GAME_RULE2 = "2:A player gets the total of the dice and records it in his or her turn.";
	
	public static final String GAME_RULE3 = "3:If a \"one\" comes up, play is over for that round and all the player's points in that column are wiped out.";
	
	public static final String GAME_RULE4 = "4:If \"double ones\" comes up, all points accumulated in prior columns are wiped out as well.";
	
	public static final String GAME_RULE5 = "5:If a \"one\" doesn't occur, the player may choose either to try for more points on the next roll or to stop and keep what he or she has accumulated.";
	
	public static final String GAME_RULE6 = "6:A skunk in any series draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.";
	
	public static final String GAME_RULE7 = "7:A skunk and a deuce draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.";
	
	public static final String GAME_RULE8 = "8:TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. Player must again start to score from scratch.";
	
	
//	TextStringBuilder tb = new TextStringBuilder().appendln(Constants.getUiMessage("aLine"))
//			.appendln(Constants.getUiMessage("gameRules")).appendln(Constants.getUiMessage("aLine"))
//			.appendln("1:Each letter of skunk represents a different round of the game; Total 5 rounds per Game.")
//			.appendln("2:A player gets the total of the dice and records it in his or her turn")
//			.appendln("3:If a \"one\" comes up, play is over for that round and all the player's points in that column are wiped out.") 
//			.appendln("4:If \"double ones\" comes up, all points accumulated in prior columns are wiped out as well.")
//			.appendln("5:If a \"one\" doesn't occur, the player may choose either to try for more points on the next roll or to stop and keep what he or she has accumulated.")
//			.appendln("6:A skunk in any series draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.")
//			.appendln("7:A skunk and a deuce draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.")
//			.appendln("8:TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. Player must again start to score from scratch.")
//			.appendln(Constants.getUiMessage("aLine"));
}
