package topic.dp;

public class StoneGame {
	public boolean stoneGame1(int[] piles) {
		int[][] dp = new int[piles.length][piles.length];
		for (int d = 0; d < piles.length; d++) {
			for (int i = 0; i < piles.length - d; i++) {
				int j = i + d;
				if (i == j) {
					dp[i][j] = piles[i];
				} else {
					dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
				}
			}
		}
		return dp[0][dp.length - 1] >= 0;
	}
	
	//空间优化
	public boolean stoneGame(int[] piles) {
		int[] dp = new int[piles.length];
		for (int d = 0; d < piles.length; d++) {
			for (int i = 0; i < piles.length - d; i++) {
				int j = i + d;
				if (i == j) {
					dp[j] = piles[i];
				} else {
					dp[j] = Math.max(piles[i] - dp[j], piles[i] - dp[j - 1]);
				}
			}
		}
		return dp[dp.length - 1] >= 0;
	}
}