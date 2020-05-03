package study.dp;


import org.junit.jupiter.api.Test;

public class CoinProblem {

	public void charge(int[] coins, int sum) {
		int[][] dp = new int[coins.length+1][sum + 1];

		for (int i = 0; i < coins.length+1; i++) {
			dp[i][0] = 0;
		}
		for (int j = 1; j <= sum; j++) {
			dp[0][j] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < sum; j++) {
				if (coins[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else if (coins[i] == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] > dp[i][j - coins[i]] + 1 ? dp[i][j - coins[i]] + 1 : dp[i - 1][j];
				}
			}
		}
		print(dp);
	}
	public void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(String.format("%-20s", arr[i][j]+" "));
			}
			System.out.println();
		}
	}
	@Test
	public void test() throws Exception {
		charge(new int[] { 1, 3, 4 }, 6);
	}
}
