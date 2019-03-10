import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDie {

	@Test
	public void Die_NewInstance_Rolls_a_die()
	{
		Die die = new Die(new int[] {5});
		
		assertEquals(5, die.getLastRoll());
	}
}
