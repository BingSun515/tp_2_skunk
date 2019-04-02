
public class Score {
	private int turnScore;
	private int chips;
	private int kitty;

	public Score()
	{
		this.turnScore = 0;
		this.chips = 0;
		this.kitty = 0;
	}
	
	public void addScore(int score, int chipChange, int kittyChange)
	{
		this.turnScore += score;
		this.chips += chipChange;
		this.kitty += kittyChange;
	}
	
	public int getTurnScore()
	{
		return this.turnScore;
	}
	
	public int getChipChangeScore()
	{
		return this.chips;
	}
	
	public int getKittyChangeScore()
	{
		return this.kitty;
	}
	
	public void resetScore()
	{
		this.turnScore = 0;
	}
}
