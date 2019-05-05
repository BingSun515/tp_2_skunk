package edu.skunkApp.businessobject;

import java.util.ArrayList;

import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IGameRulesEngine {
	public void setSkunkAndScore(RollScoreDm rollScoreDm, RollScoreDm previousScoreDm);

	public void moveChips(RollScoreDm rollScoreDm, ArrayList<PlayerDm> losers);

	public boolean isRollSingleSkunk(RollDm roll);
	public boolean isRollDoubleSkunk(RollDm roll);
	public boolean isRollDeuceSkunk(RollDm roll);

}
