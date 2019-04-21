package edu.skunkApp.modelMapper;

import java.util.ArrayList;

import org.mapstruct.Mapper;

import edu.skunkApp.data.RollScore;
import org.mapstruct.factory.Mappers;
import edu.skunkApp.domainModels.RollScoreDm;

@Mapper
public interface RollScoreMapper {

//	RollScoreDm rollScoreDmToRollScore(RollScore domainModel);
//	RollScore rollScoreToRollScoreDm(RollScoreDm entity);
	
	RollScoreMapper MAPPER = Mappers.getMapper(RollScoreMapper.class);

	RollScore toRollScore(RollScoreDm rollScoreDm);
	RollScoreDm toRollScoreDm(RollScore rollScore);
	
	ArrayList<RollScoreDm> toRollScoreDmList(ArrayList<RollScore> rollScores);	 
}
