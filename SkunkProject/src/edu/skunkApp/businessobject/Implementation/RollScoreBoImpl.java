package edu.skunkApp.businessobject.Implementation;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IGameRulesEngine;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImpl implements IRollScoreBo {
	
	@Inject IRollScoreDa _rollScoreDa;
	@Inject IGameRulesEngine _gameRulesEngine;
	@Inject Roll _roll;

	public void createRollScore(RollScoreDm rollScoreDm) {
		rollScoreDm.roll = _roll.getRoll();
		_gameRulesEngine.setSkunkAndScore(rollScoreDm);
		_rollScoreDa.create(rollScoreDm);
	}
	
	public void updateRollScore(RollScoreDm rollScoreDm) {
		if (rollScoreDm.rollStatus == SkunkEnum.DoubleSkunk)
		{
			_rollScoreDa.resetPlayerScore(rollScoreDm.playerId);
		}
		else if (rollScoreDm.rollStatus == SkunkEnum.SingleSkunk ||
				rollScoreDm.rollStatus == SkunkEnum.DeuceSkunk)
		{
			_rollScoreDa.resetPlayerTurnScore(rollScoreDm.playerId, rollScoreDm.turnId);
		}
		else
		{
			RollScoreDm previousScore = _rollScoreDa.getLastTurnScore(rollScoreDm.playerId, rollScoreDm.turnId);
			rollScoreDm.turnTotal = previousScore.turnTotal + rollScoreDm.roll.diceTotal;
			rollScoreDm.roundTotal = previousScore.roundTotal + rollScoreDm.roll.diceTotal;
		}
	}

}
