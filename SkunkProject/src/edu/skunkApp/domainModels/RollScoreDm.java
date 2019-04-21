package edu.skunkApp.domainModels;

import edu.skunkApp.common.SkunkEnum;

/**
 * Domain model for Rollscore(.java) in-memory table. 
 * */
public class RollScoreDm {
	int id;
	int playerId;
	int roundId;
	int turnId;
	int rollId;
	int die1;
	int die2;
	int diceTotal;
	SkunkEnum rollStatus;
	int TurnTotal;  //insert a calculated row
	int kittyChange;
	int chipChange;
}
