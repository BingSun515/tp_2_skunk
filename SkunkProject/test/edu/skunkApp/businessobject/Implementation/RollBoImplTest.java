package edu.skunkApp.businessobject.Implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.skunkApp.domainModels.RollDm;

public class RollBoImplTest {
	
	@Test
	public void testgetRoll() {
		
		RollBoImpl rbi1 = new RollBoImpl();
		
		assertEquals(3, rbi1.getRoll().diceTotal = 3);

	}

}
