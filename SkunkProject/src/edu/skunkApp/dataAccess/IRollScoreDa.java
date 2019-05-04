package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import edu.skunkApp.data.RollScore;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreDa {
	public void createRollScore(RollScoreDm score);
	public int getLastRoundScore(UUID roundId);
	public void resetRoundScore(UUID roundId);

	ArrayList<RollScoreDm> get();
}
