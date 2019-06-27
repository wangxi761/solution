package topic.Backtracking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfSquarefulArraysTest {
	NumberOfSquarefulArrays test = new NumberOfSquarefulArrays();
	
	@Test
	public void numSquarefulPerms() {
		assertEquals(1, test.numSquarefulPerms(new int[]{2, 2, 2}));
		assertEquals(2, test.numSquarefulPerms(new int[]{1, 17, 8}));
	}
}