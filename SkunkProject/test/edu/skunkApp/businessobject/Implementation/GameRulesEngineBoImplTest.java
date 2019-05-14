package edu.skunkApp.businessobject.Implementation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

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
		grebi1.moveChips(rsd1, ar1);
		assertEquals("Eric", pd1.name);
		
	}
	
	
	@Test
	public void testsetSkunkAndScore() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		
		
	}
	
	@Test
	public void testgetGameStatus() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		RollScoreDaImpl rsdi1 = new RollScoreDaImpl();

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
