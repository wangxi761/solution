package study.dp.pack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZeroOnePackTest {
	ZeroOnePack test = new ZeroOnePack();
	
	@Test
	public void packSolution() {
		assertEquals(10, test.packSolution1(new int[]{3, 4, 5, 6}, new int[]{2, 3, 4, 5}, 8));
		assertEquals(10, test.packSolution2(new int[]{3, 4, 5, 6}, new int[]{2, 3, 4, 5}, 8));
		assertEquals(10, test.packSolution3(new int[]{3, 4, 5, 6}, new int[]{2, 3, 4, 5}, 8));
		assertEquals(10, test.packSolution4(new int[]{3, 4, 5, 6}, new int[]{2, 3, 4, 5}, 8));
	}
}