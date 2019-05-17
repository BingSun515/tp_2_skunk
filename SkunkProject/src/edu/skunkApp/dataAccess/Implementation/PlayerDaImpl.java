package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import java.util.List;
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
			this._players.addAll(players);
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
		List<Player> winner = this._players.stream()
										.filter(player -> player.isWinner == true)
										.collect(Collectors.toList());
		if (winner != null && winner.isEmpty())
		{
			return new PlayerDm();
		}
		return PlayerMapper.toPlayerDm(winner.get(0));
	}
	
	public void setWinner(UUID playerId) {
		this._players.stream().filter(player -> player.playerId == playerId)
				.map(player -> player.isWinner = true);
	}
	
	public ArrayList<PlayerDm> getLosers() {
		if (!this.hasWinner())
		{
			return new ArrayList<PlayerDm>();
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
	
	public void setWinnerScore(int goalScore)
	{
		PlayerDm winner = this.getWinner();
		winner.Score = goalScore;
	}
}
