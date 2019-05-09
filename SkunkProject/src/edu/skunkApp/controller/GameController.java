package edu.skunkApp.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.domainModels.PlayerDm;

public class GameController {

	@Inject private IRollScoreBo _rollScoreBo;
	@Inject private AppUIController _UIController;
	@Inject private IPlayerBo _playerBo;
		
	void StartGame()
	{
		this.initializeNewGame();
		this.displayGameSummary();
	}
	
	private void initializeNewGame()
	{
		this.initPlayers();
//		this.startRound();
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

	private void displayGameSummary()
	{
		
	}
}
