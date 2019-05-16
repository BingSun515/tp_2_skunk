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
		} while (this._roundBo.canProceedToNext());
	}

	private void startRound() {
		UUID roundId = _roundBo.create();
		if (roundId != null) {
			ArrayList<PlayerDm> players = _playerBo.get();
			players.forEach(player -> this.playerPlayTillDone(player.playerId));
		} else {
			throw new Error("Error creating round");
		}
	}

	private void playerPlayTillDone(UUID playerId) {
		do {
			this.nextPlayerPlays(playerId);
		} while (this.getPlayerChoice());
	}

	private boolean getPlayerChoice() {
		PlayerInputEnum playerChoice = PlayerInputEnum.CANNOT_PLAY;
		if (this._playerBo.canContinuePlay()) {
			do {
				playerChoice = this.getPlayerInputChoice(GameUI.getPlayerInput(Constants.PLAYER_ROLL_CHOICES));
				if (playerChoice == PlayerInputEnum.HELP) {
					this.displayHelp();
				}
			} while (playerChoice == PlayerInputEnum.HELP);
		}
		return playerChoice == PlayerInputEnum.Y;
	}

	//TODO:
	private void displayHelp()
	{
//		 Constants.GAME_RULE;//TODO: this is incomplete.
		//public static final String GAME_RULE = GAME_RULE1 + GAME_RULE2+ GAME_RULE3+ GAME_RULE4+ GAME_RULE5+ GAME_RULE6+ GAME_RULE7+ GAME_RULE8 ;
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

		this.displayRollScoreSummary();
		rollScoreDm = null;
	}

	private void displayRollScoreSummary() {
		RollScoreDm score = this._rollScoreBo.getLastRollScore();
		TextStringBuilder tb = new TextStringBuilder().appendln(Constants.LINE)
				.appendln(String.format(Constants.LAST_ROLL, score.roll.die1, score.roll.die2, score.roll.diceTotal))
				.appendln(Constants.LINE);

	}

	private void displayPlayerSummary() {

	}

	//
//	private void displayGameSummary()
//	{
//		
//	}
}
