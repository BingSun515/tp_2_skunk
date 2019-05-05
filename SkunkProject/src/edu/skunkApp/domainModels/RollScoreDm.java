package edu.skunkApp.domainModels;

import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.common.GameStatusEnum;
import java.util.UUID;
/**
 * Domain model for Rollscore(.java) in-memory table. 
 * */
public class RollScoreDm {
	public int id;
	public UUID playerId;
	public UUID roundId;
	public UUID turnId;
	public UUID rollId;
	public RollDm roll;
	public SkunkEnum rollStatus;
	public int TurnTotal;  //insert a calculated row
	public int kittyChange;
	public int chipChange;
	public GameStatusEnum gameStatus;
}
