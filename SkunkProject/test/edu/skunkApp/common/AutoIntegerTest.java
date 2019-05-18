package edu.skunkApp.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AutoIntegerTest {
	
	@SuppressWarnings("static-access")
	@Test
	public void testAutoInteger() {
		AutoInteger ai1 = new AutoInteger();
		assertEquals(1, ai1.nextId());
	}

}
