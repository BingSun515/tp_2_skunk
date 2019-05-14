package edu.skunkApp.businessobject.Implementation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

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


	
}