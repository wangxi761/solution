package topic.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumCostForTicketsTest {
	MinimumCostForTickets test = new MinimumCostForTickets();
	
	@Test
	public void minCostTickets() {
		int[] days = {1, 4, 6, 7, 8, 20};
		int[] costs = {2, 7, 15};
		assertEquals(11, test.minCostTickets(days, costs));
	}
	
	
}