package edu.skunkApp.businessobject.Implementation;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImpl implements IRollScoreBo {
	
	private final IRollScoreDa _rollScoreDa;
	@Inject Roll _roll;

	@Inject
	public RollScoreBoImpl(IRollScoreDa rollScoreDa)
	{
		_rollScoreDa = rollScoreDa;
	}

	@Inject 
	public void createRollScore(RollScoreDm rollScoreDm) {
		rollScoreDm.roll = _roll.getRoll();
		_rollScoreDa.createRollScore(rollScoreDm);
	}
	
	private void setGameScore() {
		
	}

}
