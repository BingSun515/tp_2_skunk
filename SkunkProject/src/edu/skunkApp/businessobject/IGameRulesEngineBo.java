package edu.skunkApp.businessobject;

import java.util.ArrayList;

import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IGameRulesEngineBo {
	
	public boolean getGameStatus(int roundTotal);
	public void moveChips(RollScoreDm rollScoreDm, ArrayList<PlayerDm> losers);

	public void setSkunkAndScore(RollScoreDm rollScoreDm, RollScoreDm previousScoreDm, boolean hasWinner);
	public boolean isRollSingleSkunk(RollDm roll);
	public boolean isRollDoubleSkunk(RollDm roll);
	public boolean isRollDeuceSkunk(RollDm roll);
	
	public GameStatusEnum getGameStatus();
	public boolean canContinueTurn();
}
