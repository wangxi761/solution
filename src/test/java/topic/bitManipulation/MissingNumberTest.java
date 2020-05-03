package topic.bitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumberTest {
	MissingNumber test = new MissingNumber();
	
	@Test
	public void missingNumber() {
		assertEquals(2, test.missingNumber(new int[]{3, 0, 1}));
		assertEquals(8, test.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
		assertEquals(33, test.missingNumber(new int[]{44, 26, 34, 25, 23, 42, 0, 43, 38, 14, 47, 19, 49, 6, 16, 41, 24, 35, 10, 4, 32, 5, 8, 15, 31, 3, 46, 22, 2, 30, 28, 37, 1, 21, 39, 45, 9, 48, 36, 17, 7, 27, 18, 29, 13, 40, 11, 20, 12}));
		
	}
}