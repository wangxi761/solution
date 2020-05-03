package topic.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestNumberTest {
	LargestNumber test = new LargestNumber();
	
	@Test
	public void largestNumber() {
		assertEquals("9534330", test.largestNumber(new int[]{3, 30, 34, 5, 9}));
		assertEquals("210", test.largestNumber(new int[]{10, 2}));
	}
}