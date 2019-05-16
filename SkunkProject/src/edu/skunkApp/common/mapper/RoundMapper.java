package edu.skunkApp.common.mapper;

import java.util.ArrayList;

import edu.skunkApp.data.Round;
import edu.skunkApp.domainModels.RoundDm;


public class RoundMapper {
	static RoundDm toRoundDm(Round round)
	{
		RoundDm roundDm = new RoundDm();
		roundDm.id = round.id;
		roundDm.description = round.description;
		return roundDm;
	}

	public static ArrayList<RoundDm> toRoundDmList(ArrayList<Round> rounds)
	{
		ArrayList<RoundDm> list = new ArrayList<RoundDm>();
		rounds.forEach(round -> toRoundDm(round));
		return list;
	}
}
