package topic.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountBinarySubstringsTest {
	CountBinarySubstrings test = new CountBinarySubstrings();
	
	@Test
	public void countBinarySubstrings() {
		assertEquals(6, test.countBinarySubstrings("00110011"));
		assertEquals(4, test.countBinarySubstrings("10101"));
		assertEquals(4, test.countBinarySubstrings("1010001"));
		
	}
}