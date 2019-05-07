package edu.skunkApp.modelMapper;

import java.util.ArrayList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import edu.skunkApp.data.Player;
import edu.skunkApp.domainModels.PlayerDm;

@Mapper
public interface PlayerMapper {
	
	PlayerMapper MAPPER = Mappers.getMapper(PlayerMapper.class);

	@Mapping(target = "playerId", defaultExpression = "java(java.util.UUID.randomUUID())")
	@Mapping(target = "chipCount", defaultValue = "edu.skunkApp.common.GameConstants.PlayerChipCount")
	@Mapping(target = "isWinner", defaultValue = "false")
	Player toPlayer(PlayerDm playerDm);

	PlayerDm toPlayerDm(Player player);

	ArrayList<PlayerDm> toPlayerDmList(ArrayList<Player> players);	 
}
