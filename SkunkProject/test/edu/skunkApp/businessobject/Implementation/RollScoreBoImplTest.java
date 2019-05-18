package edu.skunkApp.businessobject.Implementation;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.domainModels.RollScoreDm;

public class RollScoreBoImplTest {
	
	@Test
	public void testmoveKittyChangeToWinner() {
		RollScoreBoImpl rsbi1 = new RollScoreBoImpl();
		RollScoreDm rsd1 = new RollScoreDm();
		rsd1.kittyChange = 123;
		rsbi1.moveKittyChangeToWinner(rsd1);
		assertEquals(0, rsd1.chipChange);
	}
	
	@Test
	public void testgetLastRollScore() {
		RollScoreBoImpl rsbi1 = new RollScoreBoImpl();
		rsbi1.getLastRollScore();
		//keep implementing
	}

	@Test
	public void testsetScoreFromWinnerChoice1() {
		RollScoreBoImpl rsbi1 = new RollScoreBoImpl();
		RollScoreDm rsd1 = new RollScoreDm();
		rsbi1.setScoreFromWinnerChoice(true, rsd1);
		//keep implementing
	}
	
}