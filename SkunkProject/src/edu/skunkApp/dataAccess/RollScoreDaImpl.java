package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import edu.skunkApp.data.RollScore;
import edu.skunkApp.domainModels.RollScoreDm;
import edu.skunkApp.modelMapper.RollScoreMapper;

public class RollScoreDaImpl implements IRollScoreDa {
	
	private ArrayList<RollScore> rollScores = new ArrayList<RollScore>();

	//Insert
	public void createRollScore(RollScoreDm rollScoreDm)
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

	public void resetRoundScore(UUID roundId)
	{
		Optional<RollScore> lastRoundScore =  this.getLastRollScoreForRound(roundId);
		if (lastRoundScore.isPresent())
		{
			lastRoundScore.map(score -> score.roundTotal = 0);	
		} else {
			throw new Error("Invalid roundId : " + roundId.toString());
		}
	}

	/**
	 * Use max to get the last inserted score
	 * */
	private Optional<RollScore> getLastRollScoreForRound(UUID roundId) {
		return this.rollScores.stream()
				.filter(rollScore -> rollScore.roundId.equals(roundId))
				.max((score1, score2) -> score2.id.compareTo(score1.id));
	}

}
