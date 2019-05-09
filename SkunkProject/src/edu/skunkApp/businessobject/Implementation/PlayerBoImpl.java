package edu.skunkApp.businessobject.Implementation;

import java.util.ArrayList;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IPlayerBo;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.modelMapper.PlayerMapper;

public class PlayerBoImpl implements IPlayerBo {
	
	@Inject IPlayerDa _playerDa;
	
	public boolean create(ArrayList<PlayerDm> players)
	{
		return _playerDa.create(PlayerMapper.MAPPER.toPlayerList(players));
	}
}
