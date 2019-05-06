package topic.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class BestTimetoBuyandSellStockIITest {

	@Test
	public void testMaxProfit() {
		BestTimetoBuyandSellStockII bestTimetoBuyandSellStockII = new BestTimetoBuyandSellStockII();
		assertEquals(7, bestTimetoBuyandSellStockII
				.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		assertEquals(4, bestTimetoBuyandSellStockII
				.maxProfit(new int[]{1, 2, 3, 4, 5}));
		assertEquals(0, bestTimetoBuyandSellStockII
				.maxProfit(new int[]{7, 6, 4, 3, 1}));

	}

}
