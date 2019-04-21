package edu.skunkApp.businessobject;

import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreBo {
	void setRollScore(RollScoreDm rollScoreDm);
	void RollOnce();
	void RollAndSetScore();
}
