package edu.skunkApp.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.text.TextStringBuilder;

import edu.skunkApp.GameUI;
import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.businessobject.IRollBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.businessobject.IRoundBo;
import edu.skunkApp.common.Constants;
import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.common.PlayerInputEnum;
import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollScoreDm;

public class GameController {

	IRollScoreBo _rollScoreBo = SkunkAppModule.provideRollScoreBo();
	IPlayerBo _playerBo = SkunkAppModule.providePlayerBo();
	IRollBo _roll = SkunkAppModule.provideRollBo();
	IRoundBo _roundBo = SkunkAppModule.provideRoundBo();

	public void StartGame() {
		this.initializeNewGame();
		this.displayGameSummary();
	}

	private void initializeNewGame() {
		AppUIController.displayWelcome();
		this.createPlayers();
		this.startRound();
	}

	private void createPlayers() {
		ArrayList<PlayerDm> players = PlayerController.getNewPlayers();

		boolean result = this._playerBo.create(players);

		if (result == false) {
			throw new Error("Error creating players");
		}
	}

	private void startRound() {
		do {
			this.startNextRound();
		} while (this._roundBo.canProceedToNextRound());//TODO check this condition in related after losers play
	}

	private void startNextRound() {
		UUID roundId = _roundBo.create();
		//Winner is set from his rollChoices and 
		//		after earning a winning score
		ArrayList<PlayerDm> losers = this.getLosers();
		
		if (losers.isEmpty()) {
			this.playersPlay(roundId);
			this.displayRoundSummary(roundId);
		} else {
			this.losersPlay(roundId, losers);
		}
	}
	
	private void playersPlay(UUID roundId)
	{
		ArrayList<PlayerDm> players = _playerBo.get();

		for (PlayerDm player : players) {
			
			if (!this.getLosers().isEmpty())
			{
				break;
			}
			this.playerPlayTillDone(roundId, UUID.randomUUID(), player.playerId);
		}		
	}
	
	private ArrayList<PlayerDm> getLosers() {
		return this._playerBo.getLosers();
	}
	
	private void losersPlay(UUID roundId, ArrayList<PlayerDm> losers)
	{
		for (PlayerDm player : losers) {
			this.playerRollsDice(roundId, UUID.randomUUID(), player.playerId, GameStatusEnum.LAST_CHANCE);
			this.displaySummary();
		}
	}

	private void playerPlayTillDone(UUID roundId, UUID turnId, UUID playerId) {
		do {
			this.playerRollsDice(roundId, turnId, playerId, null);
			this.displaySummary();
		} while (this.getPlayerChoice());
	}

	private PlayerInputEnum getPlayerInputChoice(String choice) {
		if (!choice.isBlank()) {
			try {
				return PlayerInputEnum.valueOf(choice.toUpperCase());
			} catch (Exception e) {
				// if player entered a choice other than y / n / help, return N
				return PlayerInputEnum.N;
			}
		}
		return PlayerInputEnum.N;
	}

	private void playerRollsDice(UUID roundId, UUID turnId, UUID playerId, GameStatusEnum gameStatus) {
		RollScoreDm rollScoreDm = new RollScoreDm();
		rollScoreDm.roundId = roundId;
		rollScoreDm.playerId = playerId;
		rollScoreDm.roll = _roll.getRoll();
		rollScoreDm.turnId = turnId;
		rollScoreDm.rollId = UUID.randomUUID();
		rollScoreDm.gameStatus = gameStatus;
		_rollScoreBo.create(rollScoreDm);
	}

	private void displaySummary() {
		RollScoreDm lastRollScore = this._rollScoreBo.getLastRollScore();

		if (lastRollScore.gameStatus == GameStatusEnum.WINNER) {
			this.displaySummaryForWinner(lastRollScore);
		} else {
			this.displayRollScoreSummary(lastRollScore);
		}
	}

	private void displayRollScoreSummary(RollScoreDm lastRollScore) {
		PlayerController.displayRollScoreSummary(lastRollScore);
	}

	//todo rename this method. single resp
	private void displaySummaryForWinner(RollScoreDm lastRollScore) {
		
		String winnerName = this._playerBo.getWinner().name;
		PlayerController.displayWinnerAndChoices(winnerName);
		boolean winnerContinues = this.getPlayerInputFromChoices() == PlayerInputEnum.Y;
		this._rollScoreBo.setScoreFromWinnerChoice(winnerContinues, lastRollScore);	
	}

	private void displayGameSummary()
	{
		ArrayList<PlayerDm> players = this._playerBo.get();
		//display non winners
		players.forEach(player -> {
			if (!player.isWinner)
			{
				this.displayMyScore(player.playerId);
			}
		});
		
		//display winner
		players.forEach(player -> {
			if (player.isWinner)
			{
				this.displayMyScore(player.playerId);
			}
		});
		
	}

	private boolean getPlayerChoice() {
		PlayerInputEnum playerChoice = PlayerInputEnum.N;
		if (this._playerBo.canContinuePlay()) {
			playerChoice = this.getPlayerInputFromChoices();
		}
		return playerChoice == PlayerInputEnum.Y;
	}
	
	private PlayerInputEnum getPlayerInputFromChoices() {
		PlayerInputEnum playerChoice = PlayerInputEnum.N;
		do {
			playerChoice = this.getPlayerInputChoice(GameUI.getPlayerInput(Constants.PLAYER_ROLL_CHOICES));
			
			switch(playerChoice)
			{
				case HELP:
					AppUIController.displayHelp();
					break;
				case R:
					this.displayRoundSummary();
					break;
				case M:
					this.displayMyScore();
					break;
				default:
					playerChoice = PlayerInputEnum.N;
					break;
			}

		} while (playerChoice == PlayerInputEnum.HELP ||
				 playerChoice == PlayerInputEnum.R ||
				 playerChoice == PlayerInputEnum.M);
		
		return playerChoice;
	}

	public void displayRoundSummary(UUID roundId)
	{
		this._rollScoreBo.getScores(null, roundId, null)
					.forEach(score -> this.displayRollScoreSummary(score));
	}

	public void displayMyScore(UUID playerId)
	{
		this._rollScoreBo.getScores(playerId, null, null)
			.forEach(score -> this.displayRollScoreSummary(score));
	}
}
