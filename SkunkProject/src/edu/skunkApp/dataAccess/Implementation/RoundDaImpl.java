package edu.skunkApp.dataAccess.Implementation;

import java.util.ArrayList;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import edu.skunkApp.data.Round;
import edu.skunkApp.dataAccess.IRoundDa;
import edu.skunkApp.domainModels.RoundDm;
import edu.skunkApp.modelMapper.RoundMapper;

@Singleton
public class RoundDaImpl implements IRoundDa {
	
	@Inject ArrayList<Round> _rounds;

	public UUID create(Round round)
	{
		try {
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
		return RoundMapper.MAPPER.toRoundDmList(this._rounds);
	}
}
