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
			this.displayRoundSummary();
		} while (this._roundBo.canProceedToNextRound());
	}

	private void startNextRound() {
		UUID roundId = _roundBo.create();
		//Winner is set from his rollChoices and after earning a score of 100
		ArrayList<PlayerDm> losers = this.getLosers();
		
		if (losers.isEmpty()) {
			this.playersPlay(roundId);
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
			this.playerPlayTillDone(roundId, player.playerId);
		}		
	}
	
	private ArrayList<PlayerDm> getLosers() {
		return this._playerBo.getLosers();
	}
	
	//TODO
	private void losersPlay(UUID roundId, ArrayList<PlayerDm> losers)
	{
//		loser play once and provide roll summary

		for (PlayerDm player : losers) {
			this.playerRollsDice(roundId, player.playerId);
			this.displaySummary();
		}
	}

	private void playerPlayTillDone(UUID roundId, UUID playerId) {
		do {
			this.playerRollsDice(roundId, playerId);
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

	private void playerRollsDice(UUID roundId, UUID playerId) {
		RollScoreDm rollScoreDm = new RollScoreDm();
		rollScoreDm.roundId = roundId;
		rollScoreDm.playerId = playerId;
		rollScoreDm.roll = _roll.getRoll();
		rollScoreDm.turnId = UUID.randomUUID();
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

		//todo start here
		//how to proceed after WINNER_CONTINUE_ROLL
		//how to proceed after LAST_CHANCE
		
//		if (winnerContinues) {
//		DONE: player will always be a winner until he scores skunk
//		} else {
//			int goal = this._rollScoreBo.g
//			BREAK OUT OF THE PLAYER LOOP ABOVE AND START A LOSERS LOOP
		// LOSERS LOOP WILL HAVE NO CHOICES TO PICK. 
		// THEY CAN ONLY ROLL ONCE
		
//		DONE: player will always be a winner until he scores skunk
//		}
			// set game to continue
//		_rollScoreBo.playLastChance(score);
 // MOVE CHIPS
		// DISPLAY SUMMARY

		
	}

	//todo
	private void displayPlayerSummary() {

	}

	//todo
	private void displayGameSummary()
	{
		
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
	//TODO
	public void displayRoundSummary()
	{
	//TODO
		System.out.println("TODO: displayRoundSummary");
	}
	//TODO
	public void displayMyScore()
	{
		System.out.println("TODO: displayMyScore");	
	}
	
	//TODO: display last chance and goal set by winner
}
