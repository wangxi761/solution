package topic.heap;

public class UglyNumberII {
	public int nthUglyNumber(int n) {
		int[] dp = new int[n];
		int t2 = 0, t3 = 0, t5 = 0;
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.min(dp[t2] * 2, Math.min(dp[t3] * 3, dp[t5] * 5));
			if (dp[t2] * 2 == dp[i]) t2++;
			if (dp[t3] * 3 == dp[i]) t3++;
			if (dp[t5] * 5 == dp[i]) t5++;
		}
		return dp[dp.length - 1];
	}
}
