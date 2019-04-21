package edu.skunkApp.businessobject.Implementation;

import javax.inject.Inject;

import edu.skunkApp.businessobject.IRollScoreBo;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImpl implements IRollScoreBo {
	
	private final IRollScoreDa _rollScoreDa;
	
	@Inject
	public RollScoreBoImpl(IRollScoreDa rollScoreDa)
	{
		_rollScoreDa = rollScoreDa;
	}
	
	public void RollOnce()
	{
		
	}
	
	public void setRollScore(RollScoreDm rollScore) {
		
	}
	
	public void RollAndSetScore() {
//		_rollScoreDa.add(); TODO
	}

}
