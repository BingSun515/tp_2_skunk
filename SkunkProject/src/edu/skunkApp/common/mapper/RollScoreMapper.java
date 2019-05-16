package edu.skunkApp.common.mapper;

import java.util.ArrayList;

import edu.skunkApp.data.RollScore;
import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;
import edu.skunkApp.common.AutoInteger;

public class RollScoreMapper {

	public static RollScore toRollScore(RollScoreDm rollScoreDm)
	{
		RollScore score = new RollScore();
		score.id =  AutoInteger.nextId();
		score.playerId =  rollScoreDm.playerId;
		score.roundId =  rollScoreDm.roundId;
		score.turnId =  rollScoreDm.turnId;
		score.rollId =  rollScoreDm.rollId; //TODO WHAT IS THIS?
		score.die1 =  rollScoreDm.roll.die1;
		score.die2 =  rollScoreDm.roll.die2;
		score.diceTotal =  rollScoreDm.roll.diceTotal;
		score.rollStatus =  rollScoreDm.rollStatus;
		score.turnTotal =  rollScoreDm.turnTotal;
		score.roundTotal =  rollScoreDm.roundTotal;
		return score;
	}

	public static RollScoreDm toRollScoreDm(RollScore rollScore)
	{
		RollDm roll = new RollDm();
		roll.die1 =  rollScore.die1;
		roll.die2 =  rollScore.die2;
		roll.diceTotal =  rollScore.diceTotal;
		RollScoreDm score = new RollScoreDm();
		score.id =  AutoInteger.nextId();
		score.playerId =  rollScore.playerId;
		score.roundId =  rollScore.roundId;
		score.turnId =  rollScore.turnId;
		score.rollId =  rollScore.rollId; //TODO WHAT IS THIS?
		score.roll =  roll;
		score.rollStatus =  rollScore.rollStatus;
		score.turnTotal =  rollScore.turnTotal;
		score.roundTotal =  rollScore.roundTotal;
		return score;
	}
	
	public static ArrayList<RollScoreDm> toRollScoreDmList(ArrayList<RollScore> rollScores)
	{
		ArrayList<RollScoreDm> scores = new ArrayList<RollScoreDm>();
		rollScores.forEach(rollScore -> scores.add(toRollScoreDm(rollScore)));
		return scores;
	}
}
