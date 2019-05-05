package edu.skunkApp.data;

import java.util.UUID;
import edu.skunkApp.common.SkunkEnum;

/**
 * in-memory table
 * */
public class RollScore {
	public Integer id;
	public UUID playerId;
	public UUID roundId;
	public UUID turnId;
	UUID rollId;
	int die1;
	int die2;
	int diceTotal;
	SkunkEnum rollStatus;
	public int turnTotal;
	public int roundTotal;
}