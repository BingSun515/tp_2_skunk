package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreDa {
	public void create(RollScoreDm score);
	public int getLastRoundScore(UUID roundId);
	public void resetPlayerScore(UUID playerId);
	
	ArrayList<RollScoreDm> get();
}
