package edu.skunkApp.businessobject.Implementation;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.businessobject.IGameRulesEngineBo;
import edu.skunkApp.businessobject.IRoundBo;
import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.dataAccess.IRoundDa;
import edu.skunkApp.domainModels.RoundDm;

public class RoundBoImpl implements IRoundBo {

	IRoundDa _roundDa = SkunkAppModule.provideRoundDa();
	IGameRulesEngineBo _gameRulesEngineBo = SkunkAppModule.provideGameRulesEngineBo();

	public UUID create() {
		return _roundDa.create();
	}

	public boolean canProceedToNextRound() {
		return (this._gameRulesEngineBo.getGameStatus() != GameStatusEnum.GAME_COMPLETED);
	}

	public ArrayList<RoundDm> getRounds()
	{
		return _roundDa.getRounds();
	}
}
