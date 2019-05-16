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
		//TODO: check to see if it errors .. if there are no previous score
		RollScoreDm previousScore = _rollScoreDa.getPlayerTurnScore(rollScoreDm.playerId, rollScoreDm.turnId);

		this._gameRulesEngine.setSkunkAndScore(rollScoreDm, previousScore);
		this._rollScoreDa.create(rollScoreDm);
		this.resetPlayerScoresForSkunk(rollScoreDm);
	}
	
	public void resetPlayerScoresForSkunk(RollScoreDm previousScore)
	{
		if (previousScore.rollStatus != SkunkEnum.NOSKUNK)
		{
			this._gameRulesEngine.resetPlayerScoresForSkunk(previousScore);
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
	
	public void setScoreFromWinnerChoice(boolean winnerContinues) {
		if (winnerContinues) {
			
		} else {
			//Winner sets score as Goal
			int goal = this._gameRulesEngine.getGoalScore();
			this._playerDa.setWinnerScore(goal);
		}
	}
}
