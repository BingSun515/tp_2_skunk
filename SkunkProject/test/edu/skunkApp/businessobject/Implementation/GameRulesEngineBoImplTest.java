package edu.skunkApp.businessobject.Implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.skunkApp.common.SkunkEnum;
import edu.skunkApp.dataAccess.Implementation.KittyDaImpl;
import edu.skunkApp.domainModels.RollDm;
import edu.skunkApp.domainModels.RollScoreDm;

public class GameRulesEngineBoImplTest {
	
	@Test
	public void testGameRulesEngineBoImpl() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		
		assertEquals(false, grebi1.getGameStatus(87));
		
		assertEquals(true, grebi1.getGameStatus(101));
		
	}
	
	@Test
	public void testisRollSingleSkunk1() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollDm rd1 = new RollDm();
		rd1.die1 = 1;
		rd1.die2 = 3;
		rd1.diceTotal = 4;
		assertEquals(true, grebi1.isRollSingleSkunk(rd1));
		
	}
	
	
	
	@Test
	public void testisRollSingleSkunk2() {
		
		GameRulesEngineBoImpl grebi2 = new GameRulesEngineBoImpl();
		RollDm rd2 = new RollDm();
		rd2.die1 = 2;
		rd2.die2 = 2;
		rd2.diceTotal = 4;
		assertEquals(false, grebi2.isRollSingleSkunk(rd2));
		
	}
	
	@Test
	public void testisRollSingleSkunk3() {
		
		GameRulesEngineBoImpl grebi2 = new GameRulesEngineBoImpl();
		RollDm rd2 = new RollDm();
		rd2.die1 = 1;
		rd2.die2 = 2;
		rd2.diceTotal = 4;
		assertEquals(false, grebi2.isRollSingleSkunk(rd2));
		
	}
	
	@Test
	public void testisRollSingleSkunk4() {
		
		GameRulesEngineBoImpl grebi2 = new GameRulesEngineBoImpl();
		RollDm rd2 = new RollDm();
		rd2.die1 = 2;
		rd2.die2 = 2;
		rd2.diceTotal = 4;
		assertEquals(false, grebi2.isRollSingleSkunk(rd2));
		
	}
	
	
	@Test
	public void testisRollDoubleSkunk() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollDm rd1 = new RollDm();
		rd1.die1 = 1;
		rd1.die2 = 1;
		rd1.diceTotal = 2;
		assertEquals(true, grebi1.isRollDoubleSkunk(rd1));
		
	}
	
	
	

}
