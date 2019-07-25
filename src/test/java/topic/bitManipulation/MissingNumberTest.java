package topic.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {
	MissingNumber test = new MissingNumber();
	
	@Test
	public void missingNumber() {
		assertEquals(2, test.missingNumber(new int[]{3, 0, 1}));
		assertEquals(8, test.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
	}
}