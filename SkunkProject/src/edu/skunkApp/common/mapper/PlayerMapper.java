package edu.skunkApp.common.mapper;

import java.util.ArrayList;

import edu.skunkApp.data.Player;
import edu.skunkApp.domainModels.PlayerDm;
import java.util.UUID;

import edu.skunkApp.common.GameConstants;

public class PlayerMapper {
	public static PlayerDm toPlayerDm(Player player)
	{
		PlayerDm playerDm = new PlayerDm();
		playerDm.playerId = UUID.randomUUID();
		playerDm.name = player.name;
		playerDm.chipCount = GameConstants.PlayerChipCount;
		playerDm.isWinner = false;
		return playerDm;
	}

	public static Player toPlayer(PlayerDm playerDm)
	{
		Player player = new Player();
		player.playerId = playerDm.playerId;
		player.name = playerDm.name;
		player.chipCount = playerDm.chipCount;
		player.isWinner = playerDm.isWinner;
		return player;
	}

	public static ArrayList<PlayerDm> toPlayerDmList(ArrayList<Player> players)
	{
		ArrayList<PlayerDm> _players = new ArrayList<PlayerDm>();
		players.forEach(player -> _players.add(toPlayerDm(player)));
		return _players;
	}

	public static ArrayList<Player> toPlayerList(ArrayList<PlayerDm> players)
	{
		ArrayList<Player> _players = new ArrayList<Player>();
		players.forEach(player -> _players.add(toPlayer(player)));
		return _players;
	}
}
