package topic.sort;

import org.junit.Assert;
import org.junit.Test;

public class LargestNumberTest {
	LargestNumber test = new LargestNumber();
	
	@Test
	public void largestNumber() {
		Assert.assertEquals("9534330", test.largestNumber(new int[]{3, 30, 34, 5, 9}));
		Assert.assertEquals("210", test.largestNumber(new int[]{10, 2}));
	}
}