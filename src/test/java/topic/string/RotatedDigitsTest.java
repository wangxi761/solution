package topic.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotatedDigitsTest {
	RotatedDigits test = new RotatedDigits();
	
	@Test
	public void rotatedDigits() {
		assertEquals(4, test.rotatedDigits(10));
		assertEquals(247, test.rotatedDigits(857));
		
	}
}