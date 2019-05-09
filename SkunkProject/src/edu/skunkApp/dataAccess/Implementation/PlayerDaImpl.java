package edu.skunkApp.dataAccess.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

import edu.skunkApp.data.Player;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.modelMapper.PlayerMapper;
import edu.skunkApp.dataAccess.IPlayerDa;

@Singleton
public class PlayerDaImpl implements IPlayerDa {

	@Inject ArrayList<Player> _players;	

	public void setChipCount(UUID playerId, int chipCount) {
		this._players.stream()
					.filter(player -> player.playerId == playerId)
					.map(player -> player.chipCount += chipCount);
	}

	public boolean create(ArrayList<Player> players) {
		boolean success = false;
		try {
			this._players = players;
			success = true;
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
			return success;
		}
		return success;
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
	
	public ArrayList<PlayerDm> getLosers() {
		if (!this.hasWinner())
		{
			return null;
		}
		
		List<Player> losers = this._players.stream()
								.filter(player -> player.isWinner != true)
								.collect(Collectors.toList());
	
		return PlayerMapper.MAPPER.toPlayerDmList(new ArrayList<Player>(losers));
	}
	
	public boolean hasWinner() {
		
		return this._players.stream()
					.filter(player -> player.isWinner == true)
					.count() == 1 ;
	}
	
}
