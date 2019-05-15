package edu.skunkApp.controller;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.businessobject.IRollBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.businessobject.IRoundBo;
import edu.skunkApp.common.Constants;
import edu.skunkApp.common.IntegerUtil;
import edu.skunkApp.common.PlayerInputEnum;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollScoreDm;

public class GameController {

	@Inject IRollScoreBo _rollScoreBo;
//	@Inject AppUIController _appUIController;
	@Inject IPlayerBo _playerBo;
	@Inject IRollBo _roll;
	@Inject IRoundBo _roundBo;	
	@Inject RollScoreDm _rollScoreDm;

	private static final String newline ="\n";

	public void StartGame()
	{
		this.initializeNewGame();
//		this.displayGameSummary();
	}
	
	private void initializeNewGame()
	{
		AppUIController.displayWelcome();
		this.createPlayers();
//		this.startNextRound();
	}
		
	private void createPlayers()
	{
		ArrayList<PlayerDm> players = PlayerInitController.getNewPlayers();
		boolean result = _playerBo.create(players);
		
		if (result == false)
		{
			throw new Error("Error creating players");
		}
	}
	private void startNextRound()
	{
		if (this._roundBo.canProceedToNext())
		{
			this.startRound();
		}
	}

	private void startRound()
	{
		UUID roundId = _roundBo.create();
		if (roundId != null)
		{
			ArrayList<PlayerDm> players = _playerBo.get();
			players.forEach(player -> this.playerPlayTillDone(player.playerId));
		}
		else
		{
			throw new Error("Error creating round"); 
		}
	}
	
	private void playerPlayTillDone(UUID playerId)
	{
		do
		{
			this.nextPlayer(playerId);
		}
		while(this.getPlayerChoice());
	}
	
	//TODO:
	private boolean getPlayerChoice()
	{
		PlayerInputEnum playerChoice = PlayerInputEnum.CANNOT_PLAY;
		if (this._playerBo.canContinuePlay())
		{
			do
			{
				playerChoice = this.getPlayerInputChoice(""); //TODO: this is incomplete.
				if (playerChoice == PlayerInputEnum.HELP)
				{
					this.displayHelp();
				}
			}  while (playerChoice == PlayerInputEnum.HELP);	
		}
		return playerChoice == PlayerInputEnum.Y;
	}

	//TODO:
	private void displayHelp()
	{
		 //TODO: this is incomplete.
	}
	
	private PlayerInputEnum getPlayerInputChoice(String choice)
	{
		if (choice != null && !choice.trim().isEmpty()) {
			try {
				return PlayerInputEnum.valueOf(choice.toUpperCase());
			} catch (Exception e) {
				// if player entered a choice other than y / n / help, return N
				return PlayerInputEnum.N;
			}
		}
		return PlayerInputEnum.N;
	}

	private void displayUIHelp()
	{
		//TODO call UI Help
	}
	
	private void nextPlayer(UUID playerId)
	{
		//How many rounds player will play?
		_rollScoreDm.playerId = playerId;
		_rollScoreDm.roll = _roll.getRoll();
		_rollScoreBo.create(_rollScoreDm);
		//get user input if he wants to proceed?
//		this.displayRollSummary();
		_rollScoreDm = null;
	}
	
//	private void displayRollSummary()
//	{
//		
//	}
//
//	private void displayGameSummary()
//	{
//		
//	}
}
