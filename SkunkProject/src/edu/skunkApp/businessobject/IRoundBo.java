package edu.skunkApp.businessobject;

import java.util.UUID;

public interface IRoundBo
{
	public UUID create();
	
	public boolean canProceedToNextRound();
}
