package edu.skunkApp.businessobject;

import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IGameRulesEngine {
	public void validateScore(RollScoreDm rollScoreDm);
	public void updateSkunkScores(RollScoreDm rollScoreDm);

	public void setSkunkAndScore(RollScoreDm rollScoreDm);
	public boolean isRollSingleSkunk(RollDm roll);
	public boolean isRollDoubleSkunk(RollDm roll);
	public boolean isRollDeuceSkunk(RollDm roll);
}
