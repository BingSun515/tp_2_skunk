package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import edu.skunkApp.data.Player;
import edu.skunkApp.domainModels.PlayerDm;

public interface IPlayerDa {
	public void setChipCount(UUID playerId, int chipCount);
	public void create(Player player);
	public ArrayList<Player> getPlayers();
	public Optional<Player> getWinner();
	public void setWinner(UUID playerId);
	public ArrayList<PlayerDm> getLosers();
	public boolean hasWinner();
}
