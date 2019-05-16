package edu.skunkApp.businessobject.Implementation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RollBoImplTest {
	
	
	@Test
	public void testgetRoll() {
		
		RollBoImpl rbi1 = new RollBoImpl();
		
		assertEquals(3, rbi1.getRoll().diceTotal = 3);

	}

}
