package edu.skunkApp.common;

public class Constants
{
	public static final int WINNING_SCORE = 100;
	
	public static final String LINE = "--------------------------------------------";
	public static final String DOUBLE_LINE = "===========================================";
	
	public static final String WELCOME_MESSAGE = "Game of Skunk. Welcome!";

	public static final String PLAYER_INPUT = "Enter the # of players : ";
	public static final String CURRENT_PLAYER = " :: Current player :: ";
	public static final String PLAYER = "   PLAYER :: ";
//	public static final String WINNER = " Winner is player, ";
	public static final String MINIMUM_PLAYERS = " At Least two players needed to play this game ";
	public static final String ENTER_PLAYER_NAME = " Enter player name for, player %s : ";
	public static final String WINNER = "   PLAYER :: %1s , you are a **** WINNER ****";
	public static final String PLAYER_CONTINUE = " Do you like to continue roll ? ";
	public static final String PLAYER_ROLL_CHOICES = "Roll Choices :: Y (roll again) / N (stop my Turn) / HELP (Display game rules) / R (Round Score) / M (My Score):" ;

	public static final String LAST_ROLL = "Dice with (last) roll: %3$d => %1$d + %2$d" ;
	
	public static final String ROUND_SUMMARY = "               ROUND SUMMARY               ";
	public static final String GAME_SUMMARY = "               GAME SUMMARY               ";

	public static final String GAME_RULES = "               GAME RULES               ";
	
	public static final String SINGLE_SKUNK = " Last roll was a single skunk !! \n  Player loses turn and turn points.";
	public static final String DEUCE_SKUNK = " Last roll was a deuce skunk !! \\n  Player loses turn and turn points.";
	public static final String DOUBLE_SKUNK = " Last roll was a double skunk !!  \\n  Player loses turn, round and all scored points.";
//	Last roll was a single skunk
	
	public static final String GAME_RULE1 = "1:Each letter of skunk represents a different round of the game; Total 5 rounds per Game.\n";
	
	public static final String GAME_RULE2 = "2:A player gets the total of the dice and records it in his or her turn.\n";
	
	public static final String GAME_RULE3 = "3:If a \"one\" comes up, play is over for that round and all the player's points in that column are wiped out.\n";
	
	public static final String GAME_RULE4 = "4:If \"double ones\" comes up, all points accumulated in prior columns are wiped out as well.\n";
	
	public static final String GAME_RULE5 = "5:If a \"one\" doesn't occur, the player may choose either to try for more points on the next roll or to stop and keep what he or she has accumulated.\n";
	
	public static final String GAME_RULE6 = "6:A skunk in any series draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\n";
	
	public static final String GAME_RULE7 = "7:A skunk and a deuce draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.\n";
	
	public static final String GAME_RULE8 = "8:TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. Player must again start to score from scratch.";
	
}
