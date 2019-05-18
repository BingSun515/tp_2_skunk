package edu.skunkApp.businessobject.Implementation;

//import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

//import org.junit.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.skunkApp.common.GameStatusEnum;
import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.dataAccess.IRollScoreDa;
import edu.skunkApp.dataAccess.Implementation.RollScoreDaImpl;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;

public class GameRulesEngineBoImplTest {
	
	@Test
	public void testGameRulesEngineBoImpl() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		assertEquals(false, grebi1.getGameStatus(87));
		assertEquals(true, grebi1.getGameStatus(101));
		
	}
	
	//keeping implementation########################################
	@Test
	public void testmoveChips() {
		RollScoreDm rsd1 = new RollScoreDm();
		PlayerDm pd1 = new PlayerDm();
		pd1.name = "Eric";
		ArrayList<PlayerDm> ar1 = new ArrayList<PlayerDm>();
		ar1.add(pd1);
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		grebi1.moveChipsFromLosers(rsd1, ar1);
		assertEquals(-10, ar1.get(0).chipCount);
		assertEquals(10, rsd1.chipChange);	
	}
	
	@Test
	public void testmoveChips2() {
		RollScoreDm rsd1 = new RollScoreDm();
		PlayerDm pd1 = new PlayerDm();
		pd1.name = "Eric";
		pd1.Score = 20;
		ArrayList<PlayerDm> ar1 = new ArrayList<PlayerDm>();
		ar1.add(pd1);
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		grebi1.moveChipsFromLosers(rsd1, ar1);
		assertEquals(-5, ar1.get(0).chipCount);
		assertEquals(5, rsd1.chipChange);	
	}
	
	
	@Test
	public void testsetSkunkAndScore() {
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollScoreDm rsd1 = new RollScoreDm();
//		RollScoreDm rsd2 = new RollScoreDm();
//		rsd1.roll.die1 = 1;
//		rsd1.roll.die2 = 2;
//		grebi1.setSkunkAndScore(rsd1, rsd2);

		// have no idea, keeping implement
	}
	
	@Test
	public void testgetGameStatus() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		assertEquals(GameStatusEnum.CONTINUE_ROLL ,grebi1.getGameStatus());
	}
	
	@Test
	public void testsetGamestatus() {
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollScoreDm rsd1 = new RollScoreDm();
		grebi1.setGameStatus(rsd1);
	}
	
	@Test
	public void testresetPlayerScoresForSkunk1() {
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollScoreDm rsd1 = new RollScoreDm();
		rsd1.id=123;
		rsd1.rollStatus = SkunkEnum.DOUBLESKUNK;
		grebi1.resetPlayerScoresForSkunk(rsd1);
		assertEquals(123, rsd1.id);
	}
	//not implementes well##########################################
	
	@Test
	public void testresetPlayerScoresForSkunk2() {
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollScoreDm rsd1 = new RollScoreDm();
		rsd1.id=123;
		rsd1.rollStatus = SkunkEnum.SINGLESKUNK;
		grebi1.resetPlayerScoresForSkunk(rsd1);
		assertEquals(123, rsd1.id);
	}
	//not implementes well##########################################
	
	@Test
	public void testcanContinueRoll() {
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		assertEquals(true, grebi1.canContinueRoll());	
	}
	
	@Test
	public void testgetGoalScore() {
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		assertEquals(0, grebi1.getGoalScore());
	}
	
	//##############################################################
	
	@Test
	public void testisRollSingleSkunk1() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollDm rd1 = new RollDm();
		rd1.die1 = 1;
		rd1.die2 = 3;
		assertEquals(true, grebi1.isRollSingleSkunk(rd1));
		
	}
	
	@Test
	public void testisRollSingleSkunk2() {
		
		GameRulesEngineBoImpl grebi2 = new GameRulesEngineBoImpl();
		RollDm rd2 = new RollDm();
		rd2.die1 = 3;
		rd2.die2 = 1;
		assertEquals(true, grebi2.isRollSingleSkunk(rd2));
		
	}
	
	@Test
	public void testisRollSingleSkunk3() {
		
		GameRulesEngineBoImpl grebi3 = new GameRulesEngineBoImpl();
		RollDm rd3 = new RollDm();
		rd3.die1 = 2;
		rd3.die2 = 4;
		assertEquals(false, grebi3.isRollSingleSkunk(rd3));
		
	}
	
	@Test
	public void testisRollSingleSkunk4() {
		
		GameRulesEngineBoImpl grebi3 = new GameRulesEngineBoImpl();
		RollDm rd3 = new RollDm();
		rd3.die1 = 1;
		rd3.die2 = 2;
		assertEquals(false, grebi3.isRollSingleSkunk(rd3));
		
	}
	
	@Test
	public void testisRollSingleSkunk5() {
		
		GameRulesEngineBoImpl grebi3 = new GameRulesEngineBoImpl();
		RollDm rd3 = new RollDm();
		rd3.die1 = 2;
		rd3.die2 = 1;
		assertEquals(false, grebi3.isRollSingleSkunk(rd3));
		
	}
	
	@Test
	public void testisRollDoubleSkunk1() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollDm rd1 = new RollDm();
		rd1.die1 = 1;
		rd1.die2 = 1;
		assertEquals(true, grebi1.isRollDoubleSkunk(rd1));
		
	}
	
	@Test
	public void testisRollDoubleSkunk2() {
		
		GameRulesEngineBoImpl grebi2 = new GameRulesEngineBoImpl();
		RollDm rd2 = new RollDm();
		rd2.die1 = 2;
		rd2.die2 = 2;
		assertEquals(false, grebi2.isRollDoubleSkunk(rd2));
		
	}
	
	@Test
	public void testisRollDoubleSkunk3() {
		
		GameRulesEngineBoImpl grebi2 = new GameRulesEngineBoImpl();
		RollDm rd2 = new RollDm();
		rd2.die1 = 1;
		rd2.die2 = 2;
		assertEquals(false, grebi2.isRollDoubleSkunk(rd2));
		
	}
	
	@Test
	public void testisRollDeuceSkunk1() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollDm rd1 = new RollDm();
		rd1.die1 = 1;
		rd1.die2 = 2;
		assertEquals(true, grebi1.isRollDeuceSkunk(rd1));
		
	}
	
	@Test
	public void testisRollDeuceSkunk2() {
		
		GameRulesEngineBoImpl grebi2 = new GameRulesEngineBoImpl();
		RollDm rd2 = new RollDm();
		rd2.die1 = 2;
		rd2.die2 = 1;
		assertEquals(true, grebi2.isRollDeuceSkunk(rd2));
		
	}
	
	@Test
	public void testisRollDeuceSkunk3() {
		
		GameRulesEngineBoImpl grebi3 = new GameRulesEngineBoImpl();
		RollDm rd3 = new RollDm();
		rd3.die1 = 3;
		rd3.die2 = 4;
		assertEquals(false, grebi3.isRollDeuceSkunk(rd3));
		
	}
	@Test
	public void testisRollDeuceSkunk4() {
		
		GameRulesEngineBoImpl grebi3 = new GameRulesEngineBoImpl();
		RollDm rd3 = new RollDm();
		rd3.die1 = 1;
		rd3.die2 = 4;
		assertEquals(false, grebi3.isRollDeuceSkunk(rd3));
		
	}
	@Test
	public void testisRollDeuceSkunk5() {
		
		GameRulesEngineBoImpl grebi3 = new GameRulesEngineBoImpl();
		RollDm rd3 = new RollDm();
		rd3.die1 = 3;
		rd3.die2 = 1;
		assertEquals(false, grebi3.isRollDeuceSkunk(rd3));
		
	}
	
} 
