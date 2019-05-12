//import edu.skunkApp.common.SkunkEnum;
//
///**
// * Dice represents a single pair of rollable Die objects, randomly generating
// * sums of their two values
// * 
// * This is a Javadoc comment: add more to your finished class below
// * 
// * @author eric
// *
// */
// 
//public class Dice
//{
//	// Instance fields (variables) may be declared anywhere in class body
//	// Convention: put at top
//
//	private int lastRoll;
//	private Die die1;
//	private Die die2;
//
//	// Constructors (object initializers) also can be declared anywhere
//	// Convention: after instance fields/variables
//
//	public Dice()
//	{
//		// initialize instance variables die1 and die2 by
//		// creating a new instance of each
//
//		this.die1 = new Die();
//		this.die2 = new Die();
//		this.roll();
//	}
//
//	Dice(Die die1, Die die2) // overloaded constructor
//	{
//		this.die1 = die1;
//		this.die2 = die2;
//	}
//
//	// Instance methods can also be declared anywhere
//	// Convention: after constructors
//	
//	//######################################
//	//PredictableDie
//	public void setDie1(Die d)
//	{
//		this.die1 = d;
//	}
//
//	public void setDie2(Die d)
//	{
//		this.die2 = d;
//	}
//	//######################################
//
//	public int getLastRoll()
//	{
//		return this.lastRoll;
//	}
//
//	public void roll()
//	{
//		// roll each of die1, die2, sum their last rolls,
//		// then set Dice.lastRoll to this value
//
//		die1.roll();
//		die2.roll();
//		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
//
//	}
//
//	public String toString()
//	{
//		return "Dice with last roll: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();
//
//	}
//	
//	public SkunkEnum getSkunk()
//	{
//		if (this.isDiceLastRollSingleSkunk())
//		{
//			return SkunkEnum.SINGLESKUNK;
//		}
//		else if (this.isDiceLastRollDoubleSkunk())
//		{
//			return SkunkEnum.DOUBLESKUNK;
//		}
//		else if (this.isDiceLastRollDeuceSkunk())
//		{
//			return SkunkEnum.DEUCESKUNK;
//		}
//		else
//		{
//			return SkunkEnum.NOSKUNK;
//		}
//	}
//	
//	public boolean isDiceLastRollSingleSkunk()
//	{
//		return ((this.die1.getLastRoll() == 1 && this.die2.getLastRoll() > 2) || (this.die2.getLastRoll() == 1 && this.die1.getLastRoll() > 2));
//	}
//	
//	public boolean isDiceLastRollDoubleSkunk()
//	{
//		return (this.die1.getLastRoll() == 1 && this.die2.getLastRoll() == 1);
//	}
//	
//	public boolean isDiceLastRollDeuceSkunk()
//	{
//		return (this.die1.getLastRoll() == 1) && (this.die2.getLastRoll() == 2 ) ||
//				(this.die2.getLastRoll() == 1 ) && (this.die1.getLastRoll() == 2 );
//	}
//
////	public static final int NUM_TRIALS = 360;
//
//}
