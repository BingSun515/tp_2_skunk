package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.UUID;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreDa {
	public void create(RollScoreDm score);
	public ArrayList<RollScoreDm> baseQuery();
	public ArrayList<RollScoreDm> getFilteredRollScore(UUID playerId, UUID turnId, UUID roundId);
	public RollScoreDm getPlayerTurnScore(UUID playerId, UUID turnId);
	public RollScoreDm getLastRollScore();

	public void resetPlayerScore(UUID playerId);
	public void resetPlayerTurnScore(UUID playerId, UUID turnId);

}
