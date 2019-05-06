package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import edu.skunkApp.data.Player;
import edu.skunkApp.domainModels.PlayerDm;

public interface IPlayerDa {
	public void setChipCount(UUID playerId, int chipCount);
	public void create(Player player);
	public ArrayList<Player> getPlayers();
	public Optional<Player> getWinner();
	public void setWinner(UUID playerId);
	public Stream<PlayerDm> getLosers();
}
