package edu.skunkApp.controller;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.businessobject.IRollBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.businessobject.IRoundBo;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollScoreDm;

public class GameController {

	@Inject IRollScoreBo _rollScoreBo;
	@Inject AppUIController _UIController;
	@Inject IPlayerBo _playerBo;
	@Inject IRollBo _roll;
	@Inject IRoundBo _roundBo;	

	@Inject RollScoreDm _rollScoreDm;
	void StartGame()
	{
		this.initializeNewGame();
//		this.displayGameSummary();
	}
	
	private void initializeNewGame()
	{
		this.initPlayers();
		this.startNextRound();
	}
	
	private void initPlayers()
	{		
		//UI will ask for how many players
		// ---+ validation
		//UI will prompt user for N number of players
		// UI will forward collected users to player bo to save in player data
		ArrayList<PlayerDm> players = AppUIController.getPlayers();
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
		{
			this.nextPlayer(playerId);
		}
		while(this._playerBo.canContinuePlay());
	}
	
	private boolean pl()
	{
		return false;
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
