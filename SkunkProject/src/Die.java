
public class Die
{
	private int lastRoll;
	private int[] rolls;
	private boolean predictable = false;

	public Die()
	{
		this.predictable = false;
		this.roll();
	}
	
	public Die(int[] initialValues)
	{
		this.rolls = initialValues;
		this.predictable = true;
		this.roll();
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return anything
	{
		if (!predictable)
			this.lastRoll = (int) (Math.random() * 6 + 1);
		else
		{
			this.lastRoll = this.rolls[0];
		}
	}
	
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
