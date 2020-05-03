package topic.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SmallestRangeTest {
	SmallestRange test = new SmallestRange();
	
	@Test
	public void smallestRange() {
		int[] range = test.smallestRange(Arrays.asList(Arrays.asList(4, 10, 15, 24, 26), Arrays.asList(0, 9, 12, 20), Arrays.asList(5, 18, 22, 30)));
		System.out.println(Arrays.toString(range));
	}
}