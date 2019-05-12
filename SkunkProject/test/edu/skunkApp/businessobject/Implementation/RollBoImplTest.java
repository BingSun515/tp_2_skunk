package edu.skunkApp.businessobject.Implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.skunkApp.domainModels.RollDm;

public class RollBoImplTest {
	
	@Test
	public void testgetRoll() {
		
		RollBoImpl rbi1 = new RollBoImpl();
		RollDm rd1 = new RollDm();
		rd1.die1 = 1;
		rd1.die2 = 3;
		assertEquals(true, rbi1.getRoll());
		
	}

}
