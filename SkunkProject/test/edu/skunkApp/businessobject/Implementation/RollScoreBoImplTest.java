package edu.skunkApp.businessobject.Implementation;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImplTest {
	
	@Test
	public void testmoveKittyChangeToWinner() {
		RollScoreBoImpl rsbi1 = new RollScoreBoImpl();
		RollScoreDm rsd1 = new RollScoreDm();
		rsd1.kittyChange = 123;
		rsbi1.moveKittyChangeToWinner(rsd1);
		
		
	}

}
