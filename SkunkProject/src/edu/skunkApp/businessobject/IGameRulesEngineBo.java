package edu.skunkApp.businessobject;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IGameRulesEngineBo {
	
	public boolean getGameStatus(int roundTotal);
	public void moveChipsFromLosers(RollScoreDm rollScoreDm, ArrayList<PlayerDm> losers);

	public void setSkunkAndScore(RollScoreDm rollScoreDm, RollScoreDm previousScoreDm);
	public boolean isRollSingleSkunk(RollDm roll);
	public boolean isRollDoubleSkunk(RollDm roll);
	public boolean isRollDeuceSkunk(RollDm roll);
	
	public void resetPlayerScoresForSkunk(RollScoreDm rollScoreDm);
	public void setGameStatus(RollScoreDm rollScoreDm);
	public GameStatusEnum getGameStatus();
	public boolean canContinueRoll();
	public int getGoalScore();
}
