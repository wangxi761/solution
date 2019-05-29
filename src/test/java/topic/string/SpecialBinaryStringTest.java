package topic.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpecialBinaryStringTest {
	SpecialBinaryString test = new SpecialBinaryString();
	
	@Test
	public void makeLargestSpecial() {
		assertEquals("11100100", test.makeLargestSpecial("11011000"));
	}
}