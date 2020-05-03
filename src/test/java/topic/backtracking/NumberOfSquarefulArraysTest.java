package topic.Backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfSquarefulArraysTest {
	topic.backtracking.NumberOfSquarefulArrays test = new topic.backtracking.NumberOfSquarefulArrays();
	
	@Test
	public void numSquarefulPerms() {
		assertEquals(1, test.numSquarefulPerms(new int[]{2, 2, 2}));
		assertEquals(2, test.numSquarefulPerms(new int[]{1, 17, 8}));
	}
}