package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.skunkApp.common.mapper.RollScoreMapper;
import edu.skunkApp.data.RollScore;
import edu.skunkApp.data.Store;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreDaImpl implements IRollScoreDa {
	
	private final ArrayList<RollScore> rollScores = Store.getRollScore();

	//Insert
	public void create(RollScoreDm rollScoreDm)
	{
		this.rollScores.add(RollScoreMapper.toRollScore(rollScoreDm));
	}
	
	public ArrayList<RollScoreDm> baseQuery()
	{
		if (this.rollScores.isEmpty())
		{
			return new ArrayList<RollScoreDm>();
		}
		else
		{
			return RollScoreMapper.toRollScoreDmList(this.rollScores);
		}
	}
	
	public ArrayList<RollScoreDm> getFilteredRollScore(
												UUID playerId,
												UUID turnId,
												UUID roundId)
	{
		Supplier<Stream<RollScoreDm>> rollScoreDmSupplier = () -> this.baseQuery().stream();
		if (playerId != null)
		{
			rollScoreDmSupplier.get().filter(rollScore -> rollScore.playerId == playerId);
		}
		
		if (turnId != null)
		{
			rollScoreDmSupplier.get().filter(rollScore -> rollScore.turnId == turnId);
		}
		
		if (roundId != null)
		{
			rollScoreDmSupplier.get().filter(rollScore -> rollScore.roundId == roundId);
		}
		rollScoreDmSupplier.get().sorted((score1, score2) -> Integer.compare(score2.id, score1.id));

		return (ArrayList<RollScoreDm>) rollScoreDmSupplier.get().collect(Collectors.toList());
	}
	
	public RollScoreDm getPlayerLastTurnScore(UUID playerId, UUID turnId)
	{
		ArrayList<RollScoreDm> score = this.getFilteredRollScore(playerId, turnId, null);

		if(score.isEmpty())
		{
			return new RollScoreDm();
		}
		return score.get(score.size() - 1);
	}

	public RollScoreDm getLastRollScore()
	{
		if (this.rollScores.isEmpty())
		{
			return null;
		}
		return this.baseQuery().get(this.rollScores.size() - 1);
	}

	public void setPlayerLastTurnGameStatus(RollScoreDm lastRollScoreDm) {
		this.rollScores.stream()
					.filter(score -> score.id == lastRollScoreDm.id)
					.map(score -> score.gameStatus = lastRollScoreDm.gameStatus);
	}
	
	public void resetPlayerScore(UUID playerId)
	{
		this.rollScores.stream()
				.filter(score -> score.playerId == playerId)
				.map(score -> score.roundTotal = 0);
	}
	
	public void resetPlayerTurnScore(UUID playerId, UUID turnId)
	{
		this.rollScores.stream()
				.filter(score -> score.playerId == playerId && score.turnId == turnId)
				.map(score -> score.turnTotal = 0);
	}

}
