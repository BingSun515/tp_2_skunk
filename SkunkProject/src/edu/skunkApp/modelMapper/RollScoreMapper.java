package edu.skunkApp.modelMapper;

import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.skunkApp.data.RollScore;
import org.mapstruct.factory.Mappers;
import edu.skunkApp.domainModels.RollScoreDm;

@Mapper
public interface RollScoreMapper {

//	RollScoreDm rollScoreDmToRollScore(RollScore domainModel);
//	RollScore rollScoreToRollScoreDm(RollScoreDm entity);
	
	RollScoreMapper MAPPER = Mappers.getMapper(RollScoreMapper.class);

	@Mapping(target = "id", defaultExpression = "java(edu.skunkApp.common.AutoInteger.nextId())")
	@Mapping(source = "roll.die1", target = "die1")
	@Mapping(source = "roll.die2", target = "die2")
	@Mapping(source = "roll.diceTotal", target = "roll.diceTotal")
	RollScore toRollScore(RollScoreDm rollScoreDm);
	
//	@AfterMapping
//	default void AfterMapping(@MappingTarget RollScore rollScore, RollScoreDm rollScoreDm) {
//		rollScore (rollScoreDm.roll.die1 + rollScoreDm.roll.die2);
//	}

	RollScoreDm toRollScoreDm(RollScore rollScore);
	
	ArrayList<RollScoreDm> toRollScoreDmList(ArrayList<RollScore> rollScores);	 
}
