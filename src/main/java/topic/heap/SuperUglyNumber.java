package topic.heap;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] dp = new int[n], idx = new int[primes.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				dp[i] = Math.min(dp[i], primes[j] * dp[idx[j]]);
			}
			for (int j = 0; j < primes.length; j++) {
				if (dp[i] == primes[j] * dp[idx[j]]) {
					idx[j]++;
				}
			}
		}
		return dp[dp.length - 1];
	}
	
}
