package edu.skunkApp.businessobject.Implementation;

import edu.skunkApp.businessobject.IRoll;
import edu.skunkApp.domainModels.RollDm;

public class Roll implements IRoll {
	
	RollDm roll = new RollDm();
	
	//make it static
	private static int getNewRoll()
	{
		return (int) (Math.random() * 6 + 1);
	}
	
	public RollDm getRoll()
	{
		this.roll.die1 = Roll.getNewRoll();
		this.roll.die2 = Roll.getNewRoll();
//		this.roll.diceTotal
		return this.roll;
	}
}
