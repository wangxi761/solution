package topic.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotatedDigitsTest {
	RotatedDigits test = new RotatedDigits();
	
	@Test
	public void rotatedDigits() {
		assertEquals(4, test.rotatedDigits(10));
		assertEquals(247, test.rotatedDigits(857));
		
	}
}