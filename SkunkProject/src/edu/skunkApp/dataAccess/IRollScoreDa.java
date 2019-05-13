package edu.skunkApp.dataAccess;

import java.util.UUID;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreDa {
	public void create(RollScoreDm score);
	public RollScoreDm getPlayerTurnScore(UUID playerId, UUID turnId);
	public RollScoreDm getLastRollScore();

	public void resetPlayerScore(UUID playerId);
	public void resetPlayerTurnScore(UUID playerId, UUID turnId);

}
