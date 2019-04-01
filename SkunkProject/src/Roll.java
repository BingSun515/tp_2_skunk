
public class Roll {
	private Dice dice;
	
	public boolean isDoubleSkunk()
	{
		return this.dice.isDiceLastRollDoubleSkunk();
	}
	
	public boolean isDeuceSkunk()
	{
		return this.dice.isDiceLastRollDeuceSkunk();
	}

	public boolean isSingleSkunk()
	{
		return this.dice.isDiceLastRollSingleSkunk();
	}
	
	public boolean isSkunk()
	{
		return (this.isDoubleSkunk() || this.isDeuceSkunk() || this.isSingleSkunk());
	}
}
