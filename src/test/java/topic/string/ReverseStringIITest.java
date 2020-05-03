package topic.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringIITest {
	ReverseStringII test = new ReverseStringII();
	
	@Test
	public void reverseStr() {
		assertEquals("bacdfeg", test.reverseStr("abcdefg", 2));
	}
}