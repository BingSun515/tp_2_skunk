package edu.skunkApp.dataAccess.Implementation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class testKittyDaImpl {
	
	private ArrayList<Integer> _chips;
	
	@Test (expected=NullPointerException.class)
	  public void testKittyDaImpl() {
		_chips = new ArrayList<Integer>();
		_chips.add(1);
		_chips.add(2);
		_chips.add(3);
		System.out.println(_chips);
		KittyDaImpl KD1 = new KittyDaImpl();
	  }
}
