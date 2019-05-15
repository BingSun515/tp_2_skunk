package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	public ArrayList<RollScoreDm> baseQuery()
	{
		if (this.rollScores.isEmpty())
		{
			return new ArrayList<RollScoreDm>();
		}
		else
		{
			return RollScoreMapper.MAPPER.toRollScoreDmList(this.rollScores);
		}
	}
	
	public ArrayList<RollScoreDm> getFilteredRollScore(
												UUID playerId,
												UUID turnId,
												UUID roundId)
	{
		Stream<RollScoreDm> rollScoreDmStream = this.baseQuery().stream();
		if (playerId != null)
		{
			rollScoreDmStream.filter(rollScore -> rollScore.playerId == playerId);
		}
		
		if (turnId != null)
		{
			rollScoreDmStream.filter(rollScore -> rollScore.turnId == turnId);
		}
		
		if (roundId != null)
		{
			rollScoreDmStream.filter(rollScore -> rollScore.roundId == roundId);
		}
		rollScoreDmStream.sorted((score1, score2) -> Integer.compare(score2.id, score1.id));
		return (ArrayList<RollScoreDm>) rollScoreDmStream.collect(Collectors.toList());
	}
	
	public RollScoreDm getPlayerTurnScore(UUID playerId, UUID turnId)
	{
		ArrayList<RollScoreDm> score = this.getFilteredRollScore(playerId, turnId, null);
		return score.get(score.size());
	}

	public RollScoreDm getLastRollScore()
	{
		if (this.rollScores.isEmpty())
		{
			return null;
		}
		return this.baseQuery().get(this.rollScores.size());
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
