package edu.skunkApp.businessobject.Implementation;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;

import java.util.ArrayList;

//import org.junit.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mock;

import edu.skunkApp.common.di.SkunkAppModule;
import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollDm;

public class PlayerBoImplTest {
	
	@Test
	public void testcreate() {
		PlayerBoImpl pbi1 = new PlayerBoImpl();
		PlayerDm pb1 = new PlayerDm();
		pb1.name = "Eric";
		ArrayList<PlayerDm> players = new ArrayList<>();
		players.add(pb1);
		assertEquals(true, pbi1.create(players));
	}
	
	@Test
	public void testgetPlayers() {
		PlayerBoImpl pbi1 = new PlayerBoImpl();
		PlayerDm pb1 = new PlayerDm();
		pb1.name = "Eric";
		ArrayList<PlayerDm> players = new ArrayList<>();
		players.add(pb1);
		assertEquals(true, pbi1.getPlayers().add(pb1));
	}
	
	@Test
	public void testcanContinuePlay() {
		PlayerBoImpl pbi1 = new PlayerBoImpl();
		assertEquals(true, pbi1.canContinuePlay());
	}
	
	@Test
	public void testgetWinner() {
		PlayerBoImpl pbi1 = new PlayerBoImpl();
		PlayerDm pb1 = new PlayerDm();
		pb1.name = "Eric";
		pb1.isWinner = true;
		assertEquals(0, pbi1.getWinner().Score);
	}
	
	@Test
	public void testgetLosers() {
		PlayerBoImpl pbi1 = new PlayerBoImpl();
		PlayerDm pb1 = new PlayerDm();
		pb1.name = "Eric";
		pb1.isWinner = false;
		ArrayList<PlayerDm> players = new ArrayList<>();
		players.add(pb1);
		assertEquals(true, pbi1.getLosers().add(pb1));
	}
	
}
	
