package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreDa {
	public void create(RollScoreDm score);
	public int getLastRoundScore(UUID roundId);
	public RollScoreDm getLastTurnScore(UUID playerId, UUID turnId);

	public void resetPlayerScore(UUID playerId);
	public void resetPlayerTurnScore(UUID playerId, UUID turnId);
	ArrayList<RollScoreDm> get();
}
