package topic.array;

public class BestTimetoBuyandSellStock {
	public int maxProfit1(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int[] dp = new int[prices.length];
		int min = prices[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return dp[dp.length - 1];
	}
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int min=prices[0],stock=0;
		for (int i = 1; i < prices.length; i++) {
			stock=Math.max(stock, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return stock;
	}
}
