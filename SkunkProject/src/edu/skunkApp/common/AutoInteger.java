package edu.skunkApp.common;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoInteger {
	private static final AtomicInteger count = new AtomicInteger(0); 

	public static int nextId()
	{
		return count.incrementAndGet();
	}
	
}
