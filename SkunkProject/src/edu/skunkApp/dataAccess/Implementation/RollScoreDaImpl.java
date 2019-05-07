package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import edu.skunkApp.data.RollScore;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.RollScoreDm;
import edu.skunkApp.modelMapper.RollScoreMapper;

@Singleton
public class RollScoreDaImpl implements IRollScoreDa {
	
	@Inject private ArrayList<RollScore> rollScores;

	//Insert
	public void create(RollScoreDm rollScoreDm)
	{
		this.rollScores.add(RollScoreMapper.MAPPER.toRollScore(rollScoreDm));
	}
	
	public RollScoreDm getLastTurnScore(UUID playerId, UUID turnId) {
		RollScore turnScore = 
				this.rollScores.stream()
						.filter(rollScore -> rollScore.playerId == playerId && rollScore.turnId == turnId)
						.max((score1, score2) -> score2.id.compareTo(score1.id)).get();
		return RollScoreMapper.MAPPER.toRollScoreDm(turnScore);
	}

	public void resetPlayerScore(UUID playerId)
	{
		//TODO: check if the update works
		this.rollScores.stream()
				.filter(score -> score.playerId == playerId)
				.map(score -> score.roundTotal = 0);
	}
	
	public void resetPlayerTurnScore(UUID playerId, UUID turnId)
	{
		//TODO: check if the update works
		this.rollScores.stream()
				.filter(score -> score.playerId == playerId && score.turnId == turnId)
				.map(score -> score.turnTotal = 0);
	}


}
