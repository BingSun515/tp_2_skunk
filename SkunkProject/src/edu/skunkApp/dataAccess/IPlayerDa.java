package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import edu.skunkApp.data.Player;

public interface IPlayerDa {
	public void setChipCount(UUID playerId, int chipCount);
	public void create(Player player);
	public ArrayList<Player> getPlayers();
	public Optional<Player> getWinner();
	public void setWinner(UUID playerId);
	public List<Player> getLosers();
}
