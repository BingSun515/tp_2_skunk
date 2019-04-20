import java.util.ArrayList;
import java.util.Iterator;

class Round
{	
	private ArrayList<Turn> turns;

	Round(Turn turn)
	{
		this.turns = new ArrayList<Turn>();
		this.turns.add(turn);
	}

	Score getScore()
	{
		Iterator<Turn> turn = this.turns.iterator();
		Score nextTurnScore = new Score();
		while(turn.hasNext())
		{
			
			Turn nextTurn = turn.next();
			Score score = nextTurn.getFinalTurnScore();
			nextTurnScore.setTurnScore(score.getTurnScore(), score.getChipChangeScore(), score.getKittyChangeScore());

		}
		
		return nextTurnScore;
	}
}
