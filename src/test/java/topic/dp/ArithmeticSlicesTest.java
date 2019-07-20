package topic.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticSlicesTest {
	ArithmeticSlices test = new ArithmeticSlices();
	
	@Test
	public void numberOfArithmeticSlices() {
		assertEquals(3, test.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
	}
}