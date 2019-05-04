package edu.skunkApp.modelMapper;

import java.util.ArrayList;

import edu.skunkApp.data.RollScore;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreMapperDecorator implements RollScoreMapper {

  private final RollScoreMapper delegate;

  public RollScoreMapperDecorator(RollScoreMapper delegate) {
	  this.delegate = delegate;
  }
  
  @Override
  public RollScore toRollScore(RollScoreDm rollScoreDm) {
    return this.delegate.toRollScore(rollScoreDm);
  }

  @Override
  public RollScoreDm toRollScoreDm(RollScore rollScore) {
	  return this.delegate.toRollScoreDm(rollScore);
  }

  @Override
  public ArrayList<RollScoreDm> toRollScoreDmList(ArrayList<RollScore> rollScores) {
    return this.delegate.toRollScoreDmList(rollScores);
  }
		
}
