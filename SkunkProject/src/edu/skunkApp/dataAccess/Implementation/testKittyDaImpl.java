package edu.skunkApp.dataAccess.Implementation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class testKittyDaImpl {
	
	private ArrayList<Integer> _chips;
	
	@Test (expected=NullPointerException.class)
	  public void testKittyDaImpl() {
		KittyDaImpl Kd1 = new KittyDaImpl();
		_chips = new ArrayList<Integer>();
		_chips.add(1);
		_chips.add(2);
//		Kd1.setChipCount(2);
//		Kd1.setChipCount(2);
	System.out.println(_chips);
		System.out.println(_chips.stream().mapToInt(chip -> chip.intValue()).sum());
		assertEquals(3,_chips.stream().mapToInt(chip -> chip.intValue()).sum());
	  } 
}
