package edu.skunkApp.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IntegerUtilTest {
	
	@Test
	public void testgetParsedValus() {
		IntegerUtil iu1 = new IntegerUtil();
		iu1.getParsedValue("123");
	}

}
