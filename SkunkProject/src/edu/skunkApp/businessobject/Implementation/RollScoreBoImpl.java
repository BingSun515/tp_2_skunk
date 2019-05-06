package edu.skunkApp.businessobject.Implementation;

import java.util.ArrayList;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IGameRulesEngine;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.data.Player;
import edu.skunkApp.dataAccess.IKittyDa;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImpl implements IRollScoreBo
{
	
	@Inject IRollScoreDa _rollScoreDa;
	@Inject IPlayerDa _playerDa;
	@Inject IKittyDa _kittyDa;
	@Inject IGameRulesEngine _gameRulesEngine;
	@Inject Roll _roll;

	public void createRollScore(RollScoreDm rollScoreDm)
	{
		RollScoreDm previousScore = _rollScoreDa.getLastTurnScore(rollScoreDm.playerId, rollScoreDm.turnId);
		rollScoreDm.roll = _roll.getRoll();
		this._gameRulesEngine.setSkunkAndScore(rollScoreDm, previousScore);
		this._rollScoreDa.create(rollScoreDm);
		this.setSkunkScores(rollScoreDm);
	}
	
	public void setSkunkScores(RollScoreDm rollScoreDm)
	{
		if (rollScoreDm.rollStatus != SkunkEnum.NOSKUNK)
		{
			this.resetRollScoreForSkunk(rollScoreDm);
			this._kittyDa.setChipCount(rollScoreDm.chipChange);
			this._playerDa.setChipCount(rollScoreDm.playerId, rollScoreDm.chipChange);
		}
		if (rollScoreDm.gameStatus == GameStatusEnum.WINNER)
		{
			if (this._playerDa.getLosers().count() > 0)
			{
				this._gameRulesEngine.moveChips(rollScoreDm, this._playerDa.getLosers());
			}
		}
	}
 
	public void resetRollScoreForSkunk(RollScoreDm rollScoreDm)
	{
		if (rollScoreDm.rollStatus == SkunkEnum.DOUBLESKUNK)
		{
			_rollScoreDa.resetPlayerScore(rollScoreDm.playerId);
		}
		else if (rollScoreDm.rollStatus == SkunkEnum.SINGLESKUNK ||
				rollScoreDm.rollStatus == SkunkEnum.DEUCESKUNK)
		{
			_rollScoreDa.resetPlayerTurnScore(rollScoreDm.playerId, rollScoreDm.turnId);
		}
	}
//TODO: use moveChips for a winner
}
