package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

import edu.skunkApp.common.mapper.PlayerMapper;
import edu.skunkApp.data.Player;
import edu.skunkApp.data.Store;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.domainModels.PlayerDm;

public class PlayerDaImpl implements IPlayerDa
{

	ArrayList<Player> _players = Store.getPlayer();	

	public void setChipCount(UUID playerId, int chipCount)
	{
		this._players.stream()
					.filter(player -> player.playerId == playerId)
					.map(player -> player.chipCount += chipCount);
	}

	public boolean create(ArrayList<Player> players)
	{
		boolean success = false;
		try {
			this._players.addAll(_players);
			success = true;
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
			return success;
		}
		return success;
	}

	public ArrayList<PlayerDm> getPlayers()
	{
		return PlayerMapper.toPlayerDmList(this._players);
	}
	
	public PlayerDm getWinner() {
		Player winner = this._players.stream()
										.filter(player -> player.isWinner == true)
										.findFirst()
										.orElse(null);
		return winner != null ? PlayerMapper.toPlayerDm(winner) : null;
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
		
		ArrayList<Player> losers = (ArrayList<Player>) this._players.stream()
								.filter(player -> player.isWinner != true)
								.collect(Collectors.toList());
	
		return PlayerMapper.toPlayerDmList(losers);
	}
	
	public boolean hasWinner() {
		
		return this._players.stream()
					.filter(player -> player.isWinner == true)
					.count() == 1 ;
	}
	
}
