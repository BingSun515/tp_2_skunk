package edu.skunkApp.businessobject;

import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreBo {
	void createRollScore(RollScoreDm rollScoreDm);
	
	void setSkunkScores(RollScoreDm rollScoreDm);
	void resetRollScoreForSkunk(RollScoreDm rollScoreDm);
}
