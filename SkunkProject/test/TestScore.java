import static org.junit.Assert.*;

import org.junit.Test;

public class TestScore {
	
	@Test
	public void Score() {
		Score s1 = new Score();
		assertEquals(s1.getTurnScore(), 0);
		assertEquals(s1.getChipChangeScore(), 0);
		assertEquals(s1.getKittyChangeScore(), 0);
	}

	@Test
	public void ScoreInt() {
		Score s1 = new Score(100);
		assertEquals(s1.getTurnScore(), 100);
	}
	
	@Test
	public void ScorewithThreeInt() {
		Score s1 = new Score(50,100,150);
		assertEquals(s1.getTurnScore(), 50);
		assertEquals(s1.getChipChangeScore(), 100);
		assertEquals(s1.getKittyChangeScore(), 150);
	}
	
	@Test
	public void setTurnScore() {
		Score s1 = new Score(50,100,150);
		s1.setTurnScore(1, 2, 3);
		assertEquals(s1.getTurnScore(), 51);
		assertEquals(s1.getChipChangeScore(), 102);
		assertEquals(s1.getKittyChangeScore(), 153);
	}

}
