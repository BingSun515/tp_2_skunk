package edu.skunkApp.data;

import edu.skunkApp.common.SkunkEnum;
/**
 * in-memory table
 * */
public class RollScore {
	int id;
	int playerId;
	int roundId;
	int turnId;
	int rollId;
	int die1;
	int die2;
	int diceTotal;
	SkunkEnum rollStatus;
	int TurnTotal;  //insert a NEW row
	int kittyChange; // TODO : TO WORK ON THIS
	int chipChange; // TODO : TO WORK ON THIS
}
