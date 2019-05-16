package edu.skunkApp.businessobject.Implementation;

import edu.skunkApp.businessobject.IGameRulesEngineBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.dataAccess.IKittyDa;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImpl implements IRollScoreBo
{
	private final IRollScoreDa _rollScoreDa = SkunkAppModule.provideRollScoreDa();
	private final IPlayerDa _playerDa = SkunkAppModule.providePlayerDa();
	private final IKittyDa _kittyDa = SkunkAppModule.provideKittyDa();
	private final IGameRulesEngineBo _gameRulesEngine = SkunkAppModule.provideGameRulesEngineBo();

	public void create(RollScoreDm rollScoreDm)
	{
		RollScoreDm previousScore = _rollScoreDa.getPlayerTurnScore(rollScoreDm.playerId, rollScoreDm.turnId);
		boolean hasWinner = this._playerDa.hasWinner();
		this._gameRulesEngine.setSkunkAndScore(rollScoreDm, previousScore, hasWinner);
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
		
		//SET THIS STATUS ONLY WHEN THE WINNER DECIDES SETS HIS GOAL
//		rollScoreDm.gameStatus = GameStatusEnum.LAST_CHANCE;
		//TODO: //SET THIS STATUS ONLY WHEN THE WINNER DECIDES SETS HIS GOAL
		//
//		if (rollScoreDm.gameStatus == GameStatusEnum.WINNER)
//		{
//			ArrayList<PlayerDm> losers = this._playerDa.getLosers();
//			if (!losers.isEmpty())
//			{
//				this._gameRulesEngine.moveChips(rollScoreDm, losers);
//			}
//		}
	}
 
	public RollScoreDm getLastRollScore()
	{
		return this._rollScoreDa.getLastRollScore();
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
}
