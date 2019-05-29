package topic.string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinimumTimeDifferenceTest {
	MinimumTimeDifference test = new MinimumTimeDifference();
	
	@Test
	public void findMinDifference() {
		assertEquals(1, test.findMinDifference(Arrays.asList("23:59", "00:00")));
	}
}