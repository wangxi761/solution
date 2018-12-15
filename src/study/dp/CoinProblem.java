package study.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinProblem {

	public void charge(int[] coins, int sum) {
		int[][] dp = new int[coins.length][sum + 1];

		for (int i = 0; i < coins.length; i++) {
			dp[i][0] = 0;
		}
		for (int j = 1; j <= sum; j++) {
			dp[0][j] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < coins.length; i++) {
			for (int j = 1; j < sum; j++) {
				if (coins[i] > j) {
					dp[i][j] = dp[i - 1][j];
					continue;
				}
				dp[i][j] = dp[i - 1][j] > dp[i][j - coins[i]] + 1 ? dp[i][j - coins[i]] + 1 : dp[i - 1][j];
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < sum+1; j++) {
				
			}
		}
	}

	@Test
	public void test() throws Exception {
		charge(new int[] { 1, 3, 4 }, 6);
	}
}
