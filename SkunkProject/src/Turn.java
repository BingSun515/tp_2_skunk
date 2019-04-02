import java.util.ArrayList;;

public class Turn {
	
	private int turnScore;
	private Roll roll;
	private ArrayList<Roll> rolls;

	public Turn()
	{
		turnScore = 0;
		this.rolls = new ArrayList<Roll>();
	}
	
	public void addTurnScore(int score)
	{
		turnScore = turnScore + score;
	}
	
	public int getTurnScore()
	{
		return turnScore;
	}
	
	public void setLastRoll(Roll lastRoll)
	{
		this.rolls.add(lastRoll);
	}
	
	public Roll getLastRoll()
	{
		if (this.rolls.size() -1 > 0)
		{
			return this.rolls.get(this.rolls.size() -1 );
		}
		else
		{
			return null;
		}
	}
	
	public void newTurn()
	{
		this.rolls.add(new Roll());
	}
	
}
