package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import edu.skunkApp.data.RollScore;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.RollScoreDm;
import edu.skunkApp.modelMapper.RollScoreMapper;

public class RollScoreDaImpl implements IRollScoreDa {
	
	private ArrayList<RollScore> rollScores = new ArrayList<RollScore>();

	//Insert
	public void create(RollScoreDm rollScoreDm)
	{
		this.rollScores.add(RollScoreMapper.MAPPER.toRollScore(rollScoreDm));
	}

	public ArrayList<RollScoreDm> get()
	{
		return RollScoreMapper.MAPPER.toRollScoreDmList(this.rollScores);
	}
	
	public int getLastRoundScore(UUID roundId) {
		int score = 0;
		Optional<RollScore> lastRoundScore =  this.getLastRollScoreForRound(roundId);
		if (lastRoundScore.isPresent())
		{
			score = lastRoundScore.get().roundTotal;
		} else {
			throw new Error("Invalid roundId : " + roundId.toString());
		}
		return score;
	}

	public void resetPlayerScore(UUID playerId)
	{
		//TODO: check if the update works
		this.rollScores.stream()
				.filter(score -> score.playerId == playerId)
				.map(score -> score.roundTotal = 0);
	}

	/**
	 * Use max to get the last inserted score
	 * */
	private Optional<RollScore> getLastRollScoreForRound(UUID roundId) {
		return this.rollScores.stream()
				.filter(rollScore -> rollScore.roundId.equals(roundId))
				.max((score1, score2) -> score2.id.compareTo(score1.id));
	}

	private Optional<RollScore> getRollScore(int id)
	{
		return this.rollScores.stream()
						.filter(score -> score.id == id)
						.findFirst();
	}
}
