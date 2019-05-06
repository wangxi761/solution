package topic.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class BestTimetoBuyandSellStockTest {

	@Test
	public void testMaxProfit() {
		BestTimetoBuyandSellStock bestTimetoBuyandSellStock=new BestTimetoBuyandSellStock();
		assertEquals(5, bestTimetoBuyandSellStock.maxProfit(new int[] {7,1,5,3,6,4}));
		assertEquals(0, bestTimetoBuyandSellStock.maxProfit(new int[] {7,6,4,3,1}));
	}

}
