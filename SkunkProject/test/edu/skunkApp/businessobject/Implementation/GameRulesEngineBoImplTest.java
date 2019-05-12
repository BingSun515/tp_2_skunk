package edu.skunkApp.businessobject.Implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.skunkApp.dataAccess.Implementation.KittyDaImpl;
import edu.skunkApp.domainModels.RollDm;

public class GameRulesEngineBoImplTest {
	
	@Test
	public void testGameRulesEngineBoImpl() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		
		assertEquals(false, grebi1.getGameStatus(87));
		
		assertEquals(true, grebi1.getGameStatus(101));
		
	}
	
	@Test
	public void testisRollSingleSkunk() {
		
		GameRulesEngineBoImpl grebi1 = new GameRulesEngineBoImpl();
		
		
		assertEquals(false, grebi1.isRollSingleSkunk(null));
		
		assertEquals(true, grebi1.getGameStatus(101));
		
	}
	
	

}
