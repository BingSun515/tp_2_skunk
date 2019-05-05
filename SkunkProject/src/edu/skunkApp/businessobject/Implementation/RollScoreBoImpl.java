package edu.skunkApp.businessobject.Implementation;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IGameRulesEngine;
import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImpl implements IRollScoreBo {
	
	@Inject IRollScoreDa _rollScoreDa;
	@Inject IGameRulesEngine _gameRulesEngine;
	@Inject Roll _roll;

//	@Inject
//	public RollScoreBoImpl(IRollScoreDa rollScoreDa)
//	{
////		_rollScoreDa = rollScoreDa;
//	}

	@Inject 
	public void createRollScore(RollScoreDm rollScoreDm) {
		rollScoreDm.roll = _roll.getRoll();
		_gameRulesEngine.validateScore(rollScoreDm);
		_rollScoreDa.create(rollScoreDm);
	}

}
