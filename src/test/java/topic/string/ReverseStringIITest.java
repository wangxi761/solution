package topic.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringIITest {
	ReverseStringII test = new ReverseStringII();
	
	@Test
	public void reverseStr() {
		assertEquals("bacdfeg", test.reverseStr("abcdefg", 2));
	}
}