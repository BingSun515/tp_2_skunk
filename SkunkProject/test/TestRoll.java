import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoll {

	@Test
	public void DoubleSkunktest() 
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {1});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(true, d1.isDiceLastRollDoubleSkunk(),true);
	}
	
	@Test
	public void DoubleSkunktest2() 
	{
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {1});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(false, d1.isDiceLastRollDoubleSkunk());
	}
	
	@Test
	public void DeuceSkunktest() 
	{
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {1});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(true, d1.isDiceLastRollDeuceSkunk());
	}
	
	@Test
	public void DeuceSkunktestTest2() 
	{
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {2});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(false, d1.isDiceLastRollDeuceSkunk());
	}
	
	@Test
	public void SingleSkunkTest() 
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(true, d1.isDiceLastRollSingleSkunk());
	}
	
	@Test
	public void SingleSkunkTest2() 
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(false, d1.isDiceLastRollSingleSkunk());
	}
	
	
	@Test
	public void SingleSkunkTest3() 
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {1});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(false, d1.isDiceLastRollSingleSkunk());
	}

}
