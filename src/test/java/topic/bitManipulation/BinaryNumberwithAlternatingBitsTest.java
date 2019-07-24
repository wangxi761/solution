package topic.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryNumberwithAlternatingBitsTest {
	BinaryNumberwithAlternatingBits test = new BinaryNumberwithAlternatingBits();
	
	@Test
	public void hasAlternatingBits() {
		assertTrue(test.hasAlternatingBits(5));
		assertTrue(test.hasAlternatingBits(10));
		assertFalse(test.hasAlternatingBits(7));
		assertFalse(test.hasAlternatingBits(11));
	}
}