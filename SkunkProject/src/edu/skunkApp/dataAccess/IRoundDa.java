package edu.skunkApp.dataAccess;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.data.Round;
import edu.skunkApp.domainModels.RoundDm;

public interface IRoundDa {
	public UUID create();
	public ArrayList<RoundDm> getRounds();
}
