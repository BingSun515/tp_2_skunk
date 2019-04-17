class Score {
	private int turnScore;
	private int chipScore;
	private int kittyScore;
	
	private final int WINNING_SCORE = 100;

	public Score()
	{
		this.turnScore = 0;
		this.chipScore = 0;
		this.kittyScore = 0;
	}

	Score(int score)
	{
		this.turnScore = score;
	}
	
	Score(int score, int chipCount, int kittyCount)
	{
		this.turnScore = score;
		this.chipScore = chipCount;
		this.kittyScore = kittyCount;
	}
	
	void setTurnScore(int score, int chipCount, int kittyCount)
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

	public int getWinningScore()
	{
		return this.WINNING_SCORE;
	}
}
