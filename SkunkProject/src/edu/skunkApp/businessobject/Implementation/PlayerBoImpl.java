package edu.skunkApp.businessobject.Implementation;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

import edu.skunkApp.businessobject.IGameRulesEngineBo;
import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.common.mapper.PlayerMapper;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.domainModels.PlayerDm;

public class PlayerBoImpl implements IPlayerBo {
	
	private IPlayerDa _playerDa = SkunkAppModule.providePlayerDa();
	IGameRulesEngineBo _gameRulesEngineBoImpl = SkunkAppModule.provideGameRulesEngineBo();
	
	public boolean create(ArrayList<PlayerDm> players)
	{
		return this._playerDa.create(PlayerMapper.toPlayerList(players));
	}
	
	public ArrayList<PlayerDm> getPlayers()
	{
		return _playerDa.getPlayers();
	}
	
	public boolean canContinuePlay()
	{
		return this._gameRulesEngineBoImpl.canContinueRoll();
	}
	
	public PlayerDm getWinner() {
		return this._playerDa.getWinner();
	}
		
	public ArrayList<PlayerDm> getLosers() {
		return this._playerDa.getLosers();
	}

	public PlayerDm getPlayer(UUID playerId)
	{
		return this.getPlayers().stream()
				.filter(player -> player.playerId == playerId)
				.collect(Collectors.toList())
				.get(0);
	}
}
