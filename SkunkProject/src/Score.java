
public class Score {
	private int turnScore;
	private int chipScore;
	private int kittyScore;

	public Score()
	{
		this.turnScore = 0;
		this.chipScore = 0;
		this.kittyScore = 0;
	}

	public Score(int score)
	{
		this.turnScore = score;
	}
	
	public Score(int score, int chipCount, int kittyCount)
	{
		this.turnScore = score;
		this.chipScore = chipCount;
		this.kittyScore = kittyCount;
	}
	
	public void setTurnScore(int score, int chipCount, int kittyCount)
	{
		this.turnScore += score;
		this.chipScore += chipCount;
		this.kittyScore += kittyCount;
	}
	
	public int getTurnScore()
	{
		return this.turnScore;
	}
	
	public int getChipChangeScore()
	{
		return this.chipScore;
	}
	
	public int getKittyChangeScore()
	{
		return this.kittyScore;
	}
	
	public void resetScore()
	{
		this.turnScore = 0;
	}
}
