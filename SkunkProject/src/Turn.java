//import java.util.ArrayList;
//import java.util.Iterator;
//
//class Turn {
//	private final int DOUBLE_SKUNK_CHIP = -4; 
//	private final int DOUBLE_SKUNK_KITTY = 4;
//
//	private final int DEUCE_SKUNK_CHIP = -2; 
//	private final int DEUCE_SKUNK_KITTY = 2;
//	
//	private final int SINGLE_SKUNK_CHIP = -1; 
//	private final int SINGLE_SKUNK_KITTY = 1; 
//
//	private ArrayList<Roll> rolls;
//	private ArrayList<Score> turnScores;
//
//	public Turn()
//	{
//		this.rolls = new ArrayList<Roll>();
//		this.turnScores = new ArrayList<Score>();
//	}
//
//	public Roll getLastRoll()
//	{
//		if (this.rolls.size() > -1)
//		{
//			return this.rolls.get(this.rolls.size() - 1);
//		}
//		else
//		{
//			return null;
//		}
//	}
//	
//	void rollAndSetScore()
//	{
//		this.newRoll();
//		this.setScore();
//	}
//
//	public Score getFinalTurnScore()
//	{
//		Score score = new Score();
//		Score nextScore;
//		Iterator<Score> scores = this.turnScores.iterator();
//		while(scores.hasNext())
//		{ 
//			nextScore = scores.next();
//			score.setTurnScore(nextScore.getTurnScore(), nextScore.getChipChangeScore(), nextScore.getKittyChangeScore());
//		}
//		return score;
//	}
//	 
//	public boolean isTurnScoreHigherThanWinningScore()
//	{
//		Score score = this.getFinalTurnScore();
//		return score.getTurnScore() >= score.getWinningScore(); 
//	}
//
//	private void newRoll()
//	{
//		this.rolls.add(new Roll());
//	}
//	
//	private void setScore()
//	{
//		Score score = null;
//		Roll roll = this.getLastRoll(); 
//		
//		if (roll.isDoubleSkunk())
//		{
//			score = new Score(0, this.DOUBLE_SKUNK_CHIP, this.DOUBLE_SKUNK_KITTY);
//		}
//		else if (roll.isDeuceSkunk())
//		{
//			score = new Score(0, this.DEUCE_SKUNK_CHIP, this.DEUCE_SKUNK_KITTY);
//		}
//		else if (roll.isSingleSkunk())
//		{
//			score = new Score(0, this.SINGLE_SKUNK_CHIP, this.SINGLE_SKUNK_KITTY);
//		}
//		else
//		{
//			score = new Score(roll.getDiceLastRoll(), 0, 0);
//		}
//		turnScores.add(score);
//	}
//	
//}
