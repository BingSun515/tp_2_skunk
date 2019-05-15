package edu.skunkApp.modelMapper;

import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.skunkApp.data.RollScore;
import org.mapstruct.factory.Mappers;
import edu.skunkApp.domainModels.RollScoreDm;

@Mapper
public interface RollScoreMapper {

	RollScoreMapper MAPPER = Mappers.getMapper(RollScoreMapper.class);

	@Mapping(target = "id", defaultExpression = "java(edu.skunkApp.common.AutoInteger.nextId())")
	@Mapping(source = "roll.die1", target = "die1")
	@Mapping(source = "roll.die2", target = "die2")
	@Mapping(source = "roll.diceTotal", target = "diceTotal")
	RollScore toRollScore(RollScoreDm rollScoreDm);

	@Mapping(source = "die1", target = "roll.die1")
	@Mapping(source = "die2", target = "roll.die2")
	@Mapping(source = "diceTotal", target = "roll.diceTotal")
	RollScoreDm toRollScoreDm(RollScore rollScore);
	
	ArrayList<RollScoreDm> toRollScoreDmList(ArrayList<RollScore> rollScores);	 
}
