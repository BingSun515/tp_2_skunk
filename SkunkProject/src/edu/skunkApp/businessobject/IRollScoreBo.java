package edu.skunkApp.businessobject;

import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreBo {
	void create(RollScoreDm rollScoreDm);
	public RollScoreDm getLastRollScore();
	void resetPlayerScoresForSkunk(RollScoreDm rollScoreDm);
	void setScoreFromWinnerChoice(boolean winnerContinues);
}
