import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void PlayerTest() {
		Player p1 = new Player("Eric");
		assertEquals(p1.getPlayerName(), "Eric");
	}

}
