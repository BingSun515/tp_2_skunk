package edu.skunkApp.modelMapper;

import java.util.ArrayList;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import edu.skunkApp.data.Round;
import edu.skunkApp.domainModels.RoundDm;

@Mapper
public interface RoundMapper {
	RoundMapper MAPPER = Mappers.getMapper(RoundMapper.class);
	
	@Mapping(target = "id", defaultExpression = "java(java.util.UUID.randomUUID())")
	Round toRound(RoundDm roundDm);

	ArrayList<RoundDm> toRoundDmList(ArrayList<Round> rounds);
}
