package topic.dp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StoneGameTest {
	StoneGame test = new StoneGame();
	
	@Test
	public void stoneGame() {
		assertTrue(test.stoneGame(new int[]{5, 3, 4, 5}));
	}
}