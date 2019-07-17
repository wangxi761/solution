package topic.dp;

public class MinimumCostForTickets {
	public int minCostTickets(int[] days, int[] costs) {
		boolean[] used = new boolean[366];
		for (int i = 0; i < days.length; i++) {
			used[days[i]] = true;
		}
		int[] dp = new int[366];
		for (int i = 1; i < dp.length; i++) {
			if (!used[i]) {
				dp[i] = dp[i - 1];
				continue;
			}
			int min = dp[i - 1] + costs[0];
			
			min = Math.min(min, dp[Math.max(0, i - 7)] + costs[1]);
			min = Math.min(min, dp[Math.max(0, i - 30)] + costs[2]);
			dp[i] = min;
		}
		return dp[days[days.length - 1]];
	}
	
	
	public int upper_bound(int[] arr, int target, int start, int end) {
		int lo = start, hi = end;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] <= target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
}
