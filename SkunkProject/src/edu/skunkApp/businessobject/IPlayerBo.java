package edu.skunkApp.businessobject;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.domainModels.PlayerDm;

public interface IPlayerBo {
	public boolean create(ArrayList<PlayerDm> players);
	public ArrayList<PlayerDm> getPlayers();
	public boolean canContinuePlay();
	
	public PlayerDm getWinner();
	public PlayerDm getPlayer(UUID playerId);
	public ArrayList<PlayerDm> getLosers();

}
