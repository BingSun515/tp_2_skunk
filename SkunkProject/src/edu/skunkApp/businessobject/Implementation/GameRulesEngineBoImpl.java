package edu.skunkApp.businessobject.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import edu.skunkApp.businessobject.IGameRulesEngineBo;
import edu.skunkApp.common.Constants;
import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.dataAccess.IKittyDa;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;

/**
 * TODO: https://stthomas.instructure.com/courses/23037/assignments/216762 Game
 * rules live here Any number can play. [Assume at least two players!] The
 * suggested number of chips to start is 50. There are sufficient chips in the
 * box to allow 8 players to start with 50 chips by placing a par value of "one"
 * on white chips, 5 for 1 on red chips and 10 for 1 on the blue chips.
 * 
 * The first player to accumulate a total of 100 or more points can continue to
 * score as many points over 100 as he believes is needed to win.
 * 
 * When he decides to stop, his total score is the ¡°goal.¡±

 * DONE: moveChips The winner of each game collects all chips in "kitty" and in
 * addition five chips from each losing player or 10 chips from any player
 * without a score.
 **/
public class GameRulesEngineBoImpl implements IGameRulesEngineBo {
	private final IRollScoreDa _rollScoreDa = SkunkAppModule.provideRollScoreDa();
	private final IPlayerDa _playerDa = SkunkAppModule.providePlayerDa();
	private final IKittyDa _kittyDa = SkunkAppModule.provideKittyDa();

	//TODO: do player score calculation
	public boolean getGameStatus(int roundTotal) {
		return roundTotal >= Constants.WINNING_SCORE;
	}

	public void moveChipsFromLosers(RollScoreDm rollScoreDm, ArrayList<PlayerDm> losers) {
		for (PlayerDm loser : losers) {
			if (loser.Score == 0) {
				loser.chipCount -= 10;
				rollScoreDm.chipChange += 10;
			} else {
				loser.chipCount -= 5;
				rollScoreDm.chipChange += 5;
			}
			//For Losers
			this._playerDa.setChipCount(loser.playerId, loser.chipCount);
		}
		//For Winners
		this._playerDa.setChipCount(rollScoreDm.playerId, rollScoreDm.chipChange);
	}

	// START: SKUNK
	public void setSkunkAndScore(RollScoreDm rollScoreDm, RollScoreDm previousScoreDm) {
		rollScoreDm.roll.diceTotal = rollScoreDm.roll.die1 + rollScoreDm.roll.die2;
		if (this.isRollSingleSkunk(rollScoreDm.roll)) {
			rollScoreDm.rollStatus = SkunkEnum.SINGLESKUNK;
			rollScoreDm.gameStatus = GameStatusEnum.TURN_COMPLETED;
			rollScoreDm.chipChange = -1;
			rollScoreDm.kittyChange = 1;
			rollScoreDm.turnTotal = 0;
		} else if (this.isRollDoubleSkunk(rollScoreDm.roll)) {
			rollScoreDm.rollStatus = SkunkEnum.DOUBLESKUNK;
			rollScoreDm.gameStatus = GameStatusEnum.ROUND_COMPLETED;
			rollScoreDm.chipChange = -4;
			rollScoreDm.kittyChange = 4;
			rollScoreDm.turnTotal = 0;
		} else if (this.isRollDeuceSkunk(rollScoreDm.roll)) {
			rollScoreDm.rollStatus = SkunkEnum.DEUCESKUNK;
			rollScoreDm.gameStatus = GameStatusEnum.TURN_COMPLETED;
			rollScoreDm.chipChange = -2;
			rollScoreDm.kittyChange = 2;
			rollScoreDm.turnTotal = 0;
		} else {
			rollScoreDm.rollStatus = SkunkEnum.NOSKUNK;
			this.setGameStatus(rollScoreDm);
		}
	}

	public boolean isRollSingleSkunk(RollDm roll) {
		return ((roll.die1 == 1 && roll.die2 > 2) || (roll.die2 == 1 && roll.die1 > 2));
	}

	public boolean isRollDoubleSkunk(RollDm roll) {
		return (roll.die1 == 1 && roll.die2 == 1);
	}

	public boolean isRollDeuceSkunk(RollDm roll) {
		return (roll.die1 == 1) && (roll.die2 == 2) || (roll.die2 == 1) && (roll.die1 == 2);
	}

	public void setGameStatus(RollScoreDm rollScoreDm) {

		PlayerDm winner = this._playerDa.getWinner();
		boolean hasWinner = winner != null;

		// No winner and New winner
		if (!hasWinner && this.getGameStatus(rollScoreDm.roll.diceTotal)) {
			rollScoreDm.gameStatus = GameStatusEnum.WINNER;
		}
		// There is a winner and winner is currently playing turn to increase score
		else if (hasWinner)
		{
			rollScoreDm.gameStatus = GameStatusEnum.WINNER_CONTINUE_ROLL;
		} 
		else // No winner yet, player continue to roll
		{
			rollScoreDm.gameStatus = GameStatusEnum.CONTINUE_ROLL;
		}
	}

	public GameStatusEnum getGameStatus() {
		RollScoreDm lastTurnScore = _rollScoreDa.getLastRollScore();
		if (lastTurnScore == null) {
			return GameStatusEnum.CONTINUE_ROLL;
		}
		return lastTurnScore.gameStatus;
	}

	public void resetPlayerScoresForSkunk(RollScoreDm rollScoreDm) {
		if (rollScoreDm.rollStatus == SkunkEnum.DOUBLESKUNK) {
			_rollScoreDa.resetPlayerScore(rollScoreDm.playerId);
		} else if (rollScoreDm.rollStatus == SkunkEnum.SINGLESKUNK || rollScoreDm.rollStatus == SkunkEnum.DEUCESKUNK) {
			_rollScoreDa.resetPlayerTurnScore(rollScoreDm.playerId, rollScoreDm.turnId);
		}
		this._kittyDa.setChipCount(rollScoreDm.kittyChange);
		this._playerDa.setChipCount(rollScoreDm.playerId, rollScoreDm.chipChange);
	}

	public boolean canContinueRoll() {
		RollScoreDm lastRollScore = _rollScoreDa.getLastRollScore();
		if (lastRollScore == null) {
			return true;
		}
		boolean noSkunk = lastRollScore.rollStatus == SkunkEnum.NOSKUNK;
		boolean lostStatus = lastRollScore.gameStatus == GameStatusEnum.LAST_CHANCE ||
				lastRollScore.gameStatus == GameStatusEnum.TURN_COMPLETED;

		return noSkunk || lostStatus;
	}

	public ArrayList<PlayerDm> getScores(UUID playerId, UUID roundId, UUID turnId) {

		
		ArrayList<RollScoreDm> scoreSummary = this._rollScoreDa.getFilteredRollScore(playerId, turnId, roundId);
		
		List<UUID> playerIds = this._rollScoreDa.getFilteredRollScore(playerId, turnId, roundId)
													.stream()
													.map( p -> p.playerId)
													.distinct()
													.collect(Collectors.toList());

		List<PlayerDm> players = this._playerDa.getPlayers()
												.stream()
												.filter(player -> playerIds.contains(player.playerId))
												.collect(Collectors.toList());
		
		
		for(PlayerDm player : players)
		{
			player.Score =  scoreSummary.stream().filter(score -> score.playerId == player.playerId)
												.mapToInt(scoreRound -> scoreRound.roll.diceTotal)
												.sum();
		}
		return (ArrayList<PlayerDm>) players;
	}
	
	// Calculate Goal - Total of winning Score
	public int getGoalScore() {

		PlayerDm winner = this._playerDa.getWinner();
		return this.getScores(winner.playerId, null, null).get(0).Score;
	}
}
