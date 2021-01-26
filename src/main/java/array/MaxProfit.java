package array;

public class MaxProfit {
	public int maxProfit(int[] prices) {
		int max = 0;
		if (prices.length == 1) {
			return max;
		}
		
		int i = 0, j = 1;
		while (j < prices.length) {
			while (j < prices.length && prices[j-1] <= prices[j]) j++;
			max += prices[j - 1] - prices[i];
			i = j;
			j = i + 1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 4, 6, 5, 4, 3, 2};
		MaxProfit maxProfit = new MaxProfit();
		int res = maxProfit.maxProfit(arr);
		System.out.println(res);
	}
}
