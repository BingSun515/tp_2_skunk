package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import edu.skunkApp.data.Player;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.dataAccess.IPlayerDa;

@Singleton
public class PlayerDaImpl implements IPlayerDa {

	@Inject private ArrayList<Player> _players;	

	public void setChipCount(UUID playerId, int chipCount) {
		this._players.stream()
					.filter(player -> player.playerId == playerId)
					.map(player -> player.chipCount += chipCount);
	}

	public void create(Player player) {
		this._players.add(player);
	}

	public ArrayList<Player> getPlayers() {
		return this._players;
	}
	
	public Optional<Player> getWinner() {
		return this._players.stream()
				.filter(player -> player.isWinner == true)
				.findFirst();
	}
	
	public void setWinner(UUID playerId) {
		this._players.stream().filter(player -> player.playerId == playerId)
				.map(player -> player.isWinner = true);
	}
	
	public Stream<PlayerDm> getLosers() {
		return this._players.stream()
					.filter(player -> player.isWinner != true);

	}
	
}
