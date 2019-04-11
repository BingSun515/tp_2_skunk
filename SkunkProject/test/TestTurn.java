import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

public class TestTurn {	
	
	@Test
	public void setLastRoll() {
		Turn t1 = new Turn();
		Roll lastRoll = null;
		t1.setLastRoll(lastRoll);
	}
	
	@Test
	public void getLastRoll() {
		Turn t1 = new Turn();
		Roll lastRoll = null;
		t1.setLastRoll(lastRoll);
		t1.getLastRoll();
	}

	@Test
	public void rollAndSetScore() {
		Turn t1 = new Turn();
		t1.rollAndSetScore();
	}
	
}
