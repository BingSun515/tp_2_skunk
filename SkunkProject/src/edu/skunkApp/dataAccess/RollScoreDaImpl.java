package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import edu.skunkApp.data.RollScore;
import edu.skunkApp.domainModels.RollScoreDm;
import edu.skunkApp.modelMapper.RollScoreMapper;

public class RollScoreDaImpl implements IRollScoreDa {
	
	private ArrayList<RollScore> rollScores = new ArrayList<RollScore>();
	//Insert
	
	public void add(RollScoreDm rollScoreDm)
	{
		this.rollScores.add(RollScoreMapper.MAPPER.toRollScore(rollScoreDm));
	}

	public ArrayList<RollScoreDm> get()
	{
		return RollScoreMapper.MAPPER.toRollScoreDmList(this.rollScores);
	}

}
