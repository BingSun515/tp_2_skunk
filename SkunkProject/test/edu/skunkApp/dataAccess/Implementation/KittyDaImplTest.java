package edu.skunkApp.dataAccess.Implementation;

//import org.junit.jupiter.api.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class KittyDaImplTest {
	
	@Test
	public void testKittyDaImpl() {
		
		KittyDaImpl kd1 = new KittyDaImpl();
		kd1.setChipCount(123);
		assertEquals(123, kd1.getChipCount());
		
	}

}
