package edu.skunkApp.data;

import java.util.UUID;
import edu.skunkApp.common.SkunkEnum;

/**
 * in-memory table
 * */
public class RollScore {
	public Integer id;
	UUID playerId;
	public UUID roundId;
	UUID turnId;
	UUID rollId;
	int die1;
	int die2;
	int diceTotal;
	SkunkEnum rollStatus;
	int turnTotal;  //insert a NEW row
	public int roundTotal;  //insert a NEW row
	int kittyChange; // TODO : TO WORK ON THIS
	int chipChange; // TODO : TO WORK ON THIS
}
