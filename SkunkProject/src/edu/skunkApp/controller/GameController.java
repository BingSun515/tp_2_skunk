package edu.skunkApp.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.domainModels.PlayerDm;

public class GameController {

	@Inject private IRollScoreBo _rollScoreBo;
	@Inject private AppUIController _UIController;
		
	void StartGame()
	{
		this.initializeNewGame();
		this.displayGameSummary();
	}
	
	private void initializeNewGame()
	{
		ArrayList<PlayerDm> players = AppUIController.getPlayers();
		
	}
	
	private void initPlayers()
	{
		
	}

	private void displayGameSummary()
	{
		
	}
}
