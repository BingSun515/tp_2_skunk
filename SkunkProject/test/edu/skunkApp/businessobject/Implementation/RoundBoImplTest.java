package edu.skunkApp.businessobject.Implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.skunkApp.common.GameStatusEnum;

public class RoundBoImplTest {
	
	@Test
	public void testcreate() {
		RoundBoImpl rbi1 = new RoundBoImpl();
		rbi1.create();
	}
	
	@Test
	public void testcanProceedtoNextRound() {
		RoundBoImpl rbi1 = new RoundBoImpl();
		rbi1.canProceedToNextRound();
		assertEquals(GameStatusEnum.CONTINUE_ROLL,rbi1._gameRulesEngineBo.getGameStatus());
	}
	
	@Test
	public void testgetRounds() {
		RoundBoImpl rbi1 = new RoundBoImpl();
		rbi1.getRounds();
	}


}
