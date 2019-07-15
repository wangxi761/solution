package topic.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumCostForTicketsTest {
	MinimumCostForTickets test = new MinimumCostForTickets();
	
	@Test
	public void minCostTickets() {
	}
	
	@Test
	public void binarySearch() {
		int[] days = {1, 4, 6, 7, 8, 20};
		int res = test.lower_bound(days, 13, 0, days.length);
		assertEquals(4, res - 1);
//		assertEquals(0, Arrays.binarySearch(days,13));
	}
}