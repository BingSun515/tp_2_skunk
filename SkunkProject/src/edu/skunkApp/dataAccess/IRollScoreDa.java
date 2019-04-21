package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import edu.skunkApp.data.RollScore;
import edu.skunkApp.domainModels.RollScoreDm;

public interface IRollScoreDa {
	void add(RollScoreDm score);
	ArrayList<RollScoreDm> get();
}
