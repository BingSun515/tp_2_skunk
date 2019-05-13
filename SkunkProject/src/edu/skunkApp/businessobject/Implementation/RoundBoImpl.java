package edu.skunkApp.businessobject.Implementation;

import java.util.UUID;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IGameRulesEngineBo;
import edu.skunkApp.businessobject.IRoundBo;
import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.dataAccess.IRoundDa;
import edu.skunkApp.dataAccess.Implementation.RoundDaImpl;
import edu.skunkApp.domainModels.RoundDm;
import edu.skunkApp.modelMapper.RoundMapper;

public class RoundBoImpl implements IRoundBo
{
	@Inject IRoundDa _roundDa;
	@Inject IGameRulesEngineBo _gameRulesEngineBo;

	public UUID create()
	{
		int roundCount = this._roundDa.getRounds().size() + 1;
		RoundDm roundDm = new RoundDm();
		roundDm.description = "Round - " + roundCount;
		return _roundDa.create(RoundMapper.MAPPER.toRound(roundDm));
	}

	public boolean canProceedToNext()
	{
		return (_gameRulesEngineBo.getGameStatus() != GameStatusEnum.GAME_COMPLETED);
	}
}
