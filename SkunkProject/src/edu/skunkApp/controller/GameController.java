package edu.skunkApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.text.TextStringBuilder;

import edu.skunkApp.GameUI;
import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.businessobject.IRollBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.businessobject.IRoundBo;
import edu.skunkApp.common.Constants;
import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.common.PlayerInputEnum;
import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollScoreDm;
import edu.skunkApp.domainModels.RoundDm;

public class GameController {

	IRollScoreBo _rollScoreBo = SkunkAppModule.provideRollScoreBo();
	IPlayerBo _playerBo = SkunkAppModule.providePlayerBo();
	IRollBo _roll = SkunkAppModule.provideRollBo();
	IRoundBo _roundBo = SkunkAppModule.provideRoundBo();

	public void StartGame() {
		this.initializeNewGame();
		this.displayGameSummary();
	}

	public void initializeNewGame() {
		AppUIController.displayWelcome();
		this.createPlayers();
		this.startRound();
	}

	public void createPlayers() {
		ArrayList<PlayerDm> players = PlayerController.getNewPlayers();

		boolean result = this._playerBo.create(players);

		if (result == false) {
			throw new Error("Error creating players");
		}
	}

	public void startRound() {
		do {
			this.startNextRound();
		} while (this._roundBo.canProceedToNextRound());//TODO check this condition in related after losers play
	}

	public void startNextRound() {
		UUID roundId = _roundBo.create();
		//Winner is set from his rollChoices and 
		//		after earning a winning score
		ArrayList<PlayerDm> losers = this.getLosers();
		
		if (losers.isEmpty()) {
			this.playersPlay(roundId);
			this.getRoundSummary();
		} else {
			this.losersPlay(roundId, losers);
		}
	}
	
	public void playersPlay(UUID roundId)
	{
		ArrayList<PlayerDm> players = this.getPlayers();

		for (PlayerDm player : players) {
			
			if (!this.getLosers().isEmpty())
			{
				break;
			}
			PlayerController.displayCurrentPlayer(player.name);
			this.playerPlayTillDone(roundId, UUID.randomUUID(), player.playerId);
		}		
	}
	
	public ArrayList<PlayerDm> getLosers() {
		return this._playerBo.getLosers();
	}
	
	public void losersPlay(UUID roundId, ArrayList<PlayerDm> losers)
	{
		for (PlayerDm player : losers) {
			this.playerRollsDice(roundId, UUID.randomUUID(), player.playerId, GameStatusEnum.LAST_CHANCE);
			RollScoreDm lastRollScore = this._rollScoreBo.getLastRollScore();
			this.displaySummary(lastRollScore);
		}
	}

	public void playerPlayTillDone(UUID roundId, UUID turnId, UUID playerId) {
		do {
			this.playerRollsDice(roundId, turnId, playerId, null);
			RollScoreDm lastRollScore = this._rollScoreBo.getLastRollScore();
			this.displaySummary(lastRollScore);
			
			if (lastRollScore.rollStatus !=  SkunkEnum.NOSKUNK)
			{
				break;
			}
			
		} while (this.getPlayerChoice());
	}

	public PlayerInputEnum getPlayerInputChoice(String choice) {
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

	public void playerRollsDice(UUID roundId, UUID turnId, UUID playerId, GameStatusEnum gameStatus) {
		RollScoreDm rollScoreDm = new RollScoreDm();
		rollScoreDm.roundId = roundId;
		rollScoreDm.playerId = playerId;
		rollScoreDm.roll = _roll.getRoll();
		rollScoreDm.turnId = turnId;
		rollScoreDm.rollId = UUID.randomUUID();
		rollScoreDm.gameStatus = gameStatus;
		_rollScoreBo.create(rollScoreDm);
	}

	public void displaySummary(RollScoreDm lastRollScore) {	

		if (lastRollScore.gameStatus == GameStatusEnum.WINNER) {
			this.displaySummaryForWinner(lastRollScore);
		} else if (lastRollScore.rollStatus == SkunkEnum.NOSKUNK){
			this.displayRollScoreSummary(lastRollScore);
		} else {
			this.displaySkunkSummary(lastRollScore);
		}
	}

	public void displayRollScoreSummary(RollScoreDm lastRollScore) {
		PlayerController.displayRollScoreSummary(lastRollScore);
	}
	
	public void displaySkunkSummary(RollScoreDm lastRollScore) {
		PlayerController.displaySkunkSummary(lastRollScore);
	}

	//todo rename this method. single resp
	public void displaySummaryForWinner(RollScoreDm lastRollScore) {
		
		String winnerName = this._playerBo.getWinner().name;
		PlayerController.displayWinnerAndChoices(winnerName);
		boolean winnerContinues = this.getPlayerInputFromChoices() == PlayerInputEnum.Y;
		this._rollScoreBo.setScoreFromWinnerChoice(winnerContinues, lastRollScore);	
	}

	public void displayGameSummary()
	{
		ArrayList<PlayerDm> players = this._playerBo.getPlayers();
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

	public boolean getPlayerChoice() {
		PlayerInputEnum playerChoice = PlayerInputEnum.N;
		if (this._playerBo.canContinuePlay()) {
			playerChoice = this.getPlayerInputFromChoices();
		}
		return playerChoice == PlayerInputEnum.Y;
	}
	
	public PlayerInputEnum getPlayerInputFromChoices() {
		PlayerInputEnum playerChoice = PlayerInputEnum.N;
		do {
			playerChoice = this.getPlayerInputChoice(GameUI.getPlayerInput(Constants.PLAYER_ROLL_CHOICES));
			
			switch(playerChoice)
			{
				case HELP:
					AppUIController.displayHelp();
					break;
				case R:
					this.getRoundSummary();
					break;
				case M:
					this.displayMyScore(null);
					break;
			default:
				break;
			}

		} while (playerChoice == PlayerInputEnum.HELP ||
				 playerChoice == PlayerInputEnum.R ||
				 playerChoice == PlayerInputEnum.M);
		
		return playerChoice;
	}

	public void getRoundSummary()
	{
		RollScoreDm lastRollScore = this._rollScoreBo.getLastRollScore();	
		UUID roundId = lastRollScore.roundId;

		String roundName = this.getRoundDescription(lastRollScore.roundId);
		PlayerController.displayRoundSummary(roundName);		
		this._rollScoreBo.getScores(null, roundId, null)
					.forEach(score -> this.displayRollScoreSummary(score));
	}
	
	public void displayRoundSummary(RollScoreDm lastRollScore)
	{
		String playerName = this.getPlayerName(lastRollScore.playerId);
		PlayerController.displayPlayerName(playerName);
		this.displayRollScoreSummary(lastRollScore);
		
	}
	
	public String getRoundDescription(UUID roundId)
	{
		List<RoundDm> rounds = this.getRounds().stream()
				.filter(round -> round.id == roundId)
				.collect(Collectors.toList());
		return rounds.get(0).description;
	}
	
	public List<RoundDm> getRounds()
	{
		return _roundBo.getRounds();		
	}
	
	public ArrayList<PlayerDm> getPlayers()
	{
		return _playerBo.getPlayers();		
	}
	
	public String getPlayerName(UUID playerId)
	{
		List<PlayerDm> players = this.getPlayers().stream()
										.filter(player -> player.playerId == playerId)
										.collect(Collectors.toList());
		return players.get(0).name;
	}

	public void displayMyScore(UUID scorePlayerId)
	{
		UUID playerId = scorePlayerId;
		if (scorePlayerId == null)
		{
			RollScoreDm lastRollScore = this._rollScoreBo.getLastRollScore();
			playerId = lastRollScore.playerId;
		}
		this._rollScoreBo.getScores(playerId, null, null)
			.forEach(score -> this.displayRollScoreSummary(score));
	}
}
