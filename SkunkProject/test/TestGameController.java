import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameController {

	@Test
	public void gcPlayer() {
		GameController gc1 = new GameController();
		gc1.setPlayer("Eric");
		assertEquals("Eric", gc1.getPlayerName());
	}
	
	@Test
	public void gcPlayer2() {
		GameController gc1 = new GameController();
		gc1.setPlayer(null);
		assertEquals(null, gc1.getPlayerName());
	}
	
//	@Test
//	public void gcStartGame() {
//		GameController gc1 = new GameController();
//		gc1.startGame("Eric");
//	}
}
