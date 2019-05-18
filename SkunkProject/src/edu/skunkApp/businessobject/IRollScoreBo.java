package edu.skunkApp.businessobject;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreBo {
	public void create(RollScoreDm rollScoreDm);
	public RollScoreDm getLastRollScore();
	public void resetPlayerScoresForSkunk(RollScoreDm rollScoreDm);
	public void setScoreFromWinnerChoice(boolean winnerContinues, RollScoreDm lastRollScoreDm);
	public void createRollScoreForWinner(UUID playerId, ArrayList<PlayerDm> losers);
	public void moveKittyChangeToWinner(RollScoreDm rollScoreDm);
	public ArrayList<PlayerDm> getScores(UUID playerId, UUID roundId, UUID turnId);

}
