package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import java.util.UUID;

import edu.skunkApp.common.mapper.RoundMapper;
import edu.skunkApp.data.Round;
import edu.skunkApp.data.Store;
import edu.skunkApp.dataAccess.IRoundDa;
import edu.skunkApp.domainModels.RoundDm;

public class RoundDaImpl implements IRoundDa {
	
	ArrayList<Round> _rounds = Store.getRound();

	public UUID create()
	{
		try {
			Round round = new Round();
			round.id = UUID.randomUUID();
			round.description = "Round - " + this._rounds.size() + 1;
			this._rounds.add(round);
			return round.id;
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
			return null;
		}
	}

	public ArrayList<RoundDm> getRounds()
	{
		return RoundMapper.toRoundDmList(this._rounds);
	}
}
