package topic.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerOfFourTest {
	PowerOfFour test = new PowerOfFour();
	
	@Test
	public void isPowerOfFour() {
		assertTrue(test.isPowerOfFour(4));
		assertTrue(test.isPowerOfFour(1));
		assertTrue(test.isPowerOfFour(16));
	}
}