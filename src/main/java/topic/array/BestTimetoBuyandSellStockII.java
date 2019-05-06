package topic.array;

public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		int max=0;
		for (int i = 1; i < prices.length; i++) {
			int interval = prices[i]-prices[i-1];
			if(interval>0)
				max+=interval;
		}
		return max;
	}
}
