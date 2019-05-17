package edu.skunkApp.businessobject;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.domainModels.RoundDm;

public interface IRoundBo
{
	public UUID create();
	
	public boolean canProceedToNextRound();
	
	public ArrayList<RoundDm> getRounds();
}
