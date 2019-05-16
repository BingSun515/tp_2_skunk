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
	public UUID rollId;
	public int die1;
	public int die2;
	public int diceTotal;
	public SkunkEnum rollStatus;
	public int turnTotal;
	public int roundTotal;
}
