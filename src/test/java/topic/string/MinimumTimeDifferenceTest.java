package topic.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinimumTimeDifferenceTest {
	MinimumTimeDifference test = new MinimumTimeDifference();
	
	@Test
	public void findMinDifference() {
		assertEquals(59, test.findMinDifference(Arrays.asList("01:01", "02:01", "03:00")));
		assertEquals(719, test.findMinDifference(Arrays.asList("12:12", "00:13")));
		assertEquals(1, test.findMinDifference(Arrays.asList("23:59", "00:00")));
		assertEquals(0, test.findMinDifference(Arrays.asList("00:00", "23:59", "00:00")));
		assertEquals(60, test.findMinDifference(Arrays.asList("01:01", "02:01")));
		assertEquals(1, test.findMinDifference(Arrays.asList("01:01", "02:01", "03:00", "03:01")));
	}
}
