package edu.skunkApp.businessobject.Implementation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mock;

import edu.skunkApp.dataAccess.IPlayerDa;
import edu.skunkApp.domainModels.PlayerDm;
import edu.skunkApp.domainModels.RollDm;

public class PlayerBoImplTest {

	@Test
	public void createarraylist() {
		
		PlayerBoImpl pb1 = new PlayerBoImpl();
		PlayerDm pd1 = new PlayerDm();
		pd1.name = "Bing";
		ArrayList<PlayerDm> ap1 = new ArrayList<PlayerDm>() ;
   
		assertEquals(false,pb1.create(ap1));
		
		
		
	}


	@Test
	public void testgetplayer() {
		ArrayList<PlayerDm> ar1 = new ArrayList<PlayerDm>();
		PlayerDm player = new PlayerDm();
		player.name = "Eric";
		ar1.add(player);
		PlayerBoImpl pb1 = new PlayerBoImpl();
		
	}
	
	
	//#########################Mockito Test#######################
	@Test
	public void testcreate() {
		PlayerBoImpl pbi1 = new PlayerBoImpl();
		PlayerDm pd1 = new PlayerDm();
		ArrayList<PlayerDm> ar1 = new ArrayList<PlayerDm>();
		pd1.isWinner = true;
		ar1.add(pd1);
	}
	
	
	
	}
	
	//#########################Mockito Test#######################

	
