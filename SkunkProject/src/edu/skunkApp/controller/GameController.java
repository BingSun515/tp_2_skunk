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

	private static final String newline = "\n";

	public void StartGame() {
		this.initializeNewGame();
//		this.displayGameSummary();
	}

	private void initializeNewGame() {
		AppUIController.displayWelcome();
		this.createPlayers();
		this.startNextRound();
	}

	private void createPlayers() {
		ArrayList<PlayerDm> players = PlayerController.getNewPlayers();

		boolean result = this._playerBo.create(players);

		if (result == false) {
			throw new Error("Error creating players");
		}
	}

	private void startNextRound() {
		do {
			this.startRound();
		} while (this._roundBo.canProceedToNextRound());
	}

	private void startRound() {
		UUID roundId = _roundBo.create();
		if (roundId != null) {
			ArrayList<PlayerDm> players = _playerBo.get();

			for (PlayerDm player : players) {
				this.playerPlayTillDone(player.playerId);
			}

		} else {
			throw new Error("Error creating round");
		}
	}

	private void playerPlayTillDone(UUID playerId) {
		do {
			this.nextPlayerPlays(playerId);
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

	private void nextPlayerPlays(UUID playerId) {
		RollScoreDm rollScoreDm = new RollScoreDm();
		rollScoreDm.playerId = playerId;
		rollScoreDm.roll = _roll.getRoll();
		_rollScoreBo.create(rollScoreDm);

		this.displaySummary();
		rollScoreDm = null;
	}

	private void displaySummary() {
		RollScoreDm score = this._rollScoreBo.getLastRollScore();

		if (score.gameStatus == GameStatusEnum.WINNER) {
			this.displaySummaryForWinner(score);
		} else {
			this.displayRollScoreSummary(score);
		}
	}

	private void displayRollScoreSummary(RollScoreDm score) {
		PlayerController.displayRollScoreSummary(score);
	}

	private void displaySummaryForWinner(RollScoreDm score) {
		
		// TODO
		String winnerName = this._playerBo.getWinner().name;
		PlayerController.displayWinnerAndChoices(winnerName);
		boolean winnerContinues = this.getPlayerInputFromChoices() == PlayerInputEnum.Y;

		_rollScoreBo.playLastChance(score);
		// set game to continue
		// set last turn score to no winner.
		// player will always be a winner until he scores skunk
		// skunkn should reset scores to zero
		
	}


	private void displayPlayerSummary() {

	}

	//
//	private void displayGameSummary()
//	{
//		
//	}	

	private boolean getPlayerChoice() {
		PlayerInputEnum playerChoice = PlayerInputEnum.CANNOT_PLAY;
		if (this._playerBo.canContinuePlay()) {
			playerChoice = this.getPlayerInputFromChoices();
			
		}
		return playerChoice == PlayerInputEnum.Y;
	}
	
	private PlayerInputEnum getPlayerInputFromChoices() {
		PlayerInputEnum playerChoice = PlayerInputEnum.CANNOT_PLAY;
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
				playerChoice = PlayerInputEnum.Y;
				break;
			}

		} while (playerChoice == PlayerInputEnum.HELP ||
				 playerChoice == PlayerInputEnum.R ||
				 playerChoice == PlayerInputEnum.M);
		
		return playerChoice;
	}

	public void displayRoundSummary()
	{
	//TODO
		System.out.println("TODO: displayRoundSummary");
	}
	
	public void displayMyScore()
	{
		System.out.println("TODO: displayMyScore");	
	}
}
