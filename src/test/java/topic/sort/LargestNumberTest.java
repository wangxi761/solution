package topic.sort;

import org.junit.Test;

public class LargestNumberTest {
	LargestNumber test = new LargestNumber();
	
	@Test
	public void largestNumber() {
		System.out.println(test.largestNumber(new int[]{35, 5, 1, 2, 4}));
	}
}