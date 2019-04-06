import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void PlayerSetGetTest() 
	{
		Player p1 = new Player("Eric");
		assertEquals(p1.getPlayerName(), "Eric");
	}
	
//	@Test
//	public void PlayerActiveTest() 
//	{
//		Player p1 = new Player("Eric");
//		assertEquals(p1.isPlayerActive(), true);
//	}

}
