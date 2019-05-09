package edu.skunkApp.businessobject;

import java.util.ArrayList;

import edu.skunkApp.domainModels.PlayerDm;

public interface IPlayerBo {
	public boolean create(ArrayList<PlayerDm> players);
}
