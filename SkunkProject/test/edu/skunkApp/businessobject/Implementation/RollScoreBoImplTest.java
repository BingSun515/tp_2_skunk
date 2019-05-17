package edu.skunkApp.businessobject.Implementation;

import org.junit.jupiter.api.Test;

import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImplTest {
	
	@Test
	public void testresetPlayerScoresForSkunk() {
		RollScoreBoImpl rsbi1= new RollScoreBoImpl();
		RollScoreDm rsd1 = new RollScoreDm();
		rsd1.rollStatus = SkunkEnum.SINGLESKUNK;
		rsbi1.resetPlayerScoresForSkunk(rsd1);
	}

}
