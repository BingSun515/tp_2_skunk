package edu.skunkApp.controller;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.businessobject.Implementation.RollBoImpl;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollScoreDm;

public class GameController {

	@Inject IRollScoreBo _rollScoreBo;
	@Inject AppUIController _UIController;
	@Inject IPlayerBo _playerBo;
	@Inject RollScoreDm _rollScoreDm;
	@Inject RollBoImpl _roll;
		
	void StartGame()
	{
		this.initializeNewGame();
		this.displayGameSummary();
	}
	
	private void initializeNewGame()
	{
		this.initPlayers();
		this.startRound();
	}
	
	private void initPlayers()
	{		
		//UI will ask for how many players
		// ---+ validation
		//UI will prompt user for N number of players
		// UI will forward collected users to player bo to save in player data
		ArrayList<PlayerDm> players = AppUIController.getPlayers();
		_playerBo.create(players);
	}
	
	private void startRound()
	{
		ArrayList<PlayerDm> players = _playerBo.get();
		players.forEach(player -> this.nextPlayer(player.playerId));
	}
	
	private void nextPlayer(UUID playerId)
	{
		_rollScoreDm.playerId = playerId;
		_rollScoreDm.roll = _roll.getRoll();
		_rollScoreBo.create(_rollScoreDm);
		_rollScoreDm = null;
	}

	private void displayGameSummary()
	{
		
	}
}
