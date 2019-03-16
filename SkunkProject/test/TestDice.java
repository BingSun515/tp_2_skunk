import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDice {
	
	@Test
	public void Dice_roll_once_oneNumber_equals_lastRoll_total()
	{
		Die die1 = new Die(new int[] {3});
		Die die2 = new Die(new int[] {4});
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		
		assertEquals("value is not 7", 7, dice.getLastRoll());		
	}
	
	@Test
	public void Dice_roll_twice_twonumbers_equals_lastRoll_total()
	{
		Die die1 = new Die(new int[] {3, 4});
		Die die2 = new Die(new int[] {1, 2});
		
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		assertEquals("value is not 4", 4, dice.getLastRoll());
		
		dice.roll();
		assertEquals("value is not 6", 6, dice.getLastRoll());
	}
	
	@Test
	public void Dice_roll_Thrice_twonumbers_equals_provides_firstRoll_total()
	{
		Die die1 = new Die(new int[] {3, 4});
		Die die2 = new Die(new int[] {1, 2});
		
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		dice.roll();		
		dice.roll();
		assertEquals("value is not 4", 4, dice.getLastRoll());
	}
	
	@Test
	public void Dice_roll_Thrice_threenumbers_equals_provides_firstRoll_total()
	{
		Die die1 = new Die(new int[] {3, 4, 6});
		Die die2 = new Die(new int[] {1, 2, 3});
		
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		dice.roll();		
		dice.roll();
		assertEquals("value is not 9", 9, dice.getLastRoll());
	}
	
	@Test
	public void Dice_roll_Fourtimes_FourandThreenumbers_equals_provides_firstRoll_total()
	{
		Die die1 = new Die(new int[] {3, 4, 5, 6});
		Die die2 = new Die(new int[] {1, 2, 3});
		
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		dice.roll();		
		dice.roll();
		dice.roll();
		assertEquals("value is not 7", 7, dice.getLastRoll());
	}
	
	@Test
	public void test_to_string() {
		Die die1 = new Die(new int[] {1,2,3});
		Die die2 = new Die(new int[] {2,3,4});

		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(dice.toString(), "Dice with last roll: 3 => 1 + 2");
	}
	
	@Test(expected=RuntimeException.class)
	public void Dice_roll_once_OneEmptyArrayInitializer_throws_ArrayIndexOutOfBoundsException()
	{
		Die die1 = new Die(new int[] {3, 4});
		Die die2 = new Die(new int[] {});
		
		Dice dice = new Dice(die1, die2);		
		dice.roll();
	}
	
	@Test(expected=RuntimeException.class)
	public void Dice_roll_once_NullInitializer_throws_RuntimeException()
	{	
		Dice dice = new Dice(null, null);		
		dice.roll();
	}
}
