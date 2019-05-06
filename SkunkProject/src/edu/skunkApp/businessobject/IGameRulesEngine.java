package edu.skunkApp.businessobject;

import java.util.stream.Stream;

import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IGameRulesEngine {
	
	public boolean getGameStatus(int roundTotal);
	public void moveChips(RollScoreDm rollScoreDm, Stream<PlayerDm> losers);

	public void setSkunkAndScore(RollScoreDm rollScoreDm, RollScoreDm previousScoreDm);
	public boolean isRollSingleSkunk(RollDm roll);
	public boolean isRollDoubleSkunk(RollDm roll);
	public boolean isRollDeuceSkunk(RollDm roll);

}
