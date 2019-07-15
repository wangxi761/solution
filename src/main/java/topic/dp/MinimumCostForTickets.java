package topic.dp;

public class MinimumCostForTickets {
	public int minCostTickets(int[] days, int[] costs) {
		int[] dp = new int[days.length + 1];
		
		return dp[days.length];
	}
	
	public int lower_bound(int[] arr, int target, int start, int end) {
		int lo = start, hi = end;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
}
