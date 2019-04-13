import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestTurn {	
	
	@Before
	public void setUp() {
		ArrayList<Roll> rolls;
		ArrayList<Score> turnScores;
	}
	
	@Test
	public void testSetGet() {
		Turn t1 = new Turn();
		t1.setLastRoll(null);
		assertEquals(null, t1.getLastRoll());
	}
	

}
