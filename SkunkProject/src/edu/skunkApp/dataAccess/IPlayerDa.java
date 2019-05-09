package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.data.Player;
import edu.skunkApp.domainModels.PlayerDm;

public interface IPlayerDa {
	public void setChipCount(UUID playerId, int chipCount);
	public boolean create(ArrayList<Player> players);
	public ArrayList<PlayerDm> getPlayers();
	public PlayerDm getWinner();
	public void setWinner(UUID playerId);
	public ArrayList<PlayerDm> getLosers();
	public boolean hasWinner();
}
