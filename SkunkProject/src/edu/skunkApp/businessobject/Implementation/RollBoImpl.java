package edu.skunkApp.businessobject.Implementation;

import edu.skunkApp.businessobject.IRollBo;
import edu.skunkApp.domainModels.RollDm;

public class RollBoImpl implements IRollBo {
	
	private RollDm roll = new RollDm();
	
	//make it static
	private static int getNewRoll()
	{
		return (int) (Math.random() * 6 + 1);
	}
	
	public RollDm getRoll()
	{
		this.roll.die1 = RollBoImpl.getNewRoll();
		this.roll.die2 = RollBoImpl.getNewRoll();
//		this.roll.diceTotal
		return this.roll;
	}
}
