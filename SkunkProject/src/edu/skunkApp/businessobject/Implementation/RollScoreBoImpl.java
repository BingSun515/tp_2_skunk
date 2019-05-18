package edu.skunkApp.businessobject.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import edu.skunkApp.businessobject.IGameRulesEngineBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.dataAccess.IKittyDa;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImpl implements IRollScoreBo
{
	private final IRollScoreDa _rollScoreDa = SkunkAppModule.provideRollScoreDa();
	private final IPlayerDa _playerDa = SkunkAppModule.providePlayerDa();
	private final IKittyDa _kittyDa = SkunkAppModule.provideKittyDa();
	private final IGameRulesEngineBo _gameRulesEngine = SkunkAppModule.provideGameRulesEngineBo();

	public void create(RollScoreDm rollScoreDm)
	{
		RollScoreDm previousScore = _rollScoreDa.getPlayerLastTurnScore(rollScoreDm.playerId, rollScoreDm.turnId);

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
	}
	
	public void createRollScoreForWinner(UUID playerId, ArrayList<PlayerDm> losers)
	{
		RollScoreDm rollScoreDm = new RollScoreDm();
		rollScoreDm.playerId = playerId;
		this._gameRulesEngine.moveChipsFromLosers(rollScoreDm, losers);
		this.moveKittyChangeToWinner(rollScoreDm);
		rollScoreDm.gameStatus = GameStatusEnum.GAME_COMPLETED;
		this._rollScoreDa.create(rollScoreDm);
	}
	
	public void moveKittyChangeToWinner(RollScoreDm rollScoreDm)
	{
		rollScoreDm.kittyChange = this._kittyDa.getChipCount();
		this._kittyDa.setChipCount(0);		
	}

	public RollScoreDm getLastRollScore()
	{
		return this._rollScoreDa.getLastRollScore();
	}
	
	public void setScoreFromWinnerChoice(boolean winnerContinues, RollScoreDm lastRollScoreDm) {
		if (winnerContinues) {
			lastRollScoreDm.gameStatus = GameStatusEnum.WINNER_CONTINUE_ROLL;			
		}
		else
		{
			lastRollScoreDm.gameStatus = GameStatusEnum.WINNER;
			int goal = this._gameRulesEngine.getGoalScore();
			this._playerDa.setWinnerScore(goal);
		}
		this._rollScoreDa.setPlayerLastTurnGameStatus(lastRollScoreDm);
	}

	public ArrayList<PlayerDm> getScores(UUID playerId, UUID roundId, UUID turnId) {
		return this._gameRulesEngine.getScores(playerId, roundId, turnId);
	}
}
